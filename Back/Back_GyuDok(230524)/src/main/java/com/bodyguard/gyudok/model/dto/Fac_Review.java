package com.bodyguard.gyudok.model.dto;

public class Fac_Review {
	private int id;
	private String user_id;
	private int fac_id;
	private String title;
	private String content;
	private float rating;

	public Fac_Review() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Fac_Review [id=" + id + ", user_id=" + user_id + ", fac_id=" + fac_id + ", title=" + title
				+ ", content=" + content + ", rating=" + rating + "]";
	}

}
