package org.kpu.myapp.persistence;

import java.util.List;

import org.kpu.myapp.domain.BoardVO;

public interface BoardDAO {
	public void add(BoardVO board) throws Exception;
	public void update(BoardVO board) throws Exception;
	public void delete(int num) throws Exception;
	public List<BoardVO> readList() throws Exception;
	public BoardVO read(int num) throws Exception;
	public void setHitUpdate(int num) throws Exception;
	public BoardVO isWriter(BoardVO board) throws Exception;
}
