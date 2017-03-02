package cn.powerdash.libsystem.book.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import cn.powerdash.libsystem.common.enums.PageEnum;
import cn.powerdash.libsystem.common.util.PageEnumSerializer;

@JsonSerialize(using = PageEnumSerializer.class)
public enum EBookCagetory implements PageEnum {
    BIRDS("B", "Birds"), FISH("F", "Fish"), DOGS("D", "Dogs"), REPTILES("R", "Reptiles"), CATS("C", "Cats");

    private String code;

    private String text;

    EBookCagetory(String code, String text) {
        this.code = code;
        this.text = text;
    }

    @Override
    public String getText() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setText(String text) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCode(String code) {
        // TODO Auto-generated method stub

    }

}
