/*
 * Project Name: libsystem
 * File Name: LegacyPasswordException.java
 * Class Name: LegacyPasswordException
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

package cn.powerdash.libsystem.common.security.authc;

/**
 * 
 * 
 * @author SC
 *
 */
public class LegacyPasswordMatchException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * LegacyPasswordMatchException Constructor
     *
     */
    public LegacyPasswordMatchException() {
        super();
    }

    /**
     * LegacyPasswordMatchException Constructor
     *
     * @param message
     */
    public LegacyPasswordMatchException(String message) {
        super(message);
    }

}
