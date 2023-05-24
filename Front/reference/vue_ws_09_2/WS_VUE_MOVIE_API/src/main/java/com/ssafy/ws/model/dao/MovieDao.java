package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.Movie;

public interface MovieDao {
	
	List<Movie> list();

	Movie search(int id);

	int create(Movie movie);
	
	int modify(Movie movie);
	
	int updateCnt(Movie movie);
	
	
}
