package com.bodyguard.gyudok.model.service;

import java.util.List;

import com.bodyguard.gyudok.model.dto.Review;

public interface ReviewService {
	// 댓글 등록
	int writeReview(Review review);

	// 댓글 상세 조회
	Review showOne(int id);

	// 댓글 수정
	void modifyReview(Review review);

	// 댓글 삭제
	int removeOne(int id);

	// 작성자로 댓글 조회
	List<Review> showUserReviews(String user_id);
	
	// 게시글의 모든 댓글 조회
	List<Review> showBoardReviews(int board_id);

}
