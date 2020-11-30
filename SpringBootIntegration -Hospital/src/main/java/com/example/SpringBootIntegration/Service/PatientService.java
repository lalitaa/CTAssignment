package com.example.SpringBootIntegration.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.SpringBootIntegration.POJO.PatientBean;
import com.example.SpringBootIntegration.POJO.PatientBean;
import com.example.SpringBootIntegration.entity.Patient;
import com.example.SpringBootIntegration.repository.PatientHospitalMapRepo;
import com.example.SpringBootIntegration.repository.PatientRepo;
import org.springframework.cloud.client.discovery.DiscoveryClient;


@Service
public class PatientService {
	
	@Autowired
	private PatientRepo patientrepo;
	@Autowired
	private PatientHospitalMapRepo patientHospitalMapRepo;

	@Autowired
	DiscoveryClient discoveryClient;
	

	public Iterable<Patient> getPatientsByhospitalid(Integer hospitalid)
	{
		//Patient Patient=null;
		List<Patient> patientlist=patientrepo.getpatientsforhospital(hospitalid);
		return patientlist;
	}
	
	public Patient getPatientdatalistbypatientid(Integer patientId)
	{
		Patient Patientlist=patientrepo.findById(patientId).get();
		return Patientlist;
	}
	

	

	
	
	

}
