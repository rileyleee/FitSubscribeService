package com.bodyguard.gyudok.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodyguard.gyudok.model.dao.Train_SubsDao;
import com.bodyguard.gyudok.model.dto.Train_subs;


@Service
public class Train_SubsServiceImpl implements Train_SubsService {
	
	@Autowired
	private Train_SubsDao train_subsdao;
	
	
	@Override
	public List<Train_subs> showAll(String trainee_id) {
		return train_subsdao.selectAll(trainee_id);
	}


	@Override
	public int registOne(Train_subs train_subs) {
		return train_subsdao.registOne(train_subs);
	}

}
