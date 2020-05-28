package org.kpu.di.main;

import org.kpu.di.domain.StudentVO;
import org.kpu.di.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionSampleMain {
	
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("안녕하세요 TRANSACTION-MYBATIS");
	
//		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext_annotation.xml");
		
		MemberService memberService = ctx.getBean(MemberService.class);  // by Class name
		
		String strID1 = "hansol";
		StudentVO vo1 = new StudentVO(); 
		vo1.setId(strID1); vo1.setPasswd(strID1);  vo1.setSnum(strID1);
		vo1.setUsername("가나다라마바사아자차카타파ㅏㅎ하하하하하하");
		
		String strID2 = "dongjin";
		StudentVO vo2 = new StudentVO();
		vo2.setId(strID2); vo2.setPasswd("3334");  vo2.setSnum(strID2);
		vo2.setUsername(strID2);
		
		try {
			//memberService.addMember(vo1);
			//memberService.addMember(vo2);
			memberService.updateMemberList(vo1, vo2);
			System.out.println("TRANSACTION 처리 완료");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
