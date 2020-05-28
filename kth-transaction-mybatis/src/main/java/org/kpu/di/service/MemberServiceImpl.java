package org.kpu.di.service;

import java.util.List;

import org.kpu.di.domain.StudentVO;
import org.kpu.di.persistence.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	public StudentVO readMember(String id) throws Exception {
		return memberDAO.read(id);
	}
	
	public List<StudentVO> readMemberList() throws Exception{
		return memberDAO.readList();
	}
	
	public void addMember(StudentVO student) throws Exception {
		memberDAO.add(student);
	}
	
	public void deleteMember(String id) throws Exception {
		memberDAO.delete(id);
	}
	
	public void updateMember(StudentVO student) throws Exception {
		memberDAO.update(student);
	}
	
	@Transactional ( propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=10 ) //NEVER, SUPPORTS, NOT_SUPPORTED, REQUIRED, MANDATORY
	public void updateMemberList(StudentVO student1, StudentVO student2) throws Exception {
		memberDAO.update(student2);
		memberDAO.update(student1);
	}
}
