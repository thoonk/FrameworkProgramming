package org.kpu.di.persistence;

import java.util.HashMap;
import java.util.Map;

import org.kpu.di.domain.StudentVO;
import org.springframework.stereotype.Component;
@Component
public class MemberDAOImpl implements MemberDAO{
	private Map<String, StudentVO> storage = new HashMap<String, StudentVO>();
	public StudentVO read(String id) throws Exception {return storage.get(id);}
	public void add(StudentVO student) throws Exception{
		storage.put(student.getId(), student);
	}
}
