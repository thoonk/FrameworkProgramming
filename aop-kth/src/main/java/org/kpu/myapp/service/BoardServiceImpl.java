package org.kpu.myapp.service;

import java.util.List;

import org.kpu.myapp.domain.BoardVO;
import org.kpu.myapp.persistence.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void addBoard(BoardVO board) throws Exception {
		boardDAO.add(board);
	}

	@Override
	public void updateBoard(BoardVO board) throws Exception {
		boardDAO.update(board);
	}

	@Override
	public void deleteBoard(int num) throws Exception {
		boardDAO.delete(num);

	}

	@Override
	public List<BoardVO> readBoardList() throws Exception {
		return boardDAO.readList();
	}

	@Override
	public BoardVO readBoard(int num) throws Exception {
		return boardDAO.read(num);
	}

	@Override
	public void hitUpdateBoard(int num) throws Exception {
		boardDAO.setHitUpdate(num);
	}

	@Override
	public BoardVO writerCheck(BoardVO board) throws Exception {
		return boardDAO.isWriter(board);
	}

}
