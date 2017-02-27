/*
 * Project Name: libsystem
 * File Name: BaseController.java
 * Class Name: BaseController
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

package cn.powerdash.libsystem.common.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import cn.powerdash.libsystem.common.constant.ApplicationConstant;

/**
 * all controller should extend this base class
 * 
 * @author SC
 * 
 */

public abstract class AbstractController {

    /**
     * Description: get all static options from a enum object for display.
     * 
     * @param enumClass
     * @return
     */

    @Autowired
    private LocalValidatorFactoryBean validator;

    protected void validate(final Object validatedObj, final Class<?>[] groups) {
        final Set<ConstraintViolation<Object>> constraintViolations = validator.validate(validatedObj, groups);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(ApplicationConstant.MANUAL_VALIDATE, constraintViolations);
        }
    }

}
