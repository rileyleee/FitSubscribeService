package com.bodyguard.gyudok.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodyguard.gyudok.model.dao.ReviewDao;
import com.bodyguard.gyudok.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewDao reviewDao;

	@Autowired
	public ReviewServiceImpl(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	// 댓글 등록
	@Override
	public int writeReview(Review review) {
		return reviewDao.insertOne(review);
	}

	// 댓글 상세 조회
	@Override
	public Review showOne(int id) {
		return reviewDao.selectOne(id);
	}

	// 댓글 수정
	@Override
	public void modifyReview(Review review) {
		reviewDao.updateOne(review);
	}

	// 댓글 삭제
	@Override
	public int removeOne(int id) {
		return reviewDao.deleteOne(id);
	}

	// 회원의 작성 댓글 전체 조회
	@Override
	public List<Review> showUserReviews(String user_id) {
		return reviewDao.selectUserReviews(user_id);
	}

	@Override
	public List<Review> showBoardReviews(int board_id) {
		return reviewDao.selectBoardReviews(board_id);
	}

}
