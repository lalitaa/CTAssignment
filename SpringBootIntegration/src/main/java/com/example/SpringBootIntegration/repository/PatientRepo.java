package com.example.SpringBootIntegration.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.SpringBootIntegration.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer>{
 //public List<Patient> findAll(org.springframework.data.domain.Example.of(Patient));
 //public Optional<List<Patient>> findById(Integer id);

}
