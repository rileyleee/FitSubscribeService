package com.bodyguard.gyudok.model.dao;

import java.util.List;

import com.bodyguard.gyudok.model.dto.Review;

public interface ReviewDao {

	// 댓글 작성
	int insertOne(Review review);

	// 댓글 상세 조회
	Review selectOne(int id);

	// 댓글 수정
	void updateOne(Review review);

	// 댓글 삭제
	int deleteOne(int id);

	// 회원이 작성한 전체 댓글 조회
	List<Review> selectUserReviews(String user_id);

	// 게시글에 대한 모든 댓글 조회
	List<Review> selectBoardReviews(int board_id);

}
