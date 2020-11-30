package com.example.SpringBootIntegration.entity;

import javax.persistence.*;

@Entity
@Table(name="patient_hospital_map")
public class PatientHospitalMap {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer hospitalId;
    private Integer patientId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
    
    
}
