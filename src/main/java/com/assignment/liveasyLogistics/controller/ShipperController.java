package com.assignment.liveasyLogistics.controller;

import com.assignment.liveasyLogistics.Dto.ShipperRequestDto;
import com.assignment.liveasyLogistics.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipper")
public class ShipperController {

    @Autowired
    ShipperService shipperService;

    //it will add the shipper details to the database
    @PostMapping("/add")
    public String addShipper(@RequestBody ShipperRequestDto shipperRequestDto){
        String shipperId = shipperService.addShipper(shipperRequestDto);

        return shipperId;
    }

    //it will retrive the data of a shipper from the db by using shipped id
    @DeleteMapping("/delete/{id}")
    public String deleteShipper(@PathVariable String id){
        String response = shipperService.deleteShipper(id);

        return response;
    }
}
