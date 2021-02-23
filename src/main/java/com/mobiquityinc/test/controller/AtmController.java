package com.mobiquityinc.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobiquityinc.test.bean.Atm;
import com.mobiquityinc.test.service.ServiceClass;

@RestController
public class AtmController {
	
	@Autowired
	ServiceClass serviceClass;
	@GetMapping(value="/atm/allatm")
	public List<Atm> getAllAtms(){
		return serviceClass.atms();
	}
	
	@GetMapping(value="/atm/filter")
	public List<Atm> getAllAtms(@RequestParam(value = "city") String search){
		
		List<Atm> response = serviceClass.filterAtmList(search);
		return response;
		
	}
	
	

}
