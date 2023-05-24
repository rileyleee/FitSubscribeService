package com.bodyguard.gyudok.model.service;

import java.util.List;

import com.bodyguard.gyudok.model.dto.Train_Review;

public interface Train_ReviewService {

	//트레이너 리뷰 전체 리스트 - 트레이너로 검색
	public List<Train_Review> showAll(String trainer_nickname);
	
	//내가 작성한 트레이너 리뷰 전체 리스트 - 로그인한 내 이름으로 검색
	public List<Train_Review> showMYreview(String trainee_id);
	
	
	//트레이너 리뷰에 점수 부여
	public int registOne(Train_Review train_review);
	
}
