package com.example.SpringBootIntegration.Service;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.SpringBootIntegration.POJO.Patient;
import com.example.SpringBootIntegration.POJO.PatientBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import com.example.SpringBootIntegration.POJO.HospitalBean;
import com.example.SpringBootIntegration.entity.Hospital;
import com.example.SpringBootIntegration.repository.HospitalRepo;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.ServiceInstance;
@Service
public class HospitalService {
	
	@Autowired
	private HospitalRepo hospitalRepo;
	@Autowired
	DiscoveryClient discoveryClient;


	public Iterable<Hospital> getHospitaldatalist()
	{
		//Patient patient=null;
		Iterable<Hospital> hospitallist=hospitalRepo.findAll(); 
		
		return hospitallist;
	}
	
	
	public HospitalBean getdataofsingleHospital(Integer id)
	{
		HospitalBean hospitalbean = new HospitalBean();
		Hospital hospital=hospitalRepo.findById(id).get();
		hospitalbean.setMessage("Success");
		hospitalbean.setResponse(hospital);
		return hospitalbean;	
	}

	public HashMap<Integer,List<Patient>> getallpatienthospitalwise()
	{
		Iterable<Hospital> hospitallist=hospitalRepo.findAll();
		HashMap<Integer,List<Patient>> patientlist=new HashMap<Integer,List<Patient>>();
		for(Hospital hospital:hospitallist)
		{
			List<Patient> patients=callmicroservice(hospital.getHospital_id());
			if(patients==null)
			{
				patients=new ArrayList<Patient>();
			}
			patientlist.put(hospital.getHospital_id(),patients);
		}
		return patientlist;
	}

	public List<Patient> callmicroservice(Integer hospitalid)
	{
		List<ServiceInstance> list =
				discoveryClient.getInstances("patient-for-hospital-service");
		ServiceInstance service2 = list.get(0);
		URI micro2URI = service2.getUri();
		PatientBean micro2Response = new
				RestTemplate().postForObject(micro2URI +
				"/patient-for-hospital-service/getPatientslistbyhospitalid/{hospitalid}", null, PatientBean.class,hospitalid);
		return micro2Response.getPatientslist();
	}
	
}
