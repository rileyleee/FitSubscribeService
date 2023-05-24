package com.bodyguard.gyudok.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bodyguard.gyudok.model.dto.User;

public interface UserDao {

	//아이디로 정보 불러오기
	public User selectOne(String id);
	
	//닉네임또는 지역으로 정보 불러오기
	public List<User> selectNickName(String nickname);
	
	//회원등록
	public int registOne(User user);	
	
	//로그인
	public User login(@Param("id") String id, @Param("password") String password);
	
	//회원정보수정
	public int modifyOne(User user);
	
	//회원삭제
	public int deleteOne(String id);

	// 팔로우 추가
	public int addFollow(String followfrom, String followto);

	// 팔로워 보기
	public List<String> showFollowers(String followto);

	// 팔로잉 보기
	public void deleteFollow(String followfrom, String followto);

	// 팔로우 삭제
	public List<String> showFollows(String followfrom);

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
