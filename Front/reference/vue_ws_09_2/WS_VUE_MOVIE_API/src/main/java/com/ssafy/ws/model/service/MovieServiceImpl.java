package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.MovieDao;
import com.ssafy.ws.model.dto.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao movieDao;

	@Override
	public List<Movie> list() {
		return movieDao.list();
	}

	@Override
	public Movie search(int id) {
		return movieDao.search(id);
	}

	@Override
	public boolean create(Movie movieDto) {
		return movieDao.create(movieDto) == 1;
	}

	@Override
	public boolean modify(Movie movieDto) {
		return movieDao.modify(movieDto) == 1;
	}

	@Override
	public int updateCnt(Movie movie) {
		return movieDao.updateCnt(movie);
	}
}
