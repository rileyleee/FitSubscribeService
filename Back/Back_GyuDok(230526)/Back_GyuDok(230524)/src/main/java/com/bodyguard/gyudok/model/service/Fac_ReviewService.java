package com.bodyguard.gyudok.model.service;

import java.util.List;

import com.bodyguard.gyudok.model.dto.Fac_Review;

public interface Fac_ReviewService {

	int registFacReview(Fac_Review fac_Review);

	List<Fac_Review> showUserFacReviews(String user_id);

	List<Fac_Review> showFacReviews(int id);

	int removeFacReviews(String user_id, int id);

}
