package com.bodyguard.gyudok.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bodyguard.gyudok.model.dto.Fac_Review;

public interface Fac_ReviewDao {
	
	// 운동시설 리뷰 및 평점 기록하기
	int insertFacReview(Fac_Review fac_Review);

	// 내가 작성한 운동시설 리뷰 모두 조회하기
	List<Fac_Review> selectUserFacReviews(String user_id);

	// 특정 운동시설의 리뷰 조회하기
	List<Fac_Review> selectFacReviews(int id);

	// 내가 작성한 리뷰 삭제하기
	int deleteUserFacReviews(@Param("user_id") String user_id, @Param("id") int id);

	

}
