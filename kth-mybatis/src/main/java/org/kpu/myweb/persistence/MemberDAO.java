package org.kpu.myweb.persistence;

import java.util.List;

import org.kpu.myweb.domain.StudentVO;

public interface MemberDAO {

	public void add(StudentVO student) throws Exception;
	public List<StudentVO> readList() throws Exception;
	public StudentVO read(String id) throws Exception;
	public void delete(String id) throws Exception;
	public void update(StudentVO student) throws Exception;

}
