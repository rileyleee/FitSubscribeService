package com.bodyguard.gyudok.model.dao;

import java.util.List;

import com.bodyguard.gyudok.model.dto.User;

public interface TrainerDao {
	
	//트레이너의 정보를 가져오는 리스트
	public List<User> selectAll(String name);
	
	//트레이너의 한명 정보를 가져오기
	public User selectOne(String nickname);
}
