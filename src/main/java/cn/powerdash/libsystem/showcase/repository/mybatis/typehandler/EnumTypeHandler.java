package cn.powerdash.libsystem.showcase.repository.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import cn.powerdash.libsystem.common.enums.PageEnum;

/**
 * {@code BaseTypeHandler} for enum type.
 * 
 * @author SC
 * 
 */
public class EnumTypeHandler<T extends PageEnum> extends BaseTypeHandler<T> {

    private final T[] enums;

    public EnumTypeHandler() {
        this.enums = null;
    }

    public EnumTypeHandler(Class<T> type) {
        if (type == null)
            throw new IllegalArgumentException("Type argument cannot be null");
        this.enums = type.getEnumConstants();
        if (this.enums == null)
            throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, PageEnum parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String code = rs.getString(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return locateEnum(code);
        }

    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String code = rs.getString(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return locateEnum(code);
        }

    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String code = cs.getString(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            return locateEnum(code);
        }
    }

    private T locateEnum(String code) {
        for (T e : enums) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        return null;
    }

}
