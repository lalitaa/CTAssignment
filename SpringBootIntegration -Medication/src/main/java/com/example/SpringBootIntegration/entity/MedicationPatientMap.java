package com.example.SpringBootIntegration.entity;

import javax.persistence.*;

@Entity
@Table(name="medication_patient_map")
public class MedicationPatientMap {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer medicationId;
    private Integer patientId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMedicationId() {
		return medicationId;
	}
	public void setMedicationId(Integer medicationId) {
		this.medicationId = medicationId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
    
    
}
