package cn.powerdash.libsystem.showcase.repository.mybatis.typehandler;

import org.apache.ibatis.type.MappedTypes;

import cn.powerdash.libsystem.showcase.enums.EProductCagetory;

@MappedTypes(EProductCagetory.class)
public class EProductCagetoryHandler extends EnumTypeHandler<EProductCagetory> {

    public EProductCagetoryHandler(Class<EProductCagetory> type) {
        super(type);
    }

}
