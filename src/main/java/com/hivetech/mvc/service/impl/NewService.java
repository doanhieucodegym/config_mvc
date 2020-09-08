package com.hivetech.mvc.service.impl;

import com.hivetech.mvc.dao.ICategoryDAO;
import com.hivetech.mvc.dao.INewDAO;
import com.hivetech.mvc.model.NewModel;
import com.hivetech.mvc.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NewService implements INewService {
	
	@Autowired
	private INewDAO newDAO;
    @Override
    public List<NewModel> findAll() {
      return  null;
    }
}
