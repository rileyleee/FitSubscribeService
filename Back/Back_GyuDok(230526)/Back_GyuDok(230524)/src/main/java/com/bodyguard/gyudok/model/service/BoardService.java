package com.bodyguard.gyudok.model.service;

import java.util.List;
import com.bodyguard.gyudok.model.dto.Board;

public interface BoardService {

	// 게시글 등록
	int writeBoard(Board board);

	// 게시글 수정
	void modifyBoard(Board board);

	// 게시글 상세 조회
	Board showOne(int id);

	// 조회 수 증가
	void addViewCnt(int id);

	// 게시글 삭제하기
	int removeOne(int id);

	// 키워드로 게시글 검색하기
	List<Board> searchBoards(String keyword);

	// 작성자로 게시글 조회하기
	List<Board> showUserBoards(String user_id);

	// 댓글 수 증가시키기
	void addReviewCnt(int id);

}
