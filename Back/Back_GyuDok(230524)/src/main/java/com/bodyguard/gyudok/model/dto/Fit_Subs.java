package com.bodyguard.gyudok.model.dto;

import java.time.LocalDate;

public class Fit_Subs {
	private String user_id;
	private int months;
	private String regdate;
	private LocalDate startdate;
	private LocalDate enddate;

	public Fit_Subs() {
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public LocalDate getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}

	@Override
	public String toString() {
		return "Fit_Subs [user_id=" + user_id + ", months=" + months + ", regdate=" + regdate + ", startdate="
				+ startdate + ", enddate=" + enddate + "]";
	}

}
