package com.example.SpringBootAppIntegration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class Controller {
	private  PatientClient patientclient;
    private MedicationClient medicationclient;
    
    public Controller(PatientClient patientclient,MedicationClient medication) {
        this.patientclient = patientclient;
        this.medicationclient = medication;
    }

    private Collection<Patient> fallback() {
        return new ArrayList<>();
    }

    @GetMapping("/getmedications")
    @CrossOrigin
    @HystrixCommand(fallbackMethod = "fallback")
    public HashMap<Integer,Collection<Medication>> getmedications() {
    	Collection<Patient> patientlist=patientclient.readpatients().getContent()
                .stream()
                .collect(Collectors.toList());
    	//getting medication for each patient
    	HashMap<Integer,Collection<Medication>> hashmap=new HashMap<Integer,Collection<Medication>>();
    	
    	for (Patient patient : patientlist) {
    		hashmap.put(patient.getId(), medicationclient.readMedications(patient.getId()).getContent()
                    .stream()
                    .collect(Collectors.toList()));
    	}
    	
    	/*patientlist.forEach(temp -> medicationclient.readMedications(temp.getId()).getContent()
                .stream()
                .collect(Collectors.toList()));
    	
    	patientlist.forEach((temp) -> {
    		medicationclient.readMedications(temp.getId()).getContent()
            .stream()
            .collect(Collectors.toList());
});*/
    	return hashmap;
    }
    
    

    
}
