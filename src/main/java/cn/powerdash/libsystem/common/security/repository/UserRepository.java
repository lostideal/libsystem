package cn.powerdash.libsystem.common.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.powerdash.libsystem.common.security.domain.User;

/**
 * 
 * 
 * @author SC
 *
 */
public interface UserRepository extends JpaRepository<User, String> {

}
