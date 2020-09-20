package com.hivetech.mvc.service.impl;

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
    @Override
    public List<NewDTO> finaAll(Pageable pageable) {
        List<NewDTO> models = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll(pageable).getContent();
        for (NewEntity item: entities) {
            NewDTO newDTO = new NewDTO();
            newDTO.setTitle(item.getTitle());
            newDTO.setShortDescription(item.getShortDescription());
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

        return null;
    }
}
