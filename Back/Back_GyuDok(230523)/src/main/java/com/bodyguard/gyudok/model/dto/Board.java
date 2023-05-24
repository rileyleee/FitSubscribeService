package com.bodyguard.gyudok.model.dto;

public class Board {
	private int id; // 게시글 번호
	private String user_id; // 게시글 작성자
	private String category; // 게시글 카테고리
	private String title; // 게시글 제목
	private String content; // 게시글 내용
	private String fileName; // 게시글 이미지/동영상 이름
	private String filePath; // 게시글 이미지/동영상 경로
	private int viewcnt; // 게시글 조회 수
	private int reviewcnt; // 게시글 댓글 수
	private String regdate; // 게시글 등록 및 최종 수정일

	public Board() { // 기본 생성자
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public int getReviewcnt() {
		return reviewcnt;
	}

	public void setReviewcnt(int reviewcnt) {
		this.reviewcnt = reviewcnt;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", user_id=" + user_id + ", category=" + category + ", title=" + title + ", content="
				+ content + ", fileName=" + fileName + ", filePath=" + filePath + ", viewcnt=" + viewcnt
				+ ", reviewcnt=" + reviewcnt + ", regdate=" + regdate + "]";
	}

}
