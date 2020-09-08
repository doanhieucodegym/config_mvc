package com.hivetech.mvc.dao;

import java.util.List;

import com.hivetech.mvc.dto.NewDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface INewDAO extends GenericDAO<NewDTO> {
	List<NewDTO> findAll( );

}
