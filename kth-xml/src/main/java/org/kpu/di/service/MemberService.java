package org.kpu.di.service;

import org.kpu.di.domain.StudentVO;

public interface MemberService {
	public StudentVO readMember(String id) throws Exception;
	public void addMember(StudentVO student) throws Exception;
}
