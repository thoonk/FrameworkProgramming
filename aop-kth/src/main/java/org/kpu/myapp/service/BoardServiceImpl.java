package org.kpu.myapp.service;

import java.util.List;

import org.kpu.myapp.domain.BoardVO;
import org.kpu.myapp.persistence.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	public boolean writerCheck(BoardVO board) throws Exception {
		boolean check = boardDAO.isWriter(board);
		return check;
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=10)
	@Override
	public BoardVO readAndHitBoard(int num) throws Exception {
		boardDAO.setHitUpdate(num);
		return boardDAO.read(num);
	}
}
