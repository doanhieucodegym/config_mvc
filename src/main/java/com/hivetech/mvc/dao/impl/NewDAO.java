package com.hivetech.mvc.dao.impl;


import com.hivetech.mvc.dao.INewDAO;
import com.hivetech.mvc.dto.NewDTO;
import com.hivetech.mvc.mapper.NewMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class NewDAO extends AbstractDAO<NewDTO> implements INewDAO {
	@Override
	public List<NewDTO> findAll() {
		StringBuilder sql =new StringBuilder("SELECT * FROM news");
		return query(sql.toString(),new NewMapper());
	}
}
