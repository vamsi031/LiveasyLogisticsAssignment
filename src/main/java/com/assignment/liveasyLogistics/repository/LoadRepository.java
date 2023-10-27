package com.assignment.liveasyLogistics.repository;

import com.assignment.liveasyLogistics.model.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoadRepository extends JpaRepository<Load,Integer> {

    List<Load> findByShipperId(String id);
}
