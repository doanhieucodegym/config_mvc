package com.hivetech.mvc.service.impl;

import com.hivetech.mvc.converter.NewConverter;
import com.hivetech.mvc.dto.NewDTO;
import com.hivetech.mvc.entity.CategoryEntity;
import com.hivetech.mvc.entity.NewEntity;
import com.hivetech.mvc.repository.CategoryRepository;
import com.hivetech.mvc.repository.NewRepository;
import com.hivetech.mvc.service.NewServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class NewServiceJPAImpl implements NewServiceJPA {
    @Autowired
    private NewRepository newRepository;
    @Autowired
    private NewConverter newConverter;
    @Autowired
    private CategoryRepository categoryRepository;
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

    @Override
    @Transactional
    public NewDTO add(NewDTO dto) {
        CategoryEntity category = categoryRepository.findByCode(dto.getCategoryCode());
        NewEntity newEntity = newConverter.toEntity(dto);
        newEntity.setCategory(category);
        newEntity = newRepository.save(newEntity);
        return newConverter.toDTO(newEntity);
    }

    @Override
    @Transactional
    public NewDTO update(NewDTO dto) {
        NewEntity oldNew = newRepository.findOne(dto.getId());
        CategoryEntity category =categoryRepository.findByCode(dto.getCategoryCode());
        oldNew.setCategory(category);
        NewEntity updateNew = newConverter.toEntity(oldNew,dto);
        return newConverter.toDTO(newRepository.save(updateNew));
    }

    @Override
    @Transactional
    public NewDTO save(NewDTO dto) {
        CategoryEntity category = categoryRepository.findByCode(dto.getCategoryCode());
        NewEntity newEntity =new NewEntity();
        if(dto.getId() != null){
            NewEntity oldNew = newRepository.findOne(dto.getId());
            oldNew.setCategory(category);
            newEntity =newConverter.toEntity(oldNew,dto);
        }else{
            newEntity =newConverter.toEntity(dto);
            newEntity.setCategory(category);
        }
        return newConverter.toDTO(newRepository.save(newEntity));
   }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for(long id:ids){
            newRepository.delete(id);
        }
    }

}
