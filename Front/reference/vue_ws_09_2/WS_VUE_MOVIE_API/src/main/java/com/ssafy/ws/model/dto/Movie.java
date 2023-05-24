package com.ssafy.ws.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MovieDto : 영화 정보", description = "영화의 상세 정보를 나타낸다.")
public class Movie {

	@ApiModelProperty(value = "고유번호", example = "1")
	private int id;
	@ApiModelProperty(value = "제목")
	private String title;
	@ApiModelProperty(value = "감독")
	private String director;
	@ApiModelProperty(value = "장르")
	private String genre;
	@ApiModelProperty(value = "상영시간")
	private int runningTime;
	@ApiModelProperty(value = "좋아요수")
	private int likeCnt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}
	
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	@Override
	public String toString() {
		return "MovieDto [id=" + id + ", title=" + title + ", director=" + director + ", genre=" + genre
				+ ", runningTime=" + runningTime + ", likeCnt=" + likeCnt + "]";
	}

	

}
