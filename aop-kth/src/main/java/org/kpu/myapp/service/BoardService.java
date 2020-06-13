package org.kpu.myapp.service;

import java.util.List;

import org.kpu.myapp.domain.BoardVO;

public interface BoardService {
	public void addBoard(BoardVO board) throws Exception;
	public void updateBoard(BoardVO board) throws Exception;
	public void deleteBoard(int num) throws Exception;
	public List<BoardVO> readBoardList() throws Exception;
	public BoardVO readBoard(int num) throws Exception;
	public boolean writerCheck(BoardVO board) throws Exception;
	public BoardVO readAndHitBoard(int num) throws Exception;
}
