package com.tradetracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vendor_contract_details")
public class VendorContractDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "service_detail_id")
	private ServiceDetail serviceDetail;

	@ManyToOne
	@JoinColumn(name = "vendor_contract_id")
	private VendorContract vendorContract;

	private int qty;

	private double amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ServiceDetail getServiceDetail() {
		return serviceDetail;
	}

	public void setServiceDetail(ServiceDetail serviceDetail) {
		this.serviceDetail = serviceDetail;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public VendorContract getVendorContract() {
		return vendorContract;
	}

	public void setVendorContract(VendorContract vendorContract) {
		this.vendorContract = vendorContract;
	}

}
