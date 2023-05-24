package com.bodyguard.gyudok.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.bodyguard.gyudok.model.dto.Review;
import com.bodyguard.gyudok.model.service.BoardService;
import com.bodyguard.gyudok.model.service.ReviewService;
import com.bodyguard.gyudok.model.service.UserService;

@RestController
@RequestMapping("/gyudok-review")
public class ReviewRestController {

	private ReviewService reviewService;
	private BoardService boardService;
	private UserService userService;

	@Autowired
	public ReviewRestController(ReviewService reviewService, BoardService boardService, UserService userService) {
		this.reviewService = reviewService;
		this.boardService = boardService;
		this.userService = userService;
	}

	// 댓글 등록하기
	@PostMapping("/review")
	public ResponseEntity<?> write(Review review) {
		// 로그인 유저를 작성자로 설정하기

		int result = reviewService.writeReview(review);
		if (result == 0) { // DB에 등록하지 못했을 경우 반환
			return new ResponseEntity<String>("regist_failed", HttpStatus.UNAUTHORIZED);
		} else {
			// 게시글의 댓글 수 증가
			boardService.addReviewCnt(review.getBoard_id());
			// 유저의 온도 증가 0.1점
			userService.addReviewTemp(review.getUser_id());
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		}
	}

	// 댓글 상세 조회하기
	@GetMapping("/review/{id}")
	public ResponseEntity<?> showOne(@PathVariable int id) {
		Review review = reviewService.showOne(id);
		if (review == null) {
			return new ResponseEntity<String>("get_failed", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}

	// 댓글 수정하기
	@PatchMapping("/review")
	public ResponseEntity<String> modify(Review review) {
		reviewService.modifyReview(review);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	// 댓글 삭제하기
	@DeleteMapping("/review/{id}")
	public ResponseEntity<?> removeOne(Review review, String user_id) {
		// 로컬 스토리지의 유저와 비교

		if (review.getUser_id().equals(user_id)) {
			int result = reviewService.removeOne(review.getId());
			if (result == 0) { // 삭제하지 못했을 경우
				return new ResponseEntity<String>("delete_failed", HttpStatus.UNAUTHORIZED);
			} else {
				// 유저의 온도 감소 0.1점
				userService.removeReviewTemp(user_id);
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<String>("delete_failed", HttpStatus.UNAUTHORIZED);
		}

	}

	// 특정 게시글의 모든 댓글 검색하기
	@GetMapping("/reviews/board/{board_id}")
	public ResponseEntity<?> showBoardReviews(@PathVariable int board_id) {
		List<Review> list = reviewService.showBoardReviews(board_id);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<String>("No Result", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}

	// 작성자별 댓글 조회
	@GetMapping("/reviews/user/{user_id}")
	public ResponseEntity<?> showUsersReviews(@PathVariable String user_id) {
		List<Review> list = reviewService.showUserReviews(user_id);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<String>("No Result", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}

}
