package org.kpu.myweb.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kpu.myweb.domain.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.kpu.myweb.mapper.StudentMapper";

	public StudentVO read(String id) throws Exception {
	
		StudentVO vo = sqlSession.selectOne(namespace+".selectByid", id);
		return vo;   
	}
 
	public List<StudentVO> readList() throws Exception {
		List<StudentVO> studentList = new ArrayList<StudentVO>();
		studentList = sqlSession.selectList(namespace + ".selectAll");
		return studentList;
	}
	
	public void add(StudentVO vo) throws Exception {
		sqlSession.insert(namespace + ".insert", vo);
	}

	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", id);
	}

	public void update(StudentVO student) throws Exception {
		// TODO Auto-generated method stub
	    sqlSession.update(namespace + ".update", student);
	}
	

}
