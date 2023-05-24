package com.bodyguard.gyudok.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bodyguard.gyudok.model.dto.Fac_Review;
import com.bodyguard.gyudok.model.dto.Fac_Use;
import com.bodyguard.gyudok.model.dto.Fac_Zzim;
import com.bodyguard.gyudok.model.dto.Facility;
import com.bodyguard.gyudok.model.dto.Fit_Subs;
import com.bodyguard.gyudok.model.dto.Train_Review;
import com.bodyguard.gyudok.model.dto.Train_subs;
import com.bodyguard.gyudok.model.dto.User;
import com.bodyguard.gyudok.model.service.Fac_ReviewService;
import com.bodyguard.gyudok.model.service.Fac_SubsService;
import com.bodyguard.gyudok.model.service.Train_ReviewService;
import com.bodyguard.gyudok.model.service.Train_SubsService;
import com.bodyguard.gyudok.model.service.UserService;

@RestController
@RequestMapping("/gyudok-subs")
public class SubsController {

	private UserService userservice;
	private Train_ReviewService train_reviewservice;
	private Train_SubsService train_subsservice;
	private Fac_SubsService fac_subsService;
	private Fac_ReviewService fac_reviewService;

	@Autowired
	public SubsController(UserService userservice, Train_ReviewService t_reviewservice,
			Train_SubsService train_subsservice, Fac_SubsService fac_subsService, Fac_ReviewService fac_reviewService) {
		this.userservice = userservice;
		this.train_reviewservice = t_reviewservice;
		this.train_subsservice = train_subsservice;
		this.fac_subsService = fac_subsService;
		this.fac_reviewService = fac_reviewService;
	}

// =========================================== 트레이너 구독 ==============================================//

	// 이름 또는 지역으로 검색
	@GetMapping("/tsearch")
	public ResponseEntity<?> search(String nameregion) {
		// 이랬을때 지역 or 이름으로 검색
		List<User> list = userservice.selectNickName(nameregion);
		if (list == null || list.size() == 0) {
			// 없으면 그냥 없다는걸 보여줘
			return new ResponseEntity<String>("No Result", HttpStatus.NOT_FOUND);
		}
		// 있으면 해당하는 리스트를 보여줘
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	// 트레이너구독
	@PostMapping("/trainsub")
	public ResponseEntity<Integer> trainsub(Train_subs train_subs) {
		train_subsservice.registOne(train_subs);
		// 구독 온도 증가
		userservice.addSubsTemp(train_subs.getTrainee_id());
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	// 트레이너구독 정보 리스트 뽑음
	@GetMapping("/trainsubs")
	public ResponseEntity<?> trainsubs(String trainee_id) {
		List<Train_subs> list = train_subsservice.showAll(trainee_id);
		if (list == null || list.size() == 0) {
			// 없으면 그냥 없다는걸 보여줘
			return new ResponseEntity<String>("No Result", HttpStatus.NOT_FOUND);
		}
		// 있으면 해당하는 리스트를 가져와서 해당 트레이너의 닉네임을 나오게 해줘
		return new ResponseEntity<List<Train_subs>>(list, HttpStatus.OK);
	}

	// 내가 구독한 트레이너에 대해서 리뷰+평점 작성 가능하게 화면을 바꿔주자
	@PostMapping("/trainreview")
	public ResponseEntity<Integer> trainreview(Train_Review train_review) {
		train_reviewservice.registOne(train_review);
		// 리뷰 + 평점 점수 주기 0.3점
		userservice.addRatingTemp(train_review.getTrainee_id());
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	// 내가 작성한 트레이너 리뷰 전체 리스트 - 로그인한 내 이름으로 검색
	@GetMapping("/trainreview")
	public ResponseEntity<?> mytrainreview(String trainee_id) {
		List<Train_Review> list = train_reviewservice.showMYreview(trainee_id);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<String>("No Result", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Train_Review>>(list, HttpStatus.OK);
	}

	// 다른사람이 작성한 트레이너 리뷰 전체 리스트 - 트레이너로 검색
	@GetMapping("/trainerreview")
	public ResponseEntity<?> trainerreview(String trainer_nickname) {
		List<Train_Review> list = train_reviewservice.showAll(trainer_nickname);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<String>("No Result", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Train_Review>>(list, HttpStatus.OK);
	}

//============================================운동시설 구독==================================================//

	// 운동시설 구독 신청 기능
	@PostMapping("/facsubs/{user_id}")
	public ResponseEntity<?> facSubs(Fit_Subs fit_subs) {
		fit_subs.setStartdate(LocalDate.now().plusDays(1));
		fit_subs.setEnddate(fit_subs.getStartdate().plusMonths(fit_subs.getMonths()).minusDays(1));

		int result = fac_subsService.facSubs(fit_subs);
		if (result == 0) { // DB에 등록하지 못했을 경우 반환
			return new ResponseEntity<String>("failed", HttpStatus.UNAUTHORIZED);
		}
		// 구독 온도 증가
//		userservice.addSubsTemp(fit_subs.getUser_id());
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	// 운동시설 구독 현황 조회하기
	@GetMapping("/facsubs/{user_id}")
	public ResponseEntity<?> showfacSubs(@PathVariable String user_id) {

		// 로그인 한 유저 가져와서 담기

		Fit_Subs fac_subs = fac_subsService.showfacSubs(user_id);
		if (fac_subs == null) {
			return new ResponseEntity<String>("get_failed", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Fit_Subs>(fac_subs, HttpStatus.OK);
	}

	// 운동시설 현재+과거 구독 내역 조회하기
	@GetMapping("/facsubs/history/{user_id}")
	public ResponseEntity<?> showfacSubsHistory(@PathVariable String user_id) {
		// 로그인 한 유저 가져와서 담기
		List<Fit_Subs> list = fac_subsService.showfacSubsHistory(user_id);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<String>("No Result", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Fit_Subs>>(list, HttpStatus.OK);
	}

	// 운동시설 검색 기능 // 키워드 없으면 전체 조회? -> 단, 매퍼에서 갯수 제한하자(10개)
	// 검색가능 키워드: 시군구, 시설명, 운동 종류
	@GetMapping("/facsubs/search/{keyword}")
	public ResponseEntity<?> searchFacs(@PathVariable String keyword) {
		List<Facility> list = fac_subsService.searchFacs(keyword);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<String>("No Result", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Facility>>(list, HttpStatus.OK);
	}

	// 운동시설 상세 조회
	@GetMapping("/facility/{id}")
	public ResponseEntity<?> showFac(@PathVariable int id) {
		Facility facility = fac_subsService.showFac(id);
		if (facility == null) {
			return new ResponseEntity<String>("get_failed", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Facility>(facility, HttpStatus.OK);
	}

	// 운동시설 이용하기
	@PostMapping("/facility/use")
	public ResponseEntity<?> useFac(Fac_Use fac_use) {

		// 로그인 한 유저 가져와서 담기

		int result = fac_subsService.useFac(fac_use);
		if (result == 0) { // DB에 등록하지 못했을 경우 반환
			return new ResponseEntity<String>("failed", HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	// 운동시설 이용내역 조회하기
	@GetMapping("/facility/history/{user_id}")
	public ResponseEntity<?> facUseHistory(@PathVariable String user_id) {

		// 로그인 한 유저 가져와서 담기

		List<Facility> list = fac_subsService.facUseHistory(user_id);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<String>("No Result", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Facility>>(list, HttpStatus.OK);
	}

	// 운동시설 찜하기
	@PostMapping("/facility/zzim")
	public ResponseEntity<?> registFacZzim(Fac_Zzim fac_zzim) {

		// 로그인 한 유저 가져와서 담기

		int result = fac_subsService.registFacZzim(fac_zzim);
		if (result == 0) { // DB에 등록하지 못했을 경우 반환
			return new ResponseEntity<String>("failed", HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	// 운동시설 찜 삭제하기
	@DeleteMapping("/facility/zzim")
	public ResponseEntity<?> removeFacZzim(Fac_Zzim fac_zzim) {

		// 로그인 한 유저 가져와서 담기

		int result = fac_subsService.removeFacZzim(fac_zzim);
		if (result == 0) { // DB에 등록하지 못했을 경우 반환
			return new ResponseEntity<String>("failed", HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	// 운동시설 찜 목록 조회하기
	@GetMapping("/facility/zzim/{user_id}")
	public ResponseEntity<?> showFacZzims(@PathVariable String user_id) {

		// 로그인 한 유저 가져와서 담기

		List<Facility> list = fac_subsService.showFacZzims(user_id);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<String>("No Result", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Facility>>(list, HttpStatus.OK);
	}

	// 운동시설 리뷰 및 평점 기록하기
	@PostMapping("/facility/review")
	public ResponseEntity<?> registFacReview(Fac_Review fac_Review) {

		// 로그인 한 유저 가져와서 담기

		int result = fac_reviewService.registFacReview(fac_Review);
		if (result == 0) { // DB에 등록하지 못했을 경우 반환
			return new ResponseEntity<String>("failed", HttpStatus.UNAUTHORIZED);
		}
		// 리뷰 + 평점 점수 주기 0.3점
		userservice.addRatingTemp(fac_Review.getUser_id());
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	// 내가 작성한 운동시설 리뷰 모두 조회하기
	@GetMapping("/facility/reviews/{user_id}")
	public ResponseEntity<?> showUserFacReviews(@PathVariable String user_id) {
		// 로그인 한 유저 가져와서 담기

		List<Fac_Review> list = fac_reviewService.showUserFacReviews(user_id);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<String>("No Result", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Fac_Review>>(list, HttpStatus.OK);

	}

	// 특정 운동시설의 리뷰 조회하기
	@GetMapping("/facility/reviews/{id}")
	public ResponseEntity<?> showFacReviews(@PathVariable int id) {
		List<Fac_Review> list = fac_reviewService.showFacReviews(id);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<String>("No Result", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Fac_Review>>(list, HttpStatus.OK);
	}

	// 내가 작성한 리뷰 삭제하기
	@DeleteMapping("/facility/review/{id}")
	public ResponseEntity<?> removeFacReviews(@PathVariable String user_id, @PathVariable int id) {
		// 로그인 한 유저 가져와서 담기

		int result = fac_reviewService.removeFacReviews(user_id, id);
		if (result == 0) { // 삭제하지 못했을 경우
			return new ResponseEntity<String>("delete_failed", HttpStatus.UNAUTHORIZED);
		} else {
			// 유저의 온도 감소 0.3점
			userservice.removeRatingTemp(user_id);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		}
	}
}
