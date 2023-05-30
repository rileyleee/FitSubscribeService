package com.bodyguard.gyudok.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bodyguard.gyudok.model.dao.Fac_ReviewDao;
import com.bodyguard.gyudok.model.dto.Fac_Review;

@Service
public class Fac_ReviewServiceImpl implements Fac_ReviewService {

	private Fac_ReviewDao fac_reviewDao;

	public Fac_ReviewServiceImpl(Fac_ReviewDao fac_reviewDao) {
		this.fac_reviewDao = fac_reviewDao;
	}

	// 운동시설 리뷰 및 평점 기록하기
	@Override
	public int registFacReview(Fac_Review fac_Review) {
		return fac_reviewDao.insertFacReview(fac_Review);
	}

	// 내가 작성한 운동시설 리뷰 모두 조회하기
	@Override
	public List<Fac_Review> showUserFacReviews(String user_id) {
		return fac_reviewDao.selectUserFacReviews(user_id);
	}

	// 특정 운동시설의 리뷰 조회하기
	@Override
	public List<Fac_Review> showFacReviews(int id) {
		return fac_reviewDao.selectFacReviews(id);
	}

	// 내가 작성한 리뷰 삭제하기
	@Override
	public int removeFacReviews(String user_id, int id) {
		return fac_reviewDao.deleteUserFacReviews(user_id, id);
	}

}
