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
	private PatientService Patientservice;
	
	//Create REST API's to Save, update, get Patients for a particular patient. 
	
	@GetMapping("/getPatientslistbyhospitalid")
	public Iterable<Patient> getPatientslistbyhospitalid(@RequestParam(value = "hospitalid") Integer hospitalid) {
		Iterable<Patient> Patientlist = Patientservice.getPatientsByhospitalid(hospitalid);
		return Patientlist;
	}

	
	@GetMapping("/getPatientdatalistbyid")
	public Patient getPatientdatalistbyid(@RequestParam(value = "patientid") Integer patientid)
	{
		Patient patient = Patientservice.getPatientdatalistbypatientid(patientid);
		return patient;
	}
	
	
	
}
