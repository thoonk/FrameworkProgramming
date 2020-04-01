
package org.kpu.di.main;

import org.kpu.di.domain.StudentVO;
import org.kpu.di.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberSampleMain {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("안녕하세요 KTH-XML");

//		ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MemberService memberService = (MemberService)ctx.getBean(MemberService.class);  // by Class name
//		MemberService memberService = (MemberService)ctx.getBean("memberService");  // by Component name 
		
		StudentVO vo = new StudentVO(); 
		vo.setId("kanadara");
		memberService.addMember(vo); 
		StudentVO member = memberService.readMember("kanadara");
		
		System.out.println(member);
	}

}
