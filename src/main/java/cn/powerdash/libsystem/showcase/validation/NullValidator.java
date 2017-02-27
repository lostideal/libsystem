package cn.powerdash.libsystem.showcase.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cn.powerdash.libsystem.common.validation.BaseValidator;

/**
 * 
 * 
 * @author SC
 *
 */
public class NullValidator extends BaseValidator implements ConstraintValidator<NullCheck, Object> {

    @Override
    public void initialize(NullCheck check) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return true;
    }

}
