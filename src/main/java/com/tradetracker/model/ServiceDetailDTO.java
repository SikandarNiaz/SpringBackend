package com.tradetracker.model;

public class ServiceDetailDTO {

	private int id;
	private int hospitalId;
	private String title;
	private String description;
	private String auto;
	private int qty;
	private double amount;

	public ServiceDetailDTO(int id, int hospitalId, String title, String description, AutoStatus auto, int qty,
			double amount) {
		this.id = id;
		this.hospitalId = hospitalId;
		this.title = title;
		this.description = description;
		this.auto = auto.toString();
		this.qty = qty;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuto() {
		return auto;
	}

	public void setAuto(String auto) {
		this.auto = auto;
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

}
