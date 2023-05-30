package com.bodyguard.gyudok.model.dto;

import java.sql.Date;

public class Train_subs {

	private String trainee_id;
	private String trainer_id;
	private String trainer_nickname;
	private int months;
	private String regdate;
	private String startdate;
	private String enddate;
	
	
	public Train_subs() {
	}


	public String getTrainee_id() {
		return trainee_id;
	}


	public void setTrainee_id(String trainee_id) {
		this.trainee_id = trainee_id;
	}


	public String getTrainer_id() {
		return trainer_id;
	}


	public void setTrainer_id(String trainer_id) {
		this.trainer_id = trainer_id;
	}


	public String getTrainer_nickname() {
		return trainer_nickname;
	}


	public void setTrainer_nickname(String trainer_nickname) {
		this.trainer_nickname = trainer_nickname;
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


	public String getStartdate() {
		return startdate;
	}


	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public String getEnddate() {
		return enddate;
	}


	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


	@Override
	public String toString() {
		return "Train_subs [trainee_id=" + trainee_id + ", trainer_id=" + trainer_id + ", trainer_nickname="
				+ trainer_nickname + ", months=" + months + ", regdate=" + regdate + ", startdate=" + startdate
				+ ", enddate=" + enddate + "]";
	}



	
	
	
}
