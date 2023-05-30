package com.bodyguard.gyudok.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodyguard.gyudok.model.dao.UserDao;
import com.bodyguard.gyudok.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userdao;

	@Autowired
	public UserServiceImpl(UserDao userdao) {
		this.userdao = userdao;
	}

	// 회원정보
	@Override
	public User select(String id) {
		return userdao.selectOne(id);
	}

	// 닉네임 또는 지역으로 가져오기
	@Override
	public List<User> selectNickName(String nickname) {
		return userdao.selectNickName(nickname);
	}

	// 회원등록
	@Override
	public int regist(User user) {
		return userdao.registOne(user);
	}

	// 로그인
	@Override
	public User login(String id, String password) {
		return userdao.login(id, password);
	}

	// 회원정보수정
	@Override
	public int modify(User user) {
		return userdao.modifyOne(user);
	}

	// 회원삭제
	@Override
	public int delete(String id) {
		return userdao.deleteOne(id);
	}

	// 팔로우 저장
	@Override
	public int addFollow(String followfrom, String followto) {
		return userdao.addFollow(followfrom, followto);
	}

	// 팔로워 보기
	@Override
	public List<String> showFollowers(String followto) {
		return userdao.showFollowers(followto);
	}

	// 팔로잉 보기
	@Override
	public List<String> showFollows(String followfrom) {
		return userdao.showFollows(followfrom);
	}

	// 팔로우 삭제
	@Override
	public void deleteFollow(String followfrom, String followto) {
		userdao.deleteFollow(followfrom, followto);
	}

	// 구독 온도 증가
	@Override
	public void addSubsTemp(String user_id) {
		userdao.addSubsTemp(user_id);
	}

	// 게시글 등록 온도 증가
	@Override
	public void addBoardTemp(String user_id) {
		userdao.addBoardTemp(user_id);
	}

	// 게시글 삭제 온도 감소
	@Override
	public void removeBoardTemp(String user_id) {
		userdao.removeBoardTemp(user_id);
	}

	// 댓글 등록 온도 증가
	@Override
	public void addReviewTemp(String user_id) {
		userdao.addReviewTemp(user_id);
	}

	// 댓글 삭제 온도 감소
	@Override
	public void removeReviewTemp(String user_id) {
		userdao.removeReviewTemp(user_id);
	}

	// 리뷰 평점 등록 온도 증가
	@Override
	public void addRatingTemp(String user_id) {
		userdao.addRatingTemp(user_id);
	}

	// 리뷰 평점 삭제 온도 감소
	@Override
	public void removeRatingTemp(String user_id) {
		userdao.removeRatingTemp(user_id);
	}

}
