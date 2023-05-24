package com.ssafy.ws.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.model.dto.Movie;
import com.ssafy.ws.model.service.MovieService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/movie")
public class MovieRestController {

	private static final Logger logger = LoggerFactory.getLogger(MovieRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	MovieService movieService;

	@ApiOperation(value = "모든 영화의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<Movie>> listMovie() {
		logger.debug("listMovie - 호출");
		return new ResponseEntity<>(movieService.list(), HttpStatus.OK);
	}

	@ApiOperation(value = "id에 해당하는 영화의 정보를 반환한다.", response = Movie.class)
	@GetMapping("/{id}")
	public ResponseEntity<Movie> searchMovie(@PathVariable int id) {
		logger.debug("searchTitle - 호출");
		return new ResponseEntity<>(movieService.search(id), HttpStatus.OK);
	}

	@ApiOperation(value = "새로운 영화 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> createMovie(@RequestBody Movie movie) {
		logger.debug("insertMovie - 호출");
		if (movieService.create(movie)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "id에 해당하는 영화의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{id}")
	public ResponseEntity<String> modifyMovie(@RequestBody Movie movie) {
		logger.debug("modifyMovie - 호출");
		logger.debug("" + movie);
		if (movieService.modify(movie)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "id에 해당하는 영화의 좋아요 수를 1 늘린다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/like/{id}")
	public ResponseEntity<?> updateCnt(@PathVariable int id){
		Movie movie = movieService.search(id);
		int result = movieService.updateCnt(movie);
		if(result==1) {
			return new ResponseEntity<> (1, HttpStatus.OK);			
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
