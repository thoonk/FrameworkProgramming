package org.kpu.di.main;

import org.kpu.di.domain.StudentVO;
import org.kpu.di.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberSampleMain {	
	private static ApplicationContext ctx = null;
	public static void main(String[] args) throws Exception{
		System.out.println("안녕하세요 AOP-ANNOTATION");
		
		ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		MemberService memberService = ctx.getBean(MemberService.class);	
		
		StudentVO vo = new StudentVO(); 
		vo.setId("Kim"); vo.setPasswd("1234"); vo.setDepart("컴퓨터공학부"); vo.setSnum("2015150012"); 
		vo.setMobile("010-2323-2323"); vo.setEmail("dkrmrm878@gmail.com"); vo.setUsername("Taehoon");
		memberService.addMember(vo);
		
		StudentVO member = memberService.readMember("Kim");
		System.out.println(member);
	}
}
