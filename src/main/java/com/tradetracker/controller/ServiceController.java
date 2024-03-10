package com.tradetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tradetracker.model.ServiceDetailDTO;
import com.tradetracker.service.ServiceDetailService;

@RestController
public class ServiceController {

	@Autowired
    private ServiceDetailService serviceDetailsRepository;

    @GetMapping("/app/service-details")
    public List<ServiceDetailDTO> getServiceDetails(
            @RequestParam Integer service_id,
            @RequestParam Integer vendor_id) {

    	List<ServiceDetailDTO> ser= serviceDetailsRepository.findServiceDetails(service_id, vendor_id);
        return ser;
    }
}