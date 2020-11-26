package com.example.SpringBootIntegration.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.SpringBootIntegration.POJO.MedicationBean;
import com.example.SpringBootIntegration.POJO.PatientBean;
import com.example.SpringBootIntegration.entity.Medication;
import com.example.SpringBootIntegration.entity.MedicationPatientMap;
import com.example.SpringBootIntegration.repository.MedicationPatientMapRepo;
import com.example.SpringBootIntegration.repository.MedicationRepo;

@Service
public class MedicationService {
	
	@Autowired
	private MedicationRepo medicationrepo;
	@Autowired
	private MedicationPatientMapRepo medicationPatientMapRepo;
	@Autowired 
	private RestTemplate restTemplate;
	
	public Iterable<Medication> getMedicationdatalist(Integer patientid)
	{
		//Medication Medication=null;
		Iterable<Medication> Medicationlist=medicationrepo.getmedicationforpatient(patientid); 
		return Medicationlist;
	}
	
	public Iterable<Medication> getMedicationdatalistbypatientname(String patientname)
	{
		
		//Medication Medication=null;
		Integer patientId = callmicroservice(patientname);
		Iterable<Medication> Medicationlist=medicationrepo.getmedicationforpatient(patientId); 
		return Medicationlist;
	}
	
	@Transactional
	public MedicationBean saveupdateMedication(MedicationPatientMap medicationPatientMap)
	{
		MedicationBean medicationBea=new MedicationBean();
		medicationPatientMap = medicationPatientMapRepo.save(medicationPatientMap);
		medicationBea.setMessage("success");
		medicationBea.setResponse(medicationPatientMap);
		return medicationBea;
	}
	
	public Integer callmicroservice(String patientname)
	{
		PatientBean patientbean = new PatientBean();
		patientbean.setName(patientname);
		ResponseEntity<PatientBean> responseEntity = 
				   new RestTemplate().getForEntity(
				        "http://127.0.0.1:8003/getfrompatientname", PatientBean.class,  patientbean);
		//PatientBean jsonObject = restTemplate.exchange("http://127.0.0.1:8003/", HttpMethod.POST, 	patientbean, PatientBean.class).getBody(); 
		return responseEntity.getBody().getId(); 
		
		//ResponseEntity<CurrencyConversionBean> responseEntity = 
				   //new RestTemplate().getForEntity(
				       // "http://localhost:8091/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,  uriVariables);
	}
	
	
	

}
