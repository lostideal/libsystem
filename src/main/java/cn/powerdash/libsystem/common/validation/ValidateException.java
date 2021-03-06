/*
 * Project Name: libsystem
 * File Name: ValidateException.java
 * Class Name: ValidateException
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

package cn.powerdash.libsystem.common.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;

/**
 * Class Name: ValidateException
 * <p>
 * Description: the validate exception, <br>
 * the exception will wrap the <code>Erros</code> list which thrown from service or any facade
 * 
 * @author SC
 * 
 */

public class ValidateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final List<BindingResult> bindingResults;

    public List<BindingResult> getBindingResults() {
        return bindingResults;
    }

    public ValidateException(final List<BindingResult> bindingResults) {
        this.bindingResults = bindingResults;
    }

    public ValidateException(final BindingResult bindingResult) {
        bindingResults = new ArrayList<BindingResult>();
        bindingResults.add(bindingResult);
    }

    @Override
    public String getMessage() {
        final StringBuilder sb = new StringBuilder("bindingResults string:");
        for (BindingResult bindingResult : bindingResults) {
            sb.append(bindingResult.toString()).append(",");
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return this.bindingResults.hashCode();
    }

    /**
     * 
     * Description: TODO
     * 
     * @param bindingResult
     * @return
     */
    public boolean hasErrors(final BindingResult bindingResult) {
        return bindingResult.hasErrors();
    }

    /**
     * 
     * Description: TODO
     * 
     * @return
     */
    public boolean hasErrors() {
        if (bindingResults != null && bindingResults.size() > 0) {
            for (BindingResult bindingResult : bindingResults) {
                if (bindingResult.hasErrors()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     * Description: TODO
     * 
     * @param bindingResult
     * @return
     */
    public BindingResult getError(final BindingResult bindingResult) {
        return bindingResult;
    }

    /**
     * 
     * Description: TODO
     * 
     * @return
     */
    public List<BindingResult> getErrors() {
        List<BindingResult> errors = new ArrayList<BindingResult>();
        if (bindingResults != null && bindingResults.size() > 0) {
            for (BindingResult bindingResult : bindingResults) {
                if (bindingResult.hasErrors()) {
                    errors.add(bindingResult);
                }
            }
        }
        return errors;
    }

    /**
     * 
     * Description: TODO
     * 
     * @param bindingResult
     * @return
     */
    public int getErrorCount(final BindingResult bindingResult) {
        return bindingResult.getErrorCount();
    }

    /**
     * 
     * Description: TODO
     * 
     * @return
     */
    public int getErrorCount() {
        int errorCount = 0;
        if (bindingResults != null && bindingResults.size() > 0) {
            for (BindingResult bindingResult : bindingResults) {
                if (bindingResult.hasErrors()) {
                    errorCount += bindingResult.getErrorCount();
                }
            }
        }
        return errorCount;
    }
}
