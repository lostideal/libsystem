/*
 * Project Name: libsystem
 * File Name: SecurityContext.java
 * Class Name: SecurityContext
 *
 * Copyright 2014 Hengtian Software Inc
 *
 * Licensed under the Hengtiansoft
 *
 * http://www.hengtiansoft.com
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.powerdash.libsystem.common.security;

import java.util.Collection;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.CachingSecurityManager;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.powerdash.libsystem.common.security.authc.ShiroJdbcRealm;
import cn.powerdash.libsystem.common.security.domain.User;
import cn.powerdash.libsystem.common.security.service.UserService;
import cn.powerdash.libsystem.common.util.AppConfigUtil;
import cn.powerdash.libsystem.common.util.ApplicationContextUtil;

/**
 * 
 * 
 * @author SC
 * 
 */
public class SecurityContext {

    private static final String USER_KEY = "shiro.user";

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityContext.class);

    private static final String CACHE_NAME_AUTHZ = "cache.name.authz";

    private static final String CACHE_NAME_AUTHC = "cache.name.authc";

    /**
     * Description: 获取当前用户的基本信息。
     * 
     * @return
     */
    public static User getCurrentUser() {
        Subject subject = getSubject();
        if (subject == null) {
            return null;
        }
        return (User) subject.getSession().getAttribute(USER_KEY);
    }

    /**
     * Description: 是否已登录
     * 
     * @return
     */
    public static boolean isAuthenticated() {
        Subject subject = getSubject();
        if (subject == null) {
            return false;
        }
        return getSubject().isAuthenticated();
    }

    /**
     * Description: 登录验证该用户名, 登陆登陆成功后会创建新的会话。
     * 
     * @param userId
     * @param password
     * @return the new session
     * @throws IncorrectCredentialsException
     *             密码错误
     * @throws LockedAccountException
     *             登陆失败次数过多导致账户被锁
     */
    public static Session login(String userName, String password) throws IncorrectCredentialsException,
            LockedAccountException {
        long start = System.currentTimeMillis();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        Subject currentUser = SecurityUtils.getSubject();
        // This is to prevent session fixation attack, see: https://issues.apache.org/jira/browse/SHIRO-170
        currentUser.getSession().stop();
        // this will create a new session by default in applications that allow session state:
        currentUser.login(token);
        Session session = currentUser.getSession();
        LOGGER.debug("User {} login successfully, session id {}", userName, session.getId());
        UserService userService = ApplicationContextUtil.getBean(UserService.class);
        User user = userService.findUserByUserName(userName);
        session.setAttribute(USER_KEY, user);
        long end = System.currentTimeMillis();
        LOGGER.debug("login() completed for user {}, total time spent: {}ms", userName, end - start);
        return session;
    }

    /**
     * 登出当前用户
     */
    public static void logout() {
        getSubject().logout();
    }

    /**
     * Description: 清除指定用户的授权信息缓存。
     * 
     * @param userId
     */
    public static void clearAuthzCache(String userName) {
        RealmSecurityManager sm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        for (Realm realm : sm.getRealms()) {
            if (realm instanceof ShiroJdbcRealm) {
                ShiroJdbcRealm jdbcRealm = (ShiroJdbcRealm) realm;
                SimplePrincipalCollection spc = new SimplePrincipalCollection(userName, realm.getName());
                jdbcRealm.clearAuthorizationCache(spc);
            }
        }
        LOGGER.info("Authorization cache cleared for user: {}", userName);
    }

    /**
     * Description: 清除指定用户列表的授权信息缓存。
     * 
     * @param users
     */
    public static void clearAuthzCache(List<String> users) {
        for (String user : users) {
            clearAuthzCache(user);
        }
    }

    /**
     * Description: 清除所有用户的授权信息缓存。
     * 
     * @param users
     */
    public static void clearAllAuthzCache() {
        CacheManager cm = (CacheManager) ((CachingSecurityManager) SecurityUtils.getSecurityManager())
                .getCacheManager();
        cm.getCache(AppConfigUtil.getConfig(CACHE_NAME_AUTHZ)).clear();
    }

    /**
     * Description: 清除指定用户的认证信息缓存。
     * 
     * @param userId
     */
    public static void clearAuthcCache(String userName) {
        RealmSecurityManager sm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        for (Realm realm : sm.getRealms()) {
            if (realm instanceof ShiroJdbcRealm) {
                ShiroJdbcRealm jdbcRealm = (ShiroJdbcRealm) realm;
                SimplePrincipalCollection spc = new SimplePrincipalCollection(userName, realm.getName());
                jdbcRealm.clearAuthenticationCache(spc);
            }
        }
    }

    /**
     * Description: 清除指定用户list的认证信息缓存。
     * 
     * @param users
     */
    public static void clearAuthcCache(List<String> users) {
        for (String user : users) {
            clearAuthcCache(user);
        }
    }

    /**
     * Description: 清除所有用户的认证信息缓存。
     * 
     * @param users
     */
    public static void clearAllAuthcCache() {
        CacheManager cm = (CacheManager) ((CachingSecurityManager) SecurityUtils.getSecurityManager())
                .getCacheManager();
        cm.getCache(AppConfigUtil.getConfig(CACHE_NAME_AUTHC)).clear();
    }

    /**
     * Description: 清除当前用户的授权信息缓存
     * 
     */
    public static void clearCurrentAuthzCache() {
        clearAuthzCache(getSubject().getPrincipal().toString());
    }

    /**
     * Description: 验证当前用户是否拥有该权限。
     * 
     * @param permission
     * @return
     */
    public static boolean hasPermission(String permission) {
        Subject subject = getSubject();
        return subject == null ? false : subject.isPermitted(permission);
    }

    /**
     * Description: 验证当前用户是否拥有所有以下权限。
     * 
     * @param permissions
     * @return
     */
    public static boolean hasAllPermissions(String... permissions) {
        Subject subject = getSubject();
        return subject == null ? false : subject.isPermittedAll(permissions);
    }

    /**
     * Description: 验证当前用户是否拥有以下任意一个权限
     * 
     * @param permissions
     * @return
     */
    public static boolean hasAnyPermission(String[] permissions) {
        Subject subject = getSubject();
        if (subject != null && permissions != null) {
            for (int i = 0; i < permissions.length; i++) {
                String permission = permissions[i];
                if (permission != null && subject.isPermitted(permission.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 检查是否有权限，若无则抛出异常。
     * 
     * @see org.apache.shiro.subject.Subject#checkPermission(String permission)
     * @param permission
     * @throws AuthorizationException
     */
    public static void checkPermission(String permission) throws AuthorizationException {
        Subject subject = getSubject();
        if (subject == null) {
            throw new AuthorizationException("No permission as there is no subject bound.");
        }
        subject.checkPermission(permission);
    }

    /**
     * Description: 验证当前用户是否属于以下所有角色。请通过权限而不是角色做判断，比如hasPermission。
     * 
     * @param roles
     * @return
     */
    @Deprecated
    public static boolean hasAllRoles(Collection<String> roles) {
        return getSubject().hasAllRoles(roles);
    }

    /**
     * Description: 验证当前用户是否属于以下任意一个角色。请通过权限而不是角色做判断，比如hasPermission。
     * 
     * @param roleNames
     * @return
     */
    @Deprecated
    public static boolean hasAnyRoles(Collection<String> roleNames) {
        Subject subject = getSubject();
        if (subject != null && roleNames != null) {
            for (String role : roleNames) {
                if (role != null && subject.hasRole(role)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Subject getSubject() {
        try {
            return SecurityUtils.getSubject();
        } catch (Exception e) {
            LOGGER.warn("Failed to get Subject, maybe user is not login or session is lost:", e);
            return null;
        }
    }

}
