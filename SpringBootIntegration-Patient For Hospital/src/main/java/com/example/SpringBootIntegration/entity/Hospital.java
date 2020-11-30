package com.example.SpringBootIntegration.entity;


import javax.persistence.*;

@Entity
@Table(name="hospital")
public class Hospital {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer hospital_id;
    private String name;
    private String type;
	public Integer getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(Integer hospital_id) {
		this.hospital_id = hospital_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
    
	
    
    
}
