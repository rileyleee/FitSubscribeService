package com.bodyguard.gyudok.model.dto;

public class Train_Review {
	private int id;
	private int train_subs_id; 
	private String title;
	private String content;
	private String trainee_id;
	private String trainer_id;
	private String trainer_nickname;
	private float rating;
	
	public Train_Review() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTrain_subs_id() {
		return train_subs_id;
	}

	public void setTrain_subs_id(int train_subs_id) {
		this.train_subs_id = train_subs_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Train_Review [id=" + id + ", train_subs_id=" + train_subs_id + ", title=" + title + ", content="
				+ content + ", trainee_id=" + trainee_id + ", trainer_id=" + trainer_id + ", trainer_nickname="
				+ trainer_nickname + ", rating=" + rating + "]";
	}

	
	
	
}
