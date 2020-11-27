package com.example.SpringBootAppIntegration;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controllermain {


    
   /* @Autowired
     PatientClient patientClient;

    @Autowired
     MedicationClient medicationClient;*/

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/getmedications")
    @CrossOrigin
    public HashMap<Integer,Iterable<Medication>> getmedications() {
    	//Collection<Patient> patientlist=patientClient.readpatients().getContent()
               // .stream()
               // .collect(Collectors.toList());
        List<ServiceInstance> list =
                discoveryClient.getInstances("patient-service");
        ServiceInstance service2 = list.get(0);
        URI micro2URI = service2.getUri();
         Object micro2Response = new
                RestTemplate().getForObject(micro2URI +
                "/patient-service/getpatientslist", null, Object.class);
    	//getting medication for each patient
        Iterable<Patient> patients= ((Iterable<Patient>)micro2Response);
        HashMap<Integer,Iterable<Medication>> hashmap=new HashMap<Integer,Iterable<Medication>>();
    	
    	for (Patient patient : patients) {
            List<ServiceInstance> listmedication =
                    discoveryClient.getInstances("medication-service");
            ServiceInstance servicemedication = listmedication.get(0);
            URI micro2URImedication = servicemedication.getUri();
            Object micro2Responsemedication = new
                    RestTemplate().getForObject(micro2URImedication +
                    "/medication-service/getMedicationslist/{id}", null, Object.class,patient.getId());
            Iterable<Medication> medications= ((Iterable<Medication>)micro2Responsemedication);
            hashmap.put(patient.getId(),medications);
    		//hashmap.put(patient.getId(), medicationClient.readMedications(patient.getId()).getContent()
                 //   .stream()
                   // .collect(Collectors.toList()));
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
