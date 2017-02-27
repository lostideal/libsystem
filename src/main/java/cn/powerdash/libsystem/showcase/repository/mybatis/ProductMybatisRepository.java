package cn.powerdash.libsystem.showcase.repository.mybatis;

import cn.powerdash.libsystem.showcase.domain.Product;

/**
 * 
 * 
 * @author SC
 *
 */
public interface ProductMybatisRepository {

    Product findOne(String productId);

}
