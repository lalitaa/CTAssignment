package com.example.SpringBootIntegration.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.SpringBootIntegration.entity.*;

public interface PatientRepo extends JpaRepository<Patient, Integer>{
 //public List<Patient> findAll(org.springframework.data.domain.Example.of(Patient));
 //public Optional<List<Patient>> findById(Integer id);
	
	@Query(value="SELECT * FROM patient where id in (select medication_id from medication_patient_map where patient_id=:patientid)",nativeQuery=true)
	public List<Patient> getmedicationforpatient(@Param("patientid") Integer patientid );

}
