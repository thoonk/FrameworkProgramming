package org.kpu.myapp.service;

import java.util.List;

import org.kpu.myapp.domain.BoardVO;

public interface BoardService {
	public void addBoard(BoardVO board) throws Exception;
	public void updateBoard(BoardVO board) throws Exception;
	public void deleteBoard(int num) throws Exception;
	public List<BoardVO> readBoardList() throws Exception;
	public BoardVO readBoard(int num) throws Exception;
	public void hitUpdateBoard(int num) throws Exception;
	public BoardVO writerCheck(BoardVO board) throws Exception;
}
