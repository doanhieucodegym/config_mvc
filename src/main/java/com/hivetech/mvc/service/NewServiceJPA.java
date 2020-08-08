package com.hivetech.mvc.service;

import com.hivetech.mvc.entity.NewEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewServiceJPA {
    List<NewEntity> finaAll();
}
