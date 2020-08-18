package com.hivetech.mvc.repository;

import com.hivetech.mvc.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findOneByUserNameAndStatus(String name ,Integer status);
}
