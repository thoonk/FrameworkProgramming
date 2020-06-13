package org.kpu.myapp.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kpu.myapp.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.kpu.myapp.mapper.BoardMapper";
	
	
	
	@Override
	public void add(BoardVO board) throws Exception {
		sqlSession.insert(namespace + ".insert", board);
	}

	@Override
	public void update(BoardVO board) throws Exception {
		sqlSession.update(namespace + ".update", board);
	}

	@Override
	public void delete(int num) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", num);
	}

	@Override
	public List<BoardVO> readList() throws Exception {
		return sqlSession.selectList(namespace + ".selectAll");
	}

	@Override
	public BoardVO read(int num) throws Exception {
		BoardVO vo = sqlSession.selectOne(namespace + ".selectBynum", num);
		return vo;
	}

	@Override
	public void setHitUpdate(int num) throws Exception {
		sqlSession.update(namespace + ".hitUpdate", num);
	}

	@Override
	public boolean isWriter(BoardVO board) throws Exception {
		String check = sqlSession.selectOne(namespace + ".isWriter", board);
		//System.out.println("체크!!!!!" + check);
		return (check == null) ? false : true;
	}
}
