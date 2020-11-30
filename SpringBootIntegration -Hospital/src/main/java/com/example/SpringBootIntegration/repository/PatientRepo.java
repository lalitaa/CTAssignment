package com.example.SpringBootIntegration.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.SpringBootIntegration.entity.*;

public interface PatientRepo extends JpaRepository<Patient, Integer>{

	@Query(value="SELECT * FROM patient where patient_id in (select patient_id from patient_hospital_map where hospital_id=:hospitalid)",nativeQuery=true)
	public List<Patient> getpatientsforhospital(@Param("hospitalid") Integer hospitalid );

}
