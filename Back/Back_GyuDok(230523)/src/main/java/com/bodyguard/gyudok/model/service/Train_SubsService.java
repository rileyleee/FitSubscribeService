package com.bodyguard.gyudok.model.service;

import java.util.List;

import com.bodyguard.gyudok.model.dto.Train_subs;

public interface Train_SubsService {

	//이걸 통해서 구독한 트레이너의 정보를 불러온다.
	public List<Train_subs> showAll(String trainee_id);
	
	//트레이너 구독 신청
	public int registOne(Train_subs train_subs);
}
