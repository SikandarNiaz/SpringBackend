package com.tradetracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradetracker.model.AutoStatus;
import com.tradetracker.model.ServiceDetailDTO;
import com.tradetracker.repository.ServiceDetailRepository;

@Service
public class ServiceDetailService {

	@Autowired
	private ServiceDetailRepository serviceDetailRepository;

	public List<ServiceDetailDTO> findServiceDetails(Integer serviceId, Integer vendorId) {
		List<Object[]> results = serviceDetailRepository.findServiceDetails(serviceId, vendorId);
		List<ServiceDetailDTO> dtos = new ArrayList<>();

		for (Object[] result : results) {
			ServiceDetailDTO dto = new ServiceDetailDTO((int) result[0], // sd.id
					(int) result[1], // h.id
					(String) result[2], // sd.title
					(String) result[3], // sd.description
					 AutoStatus.valueOf(result[4].toString()), // sd.auto
					(int) result[5], // vcd.qty
					(double) result[6] // vcd.amount
			);
			dtos.add(dto);
		}

		return dtos;
	}
}
