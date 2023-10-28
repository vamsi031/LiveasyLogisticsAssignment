package com.assignment.liveasyLogistics.controller;

import com.assignment.liveasyLogistics.Dto.LoadRequestDto;
import com.assignment.liveasyLogistics.Dto.LoadResponseDto;
import com.assignment.liveasyLogistics.model.Load;
import com.assignment.liveasyLogistics.repository.LoadRepository;
import com.assignment.liveasyLogistics.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loads")
public class LoadController {
    @Autowired
    LoadService loadService;

    //it will add the details of the load to the db
    @PostMapping("/add")
    public LoadResponseDto addLoad(@RequestBody LoadRequestDto loadRequestDto){
        LoadResponseDto loadResponseDto = loadService.addLoad(loadRequestDto);

        return loadResponseDto;
    }

    //it will get list of loads by shipper id
    @GetMapping("/get_load_by_shipper_id/{id}")
    public List<Load> getLoadByShipperId(@PathVariable String id){

        List<Load> loadList = loadService.getLoadByShipperId(id);

        return loadList;
    }

    //it will retrive the load entity by load id
    @GetMapping("/get_load_by_load_id/{id}")
    public Load getLoadByLoadId(@PathVariable int id){
        Load load = loadService.getLoadByLoadId(id);

        return load;
    }

    //it will update the details of existing load by load id
    @PutMapping("/update_load_by_id/{id}")
    public String updateLoadById(@PathVariable int id,@RequestBody LoadRequestDto loadRequestDto){
        String response  = loadService.updateLoadById(id,loadRequestDto);

        return response;
    }

    //it will delete the load by load id
    @DeleteMapping("/delete_by_id/{id}")
    public String deleteByLoadId(@PathVariable int id){
        String response = loadService.deleteByLoadId(id);

        return response;
    }

}
