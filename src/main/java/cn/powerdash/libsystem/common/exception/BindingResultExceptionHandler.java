package cn.powerdash.libsystem.common.exception;

/*
 * Project Name: libsystem
 * File Name: ExceptionHandler.java
 * Class Name: ExceptionHandler
 *
 * Copyright 2014 Hengtian Software Inc
 *
 * 
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

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.method.HandlerMethod;

import cn.powerdash.libsystem.common.dto.ResultDto;
import cn.powerdash.libsystem.common.dto.ValidationResultDto;
import cn.powerdash.libsystem.common.util.MessageUtil;
import cn.powerdash.libsystem.common.validation.ValidateException;

/**
 * Class Name: BindingResultExceptionHandler
 * <p>
 * Description: the <code>ValidateException</code> handler<br>
 * the validation from service will be wrapped into <code>ValidateException</code>, then the handler will catch the
 * exception and return the errors into view
 * 
 * @author SC
 * 
 */
@Service
public class BindingResultExceptionHandler extends AbstractExceptionHandler {

    /**
     * 
     * Description: set the validation data.
     * 
     * @param bindingResults
     * @param handler
     * @param formId
     * @param error
     * @param locale
     */
    @Override
    protected void setValidationErrorData(final Exception ex, final Object handler, final String formId,
            ResultDto<List<ValidationResultDto>> error) {
        ValidateException vex = (ValidateException) ex;
        List<BindingResult> bindingResults = vex.getBindingResults(); // get those bindingResults
        final List<ValidationResultDto> errorData = error.getData();
        if (StringUtils.isNotEmpty(formId) && bindingResults != null && bindingResults.size() > 0
                && handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // method parameter arrays
            MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
            if (methodParameters != null && methodParameters.length > 0) {
                for (BindingResult bindingResult : bindingResults) {
                    Class<?> doaminClass = bindingResult.getTarget().getClass();
                    for (MethodParameter methodParameter : methodParameters) {
                        Class<?> dtoClass = methodParameter.getParameterType();
                        if (!dtoClass.equals(doaminClass)) {
                            continue;
                        } else if (doaminClass.equals(dtoClass)) {
                            setResultDto(bindingResult, errorData, formId, false);
                        }
                    }
                }
            } else {
                for (BindingResult bindingResult : bindingResults) {
                    setResultDto(bindingResult, errorData, formId, true);
                }
            }
        }
    }

    /**
     * 
     * Description: set the result dto
     * 
     * @param locale
     * 
     * @param constraintViolation
     * @throws NoSuchFieldException
     */
    private void setResultDto(BindingResult bindingResult, List<ValidationResultDto> errorData, String formId,
            boolean notManually) {
        List<FieldError> fieldErros = bindingResult.getFieldErrors();
        String beanName = bindingResult.getObjectName();
        Object rootObject = bindingResult.getTarget();
        Class<?> rootClass = rootObject.getClass();
        if (fieldErros != null && fieldErros.size() > 0) {
            for (FieldError fieldError : fieldErros) {
                final String fieldName = fieldError.getField();
                String message = fieldError.getDefaultMessage();
                final String errorCode = fieldError.getCode();
                if (StringUtils.isEmpty(message)) {
                    message = MessageUtil.getMessage(StringUtils.isNotEmpty(errorCode) ? errorCode : message);
                }
                setFieldErrorMap(fieldName, beanName, rootClass, errorData, message, formId, notManually);
            }
        }
    }
}
