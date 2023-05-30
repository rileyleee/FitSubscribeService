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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bodyguard.gyudok.model.dto.Board;
import com.bodyguard.gyudok.model.service.BoardService;
import com.bodyguard.gyudok.model.service.UserService;

@RestController
@RequestMapping("/gyudok-board")
public class BoardRestController {

	private BoardService boardService;
	private UserService userService;

	@Autowired
	public BoardRestController(BoardService boardService, UserService userService) {
		this.boardService = boardService;
		this.userService = userService;
	}

	// 프론트 단에 저장
	private String fileDir = "C:\\Users\\whddl\\Desktop\\최종 프로젝트\\Front\\5안\\gyudok\\src\\assets\\upload\\";
	
	// 게시글 등록하기
	@PostMapping("/board")
	public ResponseEntity<?> write(Board board, @RequestParam(value = "file", required = false) MultipartFile file)
			throws IllegalStateException, IOException {

		// 로그인 유저를 작성자로 설정하기

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
			board.setFilePath(fullpath);
			board.setFileName(currentDate + "/" + System.currentTimeMillis() + "_" + file.getOriginalFilename());
		}
		int result = boardService.writeBoard(board);
		if (result == 0) { // DB에 등록하지 못했을 경우 반환
			return new ResponseEntity<String>("regist_failed", HttpStatus.UNAUTHORIZED);
		} else {
			// 유저 온도 점수 올리기 0.5점
			userService.addBoardTemp(board.getUser_id());
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		}
	}

	// 게시글 상세 조회하기
	@GetMapping("/board/{id}")
	public ResponseEntity<?> showOne(@PathVariable int id) {
		Board board = boardService.showOne(id);
		if (board == null) {
			return new ResponseEntity<String>("get_failed", HttpStatus.NOT_FOUND);
		}
		boardService.addViewCnt(id);
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}

	// 게시글 수정하기
	@PatchMapping("/board")
	public ResponseEntity<String> modify(Board board) {
		// 로그인한 유저와 작성자가 같으면
		boardService.modifyBoard(board);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	// 게시글 삭제하기
	@DeleteMapping("/board/{id}")
	public ResponseEntity<?> removeOne(@PathVariable int id) {

		int result = boardService.removeOne(id);
		if (result == 0) { // 삭제하지 못했을 경우
			return new ResponseEntity<String>("delete_failed", HttpStatus.UNAUTHORIZED);
		} else {
			// 유저 온도 점수 감소 0.5점
			//userService.removeBoardTemp(user_id);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		}
	}

	// 키워드로 게시글 검색하기
	@GetMapping("/boards")
	public ResponseEntity<?> searchBoards(String keyword) {
		List<Board> list = boardService.searchBoards(keyword);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<String>("No Result", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}

	// 작성자별 게시글 조회
	@GetMapping("/boards/{user_id}")
	public ResponseEntity<?> showUsersBoards(@PathVariable String user_id) {
		List<Board> list = boardService.showUserBoards(user_id);
//		if (list == null || list.size() == 0) {
//			return new ResponseEntity<String>("No Result", HttpStatus.NOT_FOUND);
//		}
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}
}
