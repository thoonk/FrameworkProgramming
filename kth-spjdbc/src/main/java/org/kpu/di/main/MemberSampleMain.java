package org.kpu.di.main;

import java.util.List;

import org.kpu.di.domain.StudentVO;
import org.kpu.di.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class MemberSampleMain {

	
private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("안녕하세요 DB-SPRINGJDBC");

		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		MemberService memberService = ctx.getBean(MemberService.class);  // by Class name
		
		String strID = "Kim";
		String strPW = "1234";
		String strUsername = "KimTaeHoon";
		String strSnum = "2015150012";
		String strDepart = "컴공";
		String strMobile = "01011112222";
		String strEmail = "dkrmrm878@gmail.com";
		
		StudentVO vo = new StudentVO(); 
		vo.setId(strID); vo.setPasswd(strPW);  vo.setUsername(strUsername); vo.setSnum(strSnum);
		vo.setDepart(strDepart); vo.setMobile(strMobile); vo.setEmail(strEmail);
		try {
			memberService.addMember(vo);
			StudentVO member = memberService.readMember(strID);
			System.out.println(member);
			
			List<StudentVO> list = memberService.readMemberList();
			for(StudentVO svo : list) {
				System.out.println(svo);
			}

		} catch(DataAccessException e) {
			System.out.println(e);
			
		} finally {  //Check Count  
			JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
			int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM STUDENT", Integer.class);
			System.out.println(count);
		}
		
	}

}
