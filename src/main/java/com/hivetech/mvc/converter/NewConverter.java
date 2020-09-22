package com.hivetech.mvc.converter;

import com.hivetech.mvc.dto.NewDTO;
import com.hivetech.mvc.entity.NewEntity;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;

@Component
public class NewConverter {
 public NewDTO toDTO(NewEntity entity){
     NewDTO result = new NewDTO();
     result.setId(entity.getId());
     result.setTitle(entity.getTitle());
     result.setShortDescription(entity.getShortDescription());
     result.setContent(entity.getContent());
     result.setThumbnail(entity.getThumbnail());
     result.setCategoryCode(entity.getCategory().getCode());
     return result;
 }
 public NewEntity toEntity(NewDTO dto){
     NewEntity result = new NewEntity();
     result.setTitle(dto.getTitle());
     result.setShortDescription(dto.getShortDescription());
     result.setContent(dto.getContent());
     result.setThumbnail(dto.getThumbnail());
     return result;
 }
}
