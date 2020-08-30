package com.hivetech.mvc.api.admin;

import com.hivetech.mvc.dto.NewDTO;
import org.springframework.web.bind.annotation.*;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
    @PostMapping("/api/new")
    public NewDTO createNewBuilding(@RequestBody NewDTO newDTO){
        return newDTO;
    }
    @PutMapping("/api/new")
    public NewDTO updateNewBuilding(@RequestBody NewDTO newDTO){
        return newDTO;
    }
    @DeleteMapping("/api/new")
    public void  deleteNewBuilding(@RequestBody long[] ids){

    }
}
