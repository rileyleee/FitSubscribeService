package com.bodyguard.gyudok.model.dto;

public class Facility {
	private int id;
	private String operation;
	private String factype;
	private String address1;
	private String address2;
	private String address3;
	private String facname;
	private String fulladdress1;
	private String fulladdress2;
	private float lat;
	private float lot;
	private float rating;
	private String fileName;
	private String filePath;

	public Facility() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getFactype() {
		return factype;
	}

	public void setFactype(String factype) {
		this.factype = factype;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getFacname() {
		return facname;
	}

	public void setFacname(String facname) {
		this.facname = facname;
	}

	public String getFulladdress1() {
		return fulladdress1;
	}

	public void setFulladdress1(String fulladdress1) {
		this.fulladdress1 = fulladdress1;
	}

	public String getFulladdress2() {
		return fulladdress2;
	}

	public void setFulladdress2(String fulladdress2) {
		this.fulladdress2 = fulladdress2;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLot() {
		return lot;
	}

	public void setLot(float lot) {
		this.lot = lot;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "Facility [id=" + id + ", operation=" + operation + ", factype=" + factype + ", address1=" + address1
				+ ", address2=" + address2 + ", address3=" + address3 + ", facname=" + facname + ", fulladdress1="
				+ fulladdress1 + ", fulladdress2=" + fulladdress2 + ", lat=" + lat + ", lot=" + lot + ", rating="
				+ rating + ", fileName=" + fileName + ", filePath=" + filePath + "]";
	}

}
