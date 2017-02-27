package cn.powerdash.libsystem.showcase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.powerdash.libsystem.showcase.domain.Product;

/**
 * 
 * 
 * @author SC
 *
 */
public interface ProductRepository extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {

}
