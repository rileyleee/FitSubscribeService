package com.bodyguard.gyudok.model.dto;

public class Review {

	private int id;
	private String user_id;
	private int board_id;
	private String content;
	private String regdate;

	public Review() {
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

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", user_id=" + user_id + ", board_id=" + board_id + ", content=" + content
				+ ", regdate=" + regdate + "]";
	}

}
