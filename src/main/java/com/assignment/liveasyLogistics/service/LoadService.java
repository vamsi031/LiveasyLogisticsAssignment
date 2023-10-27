package com.assignment.liveasyLogistics.service;

import com.assignment.liveasyLogistics.Dto.LoadRequestDto;
import com.assignment.liveasyLogistics.Dto.LoadResponseDto;
import com.assignment.liveasyLogistics.model.Load;
import com.assignment.liveasyLogistics.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoadService {
    @Autowired
    LoadRepository loadRepository;
    public LoadResponseDto addLoad(LoadRequestDto loadRequestDto) {
        //convert dto to loead object
        Load load = new Load();
        load.setLoadingPoint(loadRequestDto.getLoadingPoint());
        load.setUnloadingPoint(loadRequestDto.getUnloadingPoint());
        load.setComment(loadRequestDto.getComment());
        load.setDate(loadRequestDto.getDate());
        load.setNoOfTrucks(loadRequestDto.getNoOfTrucks());
        load.setProductType(loadRequestDto.getProductType());
        load.setWeight(loadRequestDto.getWeight());
        load.setShipperId(loadRequestDto.getShipperId());

        Load savedLoad = loadRepository.save(load);

        //load entity to response dto
        LoadResponseDto loadResponseDto = new LoadResponseDto();
        loadResponseDto.setLoadId(savedLoad.getLoadId());
        loadResponseDto.setResponse("load added successfully");

        return loadResponseDto;
    }

    public List<String> getLoadByShipperId(String id) {

        List<String> loadList = new ArrayList<>();

        List<Load> loadEntityList = loadRepository.findByShipperId(id);

        for(Load load:loadEntityList){
            loadList.add("load id : "+load.getLoadId());
        }
        return loadList;
    }

    public Load getLoadByLoadId(int id) {
        Optional<Load> optionalLoad = loadRepository.findById(id);
        if(optionalLoad.isEmpty())return null;

        Load load = optionalLoad.get();

        return load;
    }

    public String  updateLoadById(int id,LoadRequestDto loadRequestDto) {
        Optional<Load> optionalLoad = loadRepository.findById(id);
        if(optionalLoad.isEmpty())return "load not found";
        //updatig entity values
        Load load = optionalLoad.get();
        load.setLoadingPoint(loadRequestDto.getLoadingPoint());
        load.setUnloadingPoint(loadRequestDto.getUnloadingPoint());
        load.setComment(loadRequestDto.getComment());
        load.setDate(loadRequestDto.getDate());
        load.setNoOfTrucks(loadRequestDto.getNoOfTrucks());
        load.setProductType(loadRequestDto.getProductType());
        load.setWeight(loadRequestDto.getWeight());
        load.setShipperId(loadRequestDto.getShipperId());
        loadRepository.save(load);

        return "load updated Successfully";
    }

    public String deleteByLoadId(int id) {
        Optional<Load> optionalLoad = loadRepository.findById(id);
        if(optionalLoad.isEmpty())return "load not found";

        loadRepository.deleteById(id);
        return "load deleted successfully";
    }
}
