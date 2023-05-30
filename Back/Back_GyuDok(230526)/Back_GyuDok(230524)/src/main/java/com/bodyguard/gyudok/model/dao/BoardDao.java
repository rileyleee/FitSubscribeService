package com.bodyguard.gyudok.model.dao;

import java.util.List;

import com.bodyguard.gyudok.model.dto.Board;

public interface BoardDao {

	// 게시글 등록
	public int insertOne(Board board);

	// 게시글 수정
	public void updateOne(Board board);

	// 게시글 상세 조회
	public Board selectOne(int id);

	// 조회 수 증가
	public void addViewCnt(int id);

	// 게시글 삭제
	public int deleteOne(int id);

	// 키워드로 게시글 검색
	public List<Board> selectBoards(String keyword);

	// 작성자별 게시글 조회
	public List<Board> selectUserBoards(String user_id);

	// 게시글의 댓글 수 증가시키기
	public void addReviewCnt(int id);

}
