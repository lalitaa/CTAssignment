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
import com.example.SpringBootIntegration.entity.PatientPatientMap;

@RestController
public class PatientController {
	@Autowired
	private PatientService Patientservice;
	
	//Create REST API's to Save, update, get Patients for a particular patient. 
	
	@GetMapping("/getPatientslist")
	public Iterable<Patient> getPatientdata(@RequestParam(value = "id", defaultValue = "1") Integer patientid) {
		Iterable<Patient> Patientlist = Patientservice.getPatientdatalist(patientid);
		return Patientlist;
	}
	
	@PostMapping("/saveUpdatePatient")
	public PatientBean saveupdatePatient(@RequestBody PatientPatientMap PatientPatientMap)
	{
		PatientBean Patientbean = Patientservice.saveupdatePatient(PatientPatientMap);
		return Patientbean;
	}
	
	@GetMapping("/getPatientdatalistbypatientname")
	public Iterable<Patient> getPatientdatalistbypatientname(@RequestParam(value = "patientname") String patientname)
	{
		Iterable<Patient> Patientbeanlist = Patientservice.getPatientdatalistbypatientname(patientname);
		return Patientbeanlist;
	}
	
	
	
}
