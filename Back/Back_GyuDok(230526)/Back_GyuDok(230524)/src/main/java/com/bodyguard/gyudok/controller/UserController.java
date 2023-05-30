package com.bodyguard.gyudok.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bodyguard.gyudok.model.dto.User;
import com.bodyguard.gyudok.model.service.TrainerService;
import com.bodyguard.gyudok.model.service.UserService;

@RestController
@RequestMapping("/gyudok-user")
public class UserController {

	private UserService userservice;
	private TrainerService trainerservice;

	@Autowired
	public UserController(UserService userservice, TrainerService trainerservice) {
		this.userservice = userservice;
		this.trainerservice = trainerservice;
	}

	private String fileDir ="C:\\Users\\SSAFY\\Desktop\\FitSubscribePRJ\\5안\\gyudok\\src\\assets\\upload\\";

	// 유저 등록(회원가입)
	@PostMapping("/regist")
	public ResponseEntity<?> regist(User user, @RequestParam(value = "file", required = false) MultipartFile file)
			throws IllegalStateException, IOException {
		if (user.getNickname() == null || user.getUsername() == null || user.getNickname() == null
				|| user.getEmail() == null || user.getPhone() == null || user.getAge() == 0
				|| user.getAddress1() == null || user.getAddress2() == null || user.getGender() == null) {
			return new ResponseEntity<String>("NO_CONTENT", HttpStatus.UNAUTHORIZED);
		} else {
			String id = user.getId();
			User temp = userservice.select(id);
			if (temp != null) {
				return new ResponseEntity<String>("Failed", HttpStatus.UNAUTHORIZED);
			}
			String fullpath = "";
			if (file != null) {
				// 날짜폴더 추가
				String currentDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
				String uploadFilePath = fileDir + currentDate + "/";
				File folder = new File(uploadFilePath);
				if (!folder.isDirectory()) {
					folder.mkdirs();
				}
				fullpath = uploadFilePath + System.currentTimeMillis() + "_" + file.getOriginalFilename();
				file.transferTo(new File(fullpath));
				user.setFilePath(fullpath);
				user.setFileName(currentDate + "/" + System.currentTimeMillis() + "_" + file.getOriginalFilename());
			}
			int result = userservice.regist(user);
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		}
	}

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<?> login(User user) {
		User tmp = userservice.login(user.getId(), user.getPassword());
		if (tmp == null) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<User>(tmp, HttpStatus.CREATED);
	}

	// id로정보불러오기
	@GetMapping("/user/{id}")
	public ResponseEntity<User> selectOne(@PathVariable String id) {
		User user = userservice.select(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// 정보수정
	@PutMapping("/modify")
	public ResponseEntity<?> modifyOne(User user) {
		if (user.getPassword() == null || user.getNickname() == null || user.getEmail() == null
				|| user.getPhone() == null || user.getAge() == 0 || user.getAddress1() == null
				|| user.getAddress2() == null) {
			return new ResponseEntity<String>("NO_CONTENT", HttpStatus.UNAUTHORIZED);
		}
		userservice.modify(user);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	// 유저삭제(회원탈퇴)
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteOne(@PathVariable String id) {
		userservice.delete(id);
		// id 도 들어갔을때
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 트레이너 정보를 가져오기
	@GetMapping("/trainerprofile/{nickname}")
	public ResponseEntity<?> selectTrainer(@PathVariable String nickname) {
		User user = trainerservice.showOne(nickname);
		if (user == null) {
			return new ResponseEntity<String>("NO_CONTENT", HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// 팔로우 등록(내가 팔로우할 유저를 목록에 등록) //현재 로그인한 유저 로컬스토리지에서 받아오기
	@PostMapping("/follow/{followto}")
	public ResponseEntity<?> addFollow(String user_id, @PathVariable String followto) {
		String followfrom = user_id;
		int result = userservice.addFollow(followfrom, followto);
		if (result == 0) { // DB에 등록하지 못했을 경우 반환
			return new ResponseEntity<String>("failed", HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	// 나를 팔로우 하는 유저 목록 //아이디 입력 시 누구든 보여주는 것
	@GetMapping("/followers/{followto}")
	public ResponseEntity<?> showFollowers(@PathVariable String followto) {
		List<String> list = userservice.showFollowers(followto);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<String>("No Result", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}

	// 내가 팔로우하는 사람들 목록
	@GetMapping("/follows/{followfrom}") // 아이디 입력 시 누구든 보여주는 것
	public ResponseEntity<?> showFollows(@PathVariable String followfrom) {
		List<String> list = userservice.showFollows(followfrom);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<String>("No Result", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}

	// 팔로우 삭제(내가 팔로우한 유저를 목록에서 삭제) //현재 로그인한 유저 로컬스토리지에서 받아오기
	@DeleteMapping("/follow/{followto}")
	public ResponseEntity<Void> deleteFollow(String user_id, @PathVariable String followto) {
		String followfrom = user_id;
		userservice.deleteFollow(followfrom, followto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
