package com.hivetech.mvc.service.impl;

import com.hivetech.mvc.constant.SystemConstant;
import com.hivetech.mvc.entity.UserEntity;
import com.hivetech.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
  @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
        if(userEntity == null){
            throw new UsernameNotFoundException("User not found");
        }
        //put
        return null;
    }
}
