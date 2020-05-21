package org.kpu.di.service;

import org.kpu.di.domain.StudentVO;
import org.kpu.di.persistence.MemberDAO;
import org.springframework.stereotype.Component;
@Component
public class MemberServiceImpl implements MemberService{
	private MemberDAO memberDAO; 
	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public StudentVO readMember(String userid) throws Exception{
		return memberDAO.read(userid);
	}
	public void addMember(StudentVO student) throws Exception{
		memberDAO.add(student);
	}
}
