package com.example.SpringBootIntegration.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootIntegration.POJO.HospitalBean;
import com.example.SpringBootIntegration.Service.HospitalService;
import com.example.SpringBootIntegration.entity.Hospital;

@RestController
public class HospitalController {
	@Autowired
	private HospitalService hospitalservice;
	
	@GetMapping("/getHospitalslist")
	public Iterable<Hospital> getHospitaldata() {
		Iterable<Hospital> Hospitallist = hospitalservice.getHospitaldatalist();
		return Hospitallist;
	}
	
	
	
	@GetMapping("/getdataofsingleHospital")
	public HospitalBean saveupdateHospital(@RequestParam(value = "id", defaultValue = "1") Integer hospitalid)
	{
		HospitalBean Hospitalbean = hospitalservice.getdataofsingleHospital(hospitalid);
		return Hospitalbean;
	}
	
}
