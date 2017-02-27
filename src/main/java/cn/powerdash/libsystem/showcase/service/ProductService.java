package cn.powerdash.libsystem.showcase.service;

import cn.powerdash.libsystem.common.dto.widget.DataTablesResponseDto;
import cn.powerdash.libsystem.showcase.domain.Product;
import cn.powerdash.libsystem.showcase.dto.upstream.ProductSearchDto;

/**
 * 
 * 
 * @author SC
 *
 */
public interface ProductService {

    /**
     * Description: find a product
     *
     * @param id
     * @return
     */
    Product findProductById(String id);

    /**
     * Description: save a product
     *
     * @param product
     * @return
     */
    Product saveProduct(Product product);

    /**
     * Description: delete a product
     *
     * @param id
     */
    void deleteProduct(String id);

    /**
     * Description: search for products
     *
     * @param searchDto
     * @return
     */
    DataTablesResponseDto<Product> searchProduct(final ProductSearchDto searchDto);

}
