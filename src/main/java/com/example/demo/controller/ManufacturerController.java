package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.example.demo.bean.ResponseManufacturer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/api")
public class ManufacturerController {

	RestTemplate  restTemplate = new RestTemplate();
	
	@RequestMapping(value ="/getVehicleManufacturerDetails",method = RequestMethod.GET)
	public  List<ResponseManufacturer> getForObjectOperation(@RequestParam("manufactuer_name") String manufactuer_name) {
	 String endpoint = "https://vpic.nhtsa.dot.gov/api/vehicles/GetManufacturerDetails/"+manufactuer_name+"?format=json";

     String manufactureDetails = restTemplate.getForObject(
	  endpoint,  String.class);
     ObjectMapper mapper = new ObjectMapper();
     List<ResponseManufacturer> responseManufacturerList = null;
	try {
		responseManufacturerList = mapper.readValue(manufactureDetails, new TypeReference<List<ResponseManufacturer>>(){});
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

     return responseManufacturerList;
}
}
