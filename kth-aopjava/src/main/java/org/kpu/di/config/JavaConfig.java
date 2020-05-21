package org.kpu.di.config;

import org.kpu.aop.MemberAspect;
import org.kpu.di.persistence.MemberDAO;
import org.kpu.di.persistence.MemberDAOImpl;
import org.kpu.di.service.MemberService;
import org.kpu.di.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy
public class JavaConfig{
	@Bean
	public MemberDAO memberDAO() {
		return new MemberDAOImpl();
	}
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberDAO());
	}
	@Bean
	public MemberAspect memberAspect() {
		return new MemberAspect();
	}
}
	

