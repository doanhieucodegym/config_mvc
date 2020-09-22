package com.hivetech.mvc.service.impl;

import com.hivetech.mvc.converter.NewConverter;
import com.hivetech.mvc.dto.NewDTO;
import com.hivetech.mvc.entity.NewEntity;
import com.hivetech.mvc.repository.NewRepository;
import com.hivetech.mvc.service.NewServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class NewServiceJPAImpl implements NewServiceJPA {
    @Autowired
    private NewRepository newRepository;
    @Autowired
    private NewConverter newConverter;
    @Override
    public List<NewDTO> finaAll(Pageable pageable) {
        List<NewDTO> models = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll(pageable).getContent();
        for (NewEntity item: entities) {
          NewDTO newDTO = newConverter.toDTO(item);
            models.add(newDTO);
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) newRepository.count();
    }

    @Override
    public NewDTO findById(long id) {
        NewEntity entity = newRepository.findOne(id);
        return newConverter.toDTO(entity);
    }
}
