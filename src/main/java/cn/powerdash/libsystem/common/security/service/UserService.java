package cn.powerdash.libsystem.common.security.service;

import cn.powerdash.libsystem.common.security.domain.User;

/**
 * 
 * 
 * @author SC
 *
 */
public interface UserService {

    User findUserByUserName(String userName);

}
