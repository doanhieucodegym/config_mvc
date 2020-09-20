package com.hivetech.mvc.service;

import com.hivetech.mvc.dto.NewDTO;
import com.hivetech.mvc.entity.NewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewServiceJPA {
    List<NewDTO> finaAll(Pageable pageable);
    int getTotalItem();
    NewDTO findById(long id);
}
