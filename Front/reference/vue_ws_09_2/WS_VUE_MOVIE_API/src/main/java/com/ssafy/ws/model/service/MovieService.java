package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.dto.Movie;

public interface MovieService {

	List<Movie> list();

	Movie search(int id);

	boolean create(Movie movieDto);
	
	boolean modify(Movie movieDto);
	
	int updateCnt(Movie movie);
	
}
