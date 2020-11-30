package com.example.SpringBootIntegration.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.SpringBootIntegration.entity.PatientHospitalMap;

public interface PatientHospitalMapRepo  extends CrudRepository<PatientHospitalMap, Integer>{
	
	

}
