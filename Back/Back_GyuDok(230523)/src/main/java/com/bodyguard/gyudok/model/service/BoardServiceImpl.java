package com.bodyguard.gyudok.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodyguard.gyudok.model.dao.BoardDao;
import com.bodyguard.gyudok.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao;

	@Autowired
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	// 게시글 등록
	@Override
	public int writeBoard(Board board){
		return boardDao.insertOne(board);
	}

	// 게시글 수정
	@Override
	public void modifyBoard(Board board) {
		boardDao.updateOne(board);
	}

	// 게시글 상세 조회
	@Override
	public Board showOne(int id) {
		return boardDao.selectOne(id);
	}

	// 조회 수 증가
	@Override
	public void addViewCnt(int id) {
		boardDao.addViewCnt(id);
	}

	// 게시글 삭제
	@Override
	public int removeOne(int id) {
		return boardDao.deleteOne(id);
	}

	// 검색어로 게시글 검색
	@Override
	public List<Board> searchBoards(String keyword) {
		return boardDao.selectBoards(keyword);
	}

	// 회원의 작성 게시글 전체 조회
	@Override
	public List<Board> showUserBoards(String user_id) {
		return boardDao.selectUserBoards(user_id);
	}
	// 댓글 작성 시 게시글의 댓글 수 증가
	@Override
	public void addReviewCnt(int id) {
		boardDao.addReviewCnt(id);
	}

}
