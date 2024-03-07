package com.tradetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tradetracker.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

	@Query(value = "SELECT h.id, h.`title`, h.`district`, h.`package_no` FROM hospitals h"
			+ " INNER JOIN vendor_contracts vc ON vc.`hospital_id`=h.`id`"
			+ " WHERE vc.`service_id`=:serviceId AND vc.`vendor_id`=:vendorId AND h.`active`='Y'", nativeQuery = true)
	List<Hospital> findVendorHospitals(@Param("vendorId") Integer vendorId, @Param("serviceId") Integer serviceId);
}