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
	
	/*.          Get all patients in a hospital.        
	3.          Get patient by id. */

	
	public Iterable<Patient> getPatientdatalist(Integer patientid)
	{
		//Patient Patient=null;
		Iterable<Patient> patientlist=patientrepo.getPatientforpatient(patientid); 
		return patientlist;
	}
	
	public Iterable<Patient> getPatientdatalistbypatientname(String hospitalId)
	{
		
		//Patient Patient=null;
		//Integer patientId = callmicroservice(patientname);
		Iterable<Patient> Patientlist=patientrepo.getPatientforpatient(patientId); 
		return Patientlist;
	}
	

	
	public Integer callmicroservice(String patientname)
	{
		List<ServiceInstance> list =
				discoveryClient.getInstances("patient-service");
		ServiceInstance service2 = list.get(0);
		URI micro2URI = service2.getUri();
		PatientBean micro2Response = new
				RestTemplate().postForObject(micro2URI +
				"/patient-service/getfrompatientname", null, PatientBean.class);
		return micro2Response.getId();
	}
	
	
	

}
