package com.example.SpringBootAppIntegration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Collection;
import org.springframework.hateoas.CollectionModel;
@FeignClient("patient-service")
public interface PatientClient {
	
	@GetMapping("/getpatientslist")
    @CrossOrigin
    CollectionModel<Patient> readpatients();
	
}
