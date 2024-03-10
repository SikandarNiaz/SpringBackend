package com.tradetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tradetracker.model.VendorContractDetail;

import java.util.List;

public interface ServiceDetailRepository extends JpaRepository<VendorContractDetail, Integer> {

	@Query("SELECT sd.id, h.id as hospital_id, sd.title, sd.description, sd.auto, vcd.qty, vcd.amount "
			+ "FROM VendorContract cv " + "INNER JOIN Vendor v ON cv.vendor.id = v.id "
			+ "INNER JOIN VendorContractDetail vcd ON cv.id = vcd.vendorContract.id "
			+ "INNER JOIN ServiceDetail sd ON vcd.serviceDetail.id = sd.id "
			+ "INNER JOIN Service s ON cv.service.id = s.id " + "INNER JOIN Hospital h ON cv.hospital.id = h.id "
			+ "WHERE cv.service.id = :service_id AND cv.vendor.id = :vendor_id")
	List<Object[]> findServiceDetails(@Param("service_id") Integer service_id, @Param("vendor_id") Integer vendor_id);
}