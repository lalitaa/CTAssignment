package com.example.SpringBootIntegration.entity;


import javax.persistence.*;

@Entity
@Table(name="patient")
public class Patient {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer patient_id;
    private String patientname;
    private String age;
    private String gender;
	public Integer getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
    
    
    
}
