package com.hivetech.mvc.DAO;

import com.hivetech.mvc.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
    List<CategoryModel> findAll();
    CategoryModel findOne(long id);
    CategoryModel findOneByCode(String code);
}