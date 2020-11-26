package com.example.SpringBootIntegration.entity;


import javax.persistence.*;

@Entity
@Table(name="medication")
public class Medication {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String medName;
    private String instructions;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	
	
    
    
    
}
