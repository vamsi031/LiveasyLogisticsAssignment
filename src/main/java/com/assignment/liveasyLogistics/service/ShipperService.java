package com.assignment.liveasyLogistics.service;

import com.assignment.liveasyLogistics.Dto.ShipperRequestDto;
import com.assignment.liveasyLogistics.model.Shipper;
import com.assignment.liveasyLogistics.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ShipperService {
    @Autowired
    ShipperRepository shipperRepository;
    public String  addShipper(ShipperRequestDto shipperRequestDto) {

        //request dto to shipper entity
        Shipper shipper = new Shipper();

        shipper.setId(String.valueOf(UUID.randomUUID()));
        shipper.setName(shipperRequestDto.getName());
        shipper.setEmail(shipperRequestDto.getEmail());
        shipper.setPhoneNumber(shipperRequestDto.getPhoneNumber());

        shipperRepository.save(shipper);

        return "your shipper id  : "+shipper.getId();


    }

    public String deleteShipper(String id) {
        Optional<Shipper> optionalShipper = shipperRepository.findById(id);
        if(optionalShipper.isEmpty())return "id not present in the data base";
        shipperRepository.deleteById(id);

        return "deleted successfully";
    }
}
