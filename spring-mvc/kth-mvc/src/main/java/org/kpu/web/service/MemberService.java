package org.kpu.web.service;

import java.util.List;

import org.kpu.web.domain.StudentVO;

public interface MemberService {
	public StudentVO readMember(String id) throws Exception;
	public void addMember(StudentVO student) throws Exception;
	public List<StudentVO> readMemberList() throws Exception;
	public void updateMember(StudentVO student) throws Exception;
	public void deleteMember(String id) throws Exception;
}
