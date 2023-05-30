package com.bodyguard.gyudok.model.service;

import java.util.List;

import com.bodyguard.gyudok.model.dto.User;

public interface TrainerService {


	//트레이너  전체 리스트
	public List<User> showAll(String name);
	
	//트레이너 한명의 정보 가져오기
	public User showOne(String nickname);
}
