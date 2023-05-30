package com.bodyguard.gyudok.model.dao;

import java.util.List;

import com.bodyguard.gyudok.model.dto.Train_subs;

public interface Train_SubsDao {


	
	
	//로그인한 사람의 아이디의 트레이너 구독 리스트를 불러오기
	public List<Train_subs> selectAll(String trainee_id);

	//트레이너 구독 신청
	public int registOne(Train_subs train_subs);
	
}
