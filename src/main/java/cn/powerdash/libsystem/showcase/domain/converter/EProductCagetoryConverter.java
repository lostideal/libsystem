package cn.powerdash.libsystem.showcase.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import cn.powerdash.libsystem.common.util.EnumHelper;
import cn.powerdash.libsystem.showcase.enums.EProductCagetory;

/**
 * 
 * 
 * @author SC
 *
 */
@Converter
public class EProductCagetoryConverter implements AttributeConverter<EProductCagetory, String> {

    @Override
    public String convertToDatabaseColumn(EProductCagetory attribute) {
        return attribute.getCode();
    }

    @Override
    public EProductCagetory convertToEntityAttribute(String dbData) {
        return EnumHelper.translate(EProductCagetory.class, dbData);
    }

}
