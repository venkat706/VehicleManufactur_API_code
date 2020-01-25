package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseManufacturer {
	int Mfr_ID;
	String Mfr_Name;
	String City;
	String State;
	String Country;
	
	public int getMfr_ID() {
		return Mfr_ID;
	}
	public void setMfr_ID(int mfr_ID) {
		Mfr_ID = mfr_ID;
	}
	public String getMfr_Name() {
		return Mfr_Name;
	}
	public void setMfr_Name(String mfr_Name) {
		Mfr_Name = mfr_Name;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
	

}
