package com.example.SpringBootIntegration.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.SpringBootIntegration.entity.Hospital;

public interface HospitalRepo extends CrudRepository<Hospital, Integer>{


}
