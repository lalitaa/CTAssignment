package com.example.SpringBootIntegration.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootIntegration.POJO.PatientBean;
import com.example.SpringBootIntegration.Service.PatientService;
import com.example.SpringBootIntegration.entity.Patient;

@RestController
public class PatientController {
	@Autowired
	private PatientService patientservice;
	
	@GetMapping("/getpatientslist")
	public Iterable<Patient> getpatientdata() {
		Iterable<Patient> patientlist = patientservice.getpatientdatalist();
		return patientlist;
	}
	
	@PostMapping("/saveUpdatePatient")
	public Patient saveupdatepatient(@RequestBody Patient patient)
	{
		patient = patientservice.saveupdatepatient(patient);
		return patient;
	}
	
	@GetMapping("/getdataofsinglepatient")
	public PatientBean saveupdatepatient(@RequestParam(value = "id", defaultValue = "1") Integer patientid)
	{
		PatientBean patientbean = patientservice.getdataofsinglepatient(patientid);
		return patientbean;
	}
	
	@PostMapping("/getfilteredData")
	public PatientBean getfilteredData(@RequestBody Patient patient)
	{
		PatientBean patientbean = patientservice.getfilteredData(patient);
		return patientbean;
	}
	
}
