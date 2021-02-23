package com.mobiquityinc.test.utility;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobiquityinc.test.bean.Atm;

@Component
public class ConnectToServer {
	
	RestTemplate restTemplate = new RestTemplate();
	
	String resourceUrl="https://www.ing.nl/api/locator/atms/";
	
	public List<Atm> getResponse() {
		String forObject = restTemplate.getForObject(resourceUrl, String.class);
		
		String replace = forObject.replace(")]}',","");
		//Gson g = new Gson(); 
		
		java.lang.reflect.Type collectionType = new TypeToken<List<Atm>>(){}.getType();
		@SuppressWarnings("unchecked")
		List<Atm> lcs = (List<Atm>) new Gson()
		               .fromJson( replace , collectionType);
		//Atm p = g.fromJson(replace, Atm.class);

		return lcs;
		
	}
	

}
