package com.example.SpringBootIntegration.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootIntegration.POJO.HospitalBean;
import com.example.SpringBootIntegration.entity.Hospital;
import com.example.SpringBootIntegration.repository.HospitalRepo;

@Service
public class HospitalService {
	
	@Autowired
	private HospitalRepo hospitalRepo;
	


	public Iterable<Hospital> getHospitaldatalist()
	{
		//Patient patient=null;
		Iterable<Hospital> hospitallist=hospitalRepo.findAll(); 
		
		return hospitallist;
	}
	
	
	public HospitalBean getdataofsingleHospital(Integer id)
	{
		HospitalBean hospitalbean = new HospitalBean();
		Hospital hospital=hospitalRepo.findById(id).get();
		hospitalbean.setMessage("Success");
		hospitalbean.setResponse(hospital);
		return hospitalbean;	
	}
	
}
