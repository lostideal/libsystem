package cn.powerdash.libsystem.showcase.dto.upstream;

import java.io.Serializable;

import cn.powerdash.libsystem.common.dto.widget.DataTablesRequestDto;

/**
 * 
 * 
 * @author SC
 *
 */
public class ProductSearchDto extends DataTablesRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关键字
     */
    private String keyword;

    private String category;

    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword
     *            the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category
     *            the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

}
