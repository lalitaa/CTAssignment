package com.example.SpringBootIntegration.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.SpringBootIntegration.entity.MedicationPatientMap;

public interface MedicationPatientMapRepo  extends CrudRepository<MedicationPatientMap, Integer>{
	
	

}
