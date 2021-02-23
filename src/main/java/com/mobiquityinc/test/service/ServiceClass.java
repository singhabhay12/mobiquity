package com.mobiquityinc.test.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobiquityinc.test.bean.Atm;
import com.mobiquityinc.test.exception.CityNotFound;
import com.mobiquityinc.test.utility.ConnectToServer;

@Service
public class ServiceClass {
	
	@Autowired
	ConnectToServer connectToServer;
	
	public List<Atm> atms() {
		return connectToServer.getResponse();
	}
	
	public List<Atm> filterAtmList(String city) {
		List<Atm> response = connectToServer.getResponse();
		List<Atm> collect = response.stream().filter(atm->atm.getAddress().getCity().equals(city)).collect(Collectors.toList());
		if(collect.size()<1)
			throw new CityNotFound();
		else
			return collect;
	}

}
