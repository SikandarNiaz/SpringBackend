package com.tradetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradetracker.model.Hospital;
import com.tradetracker.repository.HospitalRepository;

@Service
public class HospitalService {
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	public List<Hospital> getVendorHospitals(Integer vendorId, Integer serviceId) {
		return hospitalRepository.findVendorHospitals(vendorId, serviceId);
	}

}
