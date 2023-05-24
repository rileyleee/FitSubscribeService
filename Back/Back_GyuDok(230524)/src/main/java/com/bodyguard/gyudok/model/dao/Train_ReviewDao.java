package com.bodyguard.gyudok.model.dao;

import java.util.List;

import com.bodyguard.gyudok.model.dto.Train_Review;


public interface Train_ReviewDao {

	//특정 트레이너의 리뷰 리스트
	public List<Train_Review> selectAll(String trainer_nickname);
	
	//내가 작성한 트레이너 리뷰 리스트
	public List<Train_Review> selectMYReview(String trainee_id);
	
	
	//구독권에다가 점수 부여
	public int registOne(Train_Review train_review);
	
	
	
}
