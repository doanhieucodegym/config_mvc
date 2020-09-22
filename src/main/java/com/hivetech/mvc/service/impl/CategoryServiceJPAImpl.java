package com.hivetech.mvc.service.impl;

import com.hivetech.mvc.converter.CategoryConverter;
import com.hivetech.mvc.dto.CategoryDTO;
import com.hivetech.mvc.entity.CategoryEntity;
import com.hivetech.mvc.repository.CategoryRepository;
import com.hivetech.mvc.service.CategoryServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceJPAImpl implements CategoryServiceJpa {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryConverter categoryConverter;
    @Override
    public Map<String,String> finAll() {
        Map<String,String> result = new HashMap<>();
        List<CategoryEntity> listCategoryEntity = categoryRepository.findAll();
        for(CategoryEntity item: listCategoryEntity){
            result.put(item.getCode(),item.getName());
        }
        return result;
    }
}
