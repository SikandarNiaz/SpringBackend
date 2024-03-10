package com.tradetracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vendor_contracts")
public class VendorContract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "hospital_id")
	private Hospital hospital;

	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;

	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
