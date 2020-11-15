package com.hivetech.mvc.api.admin;

import com.hivetech.mvc.dto.NewDTO;
import com.hivetech.mvc.service.NewServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
    @Autowired
    private NewServiceJPA newServiceJPA;
    @PostMapping("/api/new")
    public NewDTO createNewBuilding(@RequestBody NewDTO newDTO){
        return newServiceJPA.save(newDTO);
    }
    @PutMapping("/api/new")
    public NewDTO updateNewBuilding(@RequestBody NewDTO updateNew){
        return newServiceJPA.save(updateNew);
    }
    @DeleteMapping("/api/new")
    public void  deleteNewBuilding(@RequestBody long[] ids){
        newServiceJPA.delete(ids);
    }
}
