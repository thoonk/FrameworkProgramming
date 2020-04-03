package org.kpu.di.config;

import org.kpu.di.persistence.MemberDAO;
import org.kpu.di.persistence.MemberDAOImpl;
import org.kpu.di.service.MemberService;
import org.kpu.di.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JavaConfig {
	
	@Bean
    public MemberDAO memberDAO() {
        return new MemberDAOImpl();
    }
	
//	@Bean(name="service")
	@Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberDAO());
    }
	
}