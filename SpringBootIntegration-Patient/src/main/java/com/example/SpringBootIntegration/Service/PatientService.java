package com.example.SpringBootIntegration.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootIntegration.POJO.PatientBean;
import com.example.SpringBootIntegration.entity.Patient;
import com.example.SpringBootIntegration.repository.PatientRepo;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepo patientrepo;
	
	public Iterable<Patient> getpatientdatalist()
	{
		//Patient patient=null;
		Iterable<Patient> patientlist=patientrepo.findAll(); 
		
		return patientlist;
	}
	
	@Transactional
	public Patient saveupdatepatient(Patient patient)
	{
		patient = patientrepo.save(patient);
		return patient;
	}
	
	public PatientBean getdataofsinglepatient(Integer id)
	{
		PatientBean patientbean = new PatientBean();
		Patient patient=patientrepo.findOne(id);
		patientbean.setMessage("Success");
		patientbean.setResponse(patient);
		return patientbean;	
	}
	
	public PatientBean getfilteredData(Patient patient)
	{
		Iterable<Patient> patientlist= patientrepo.findAll(org.springframework.data.domain.Example.of(patient));
		PatientBean patientbean = new PatientBean();	
		patientbean.setMessage("Success");
		patientbean.setResponse(patientlist);
		return patientbean;
	} 
	
	public Patient getfrompatientname(Patient patient)
	{
		patient= patientrepo.findbypatientname(patient.getName());
		
		return patient;
	} 

}
