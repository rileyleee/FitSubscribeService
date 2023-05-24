package com.bodyguard.gyudok.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodyguard.gyudok.model.dao.Train_ReviewDao;
import com.bodyguard.gyudok.model.dto.Train_Review;


@Service
public class Train_ReviewServiceImpl implements Train_ReviewService {
	
	@Autowired
	private Train_ReviewDao train_reviewdao;
	
	@Override
	public List<Train_Review> showAll(String trainer_nickname) {
		return train_reviewdao.selectAll(trainer_nickname);
	}

	@Override
	public List<Train_Review> showMYreview(String trainee_id) {
		return train_reviewdao.selectMYReview(trainee_id);
	}
	
	@Override
	public int registOne(Train_Review train_review) {
		return train_reviewdao.registOne(train_review);
	}


}
