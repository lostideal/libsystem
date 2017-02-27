package cn.powerdash.libsystem.common.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.powerdash.libsystem.common.security.domain.User;
import cn.powerdash.libsystem.common.security.repository.UserRepository;
import cn.powerdash.libsystem.common.security.service.UserService;

/**
 * 
 * 
 * @author SC
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findOne(userName);
    }

}
