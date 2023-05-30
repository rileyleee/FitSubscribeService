package com.bodyguard.gyudok.model.service;

import java.util.List;

import com.bodyguard.gyudok.model.dto.User;

public interface UserService {

	//아이디로 사용자 가져오기
	public User select(String id);
	
	//닉네임 또는 지역으로 사용자 가져오기
	public List<User> selectNickName(String nickname);

	//사용자 등록
	public int regist(User user);
	
	//로그인 -> localstorage에 저장 할꺼니까 user 반환
	public User login(String id, String password);
	
	//사용자 수정
	public int modify(User user);
	
	//사용자 삭제
	public int delete(String id);

	// 팔로우 저장
	public int addFollow(String followfromId, String followtoId);

	// 팔로워 보기
	public List<String> showFollowers(String followtoId);

	// 팔로잉 보기
	public List<String> showFollows(String followfromId);

	// 팔로우 삭제
	public void deleteFollow(String followfromId, String followtoId);

	// 구독 온도 증가
	public void addSubsTemp(String user_id);

	// 게시글 등록 온도 증가
	public void addBoardTemp(String user_id);

	// 게시글 삭제 온도 감소
	public void removeBoardTemp(String user_id);

	// 댓글 등록 온도 증가
	public void addReviewTemp(String user_id);

	// 댓글 삭제 온도 감소
	public void removeReviewTemp(String user_id);

	// 리뷰 평점 등록 온도 증가
	public void addRatingTemp(String user_id);

	// 리뷰 평점 삭제 온도 감소
	public void removeRatingTemp(String user_id);

}
