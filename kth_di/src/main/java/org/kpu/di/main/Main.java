package org.kpu.di.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.kpu.di.domain.StudentVO;
import org.kpu.di.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) {
		
		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		MemberService memberService = ctx.getBean(MemberService.class); 
		
		String strID = "Kim";
		String strPW = "1234";
		String strUsername = "TaeHoon";
		String strSnum = "2015150012";
		String strDepart = "컴공";
		String strMobile = "01011112222";
		String strEmail = "dkrmrm878@kpu.ac.kr";
		
		StudentVO vo = new StudentVO(); 
		vo.setId(strID); vo.setPasswd(strPW);  vo.setUsername(strUsername); vo.setSnum(strSnum);
		vo.setDepart(strDepart); vo.setMobile(strMobile); vo.setEmail(strEmail);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.println(" 학생 정보 관리 프로그램");
		
		
	
		while(true) {
			System.out.println("1, 전체 학생 정보 출력");
			System.out.println("2, 개인 학생 정보 출력");
			System.out.println("3, 개인 학생 정보 생성");
			System.out.println("4, 개인 학생 정보 수정");
			System.out.println("5, 개인 학생 정보 삭제");
			System.out.println("6, 프로그램 종료");
			System.out.println("-------------------------");
			System.out.print("select >>");
			
			try {
				int sel = scan.nextInt();
				scan.nextLine();
				
				switch(sel) {
				case 1: 
					List<StudentVO> list = memberService.readMemberList();
					for(StudentVO svo : list) {
						System.out.println(svo);
					}
					break; 
				case 2:
					StudentVO member = memberService.readMember(strID);
					System.out.println(member);
					break; 
				case 3:
					memberService.addMember(vo);
					System.out.println("생성 완료");
					break; 
				case 4: 
					vo.setPasswd("2323"); vo.setMobile("010-2323-4343"); vo.setEmail("asdf@naver.com");
					memberService.updateMember(vo);
					System.out.println("업데이트 완료");
					break;
				case 5: 
					memberService.deleteMember(strID);
					System.out.println("삭제 완료");
					break;
				case 6:
					System.out.println("안녕히 가세요."); 
					return;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("확인 후 입력하세요.");
				continue;
			}catch(Exception e) {
				e.printStackTrace();
			}		
		}
	}
}
