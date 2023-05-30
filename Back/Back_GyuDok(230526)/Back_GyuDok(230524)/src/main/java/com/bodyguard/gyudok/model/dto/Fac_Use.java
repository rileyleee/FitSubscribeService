package com.bodyguard.gyudok.model.dto;

public class Fac_Use {
	private String user_id;
	private int fac_id;

	public Fac_Use() {
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getFac_id() {
		return fac_id;
	}

	public void setFac_id(int fac_id) {
		this.fac_id = fac_id;
	}

	@Override
	public String toString() {
		return "Fac_Use [user_id=" + user_id + ", fac_id=" + fac_id + "]";
	}

}
