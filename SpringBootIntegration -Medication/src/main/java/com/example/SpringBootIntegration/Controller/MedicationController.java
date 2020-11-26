package com.example.SpringBootIntegration.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootIntegration.POJO.MedicationBean;
import com.example.SpringBootIntegration.Service.MedicationService;
import com.example.SpringBootIntegration.entity.Medication;
import com.example.SpringBootIntegration.entity.MedicationPatientMap;

@RestController
public class MedicationController {
	@Autowired
	private MedicationService Medicationservice;
	
	//Create REST API's to Save, update, get medications for a particular patient. 
	
	@GetMapping("/getMedicationslist")
	public Iterable<Medication> getMedicationdata(@RequestParam(value = "id", defaultValue = "1") Integer patientid) {
		Iterable<Medication> Medicationlist = Medicationservice.getMedicationdatalist(patientid);
		return Medicationlist;
	}
	
	@PostMapping("/saveUpdateMedication")
	public MedicationBean saveupdateMedication(@RequestBody MedicationPatientMap medicationPatientMap)
	{
		MedicationBean medicationbean = Medicationservice.saveupdateMedication(medicationPatientMap);
		return medicationbean;
	}
	
	@GetMapping("/getMedicationdatalistbypatientname")
	public Iterable<Medication> getMedicationdatalistbypatientname(@RequestParam(value = "patientname") String patientname)
	{
		Iterable<Medication> medicationbeanlist = Medicationservice.getMedicationdatalistbypatientname(patientname);
		return medicationbeanlist;
	}
	
	
	
}
