package com.bodyguard.gyudok.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodyguard.gyudok.model.dao.TrainerDao;
import com.bodyguard.gyudok.model.dto.User;

@Service
public class TrainerServiceImpl implements TrainerService{

	@Autowired
	private TrainerDao trainerdao; 
	
	
	
	@Override
	public List<User> showAll(String name) {
			return trainerdao.selectAll(name);
	}



	@Override
	public User showOne(String nickname) {
		return trainerdao.selectOne(nickname);
	}

}
