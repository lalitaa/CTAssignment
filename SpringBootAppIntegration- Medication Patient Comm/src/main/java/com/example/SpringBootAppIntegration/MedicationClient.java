package com.example.SpringBootAppIntegration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("medication-service")
public interface MedicationClient {
	@PostMapping("/getMedicationslist")
    @CrossOrigin
    CollectionModel<Medication> readMedications(Integer patientId);
}
