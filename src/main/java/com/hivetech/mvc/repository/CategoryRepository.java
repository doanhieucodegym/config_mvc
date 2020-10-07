package com.hivetech.mvc.repository;

import com.hivetech.mvc.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
        CategoryEntity findByCode(String code);
}
