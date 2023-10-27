package com.assignment.liveasyLogistics.repository;

import com.assignment.liveasyLogistics.model.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper,String> {


}
