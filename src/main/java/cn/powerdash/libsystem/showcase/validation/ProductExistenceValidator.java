package cn.powerdash.libsystem.showcase.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cn.powerdash.libsystem.common.validation.BaseValidator;
import cn.powerdash.libsystem.showcase.domain.Product;
import cn.powerdash.libsystem.showcase.service.ProductService;

/**
 * Customized validator.
 * 
 * @author SC
 *
 */
public class ProductExistenceValidator extends BaseValidator implements
        ConstraintValidator<ProductExistenceCheck, String> {

    @Autowired
    private ProductService productService;

    @Override
    public void initialize(ProductExistenceCheck check) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Product product = productService.findProductById(value);
        return product == null;
    }

}
