package kth_di;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpu.di.domain.StudentVO;
import org.kpu.di.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class MemberTest {
	@Autowired
	MemberService memberService;
	
	@Test
	public void testAddMember() throws Exception{
		String strID = "JUnit";
		StudentVO vo = new StudentVO();
		vo.setId(strID);
		vo.setPasswd(strID);
		vo.setUsername(strID);
		vo.setSnum(strID);
		memberService.addMember(vo);
		StudentVO member = memberService.readMember("Junit");
		System.out.println(member);
	}
	
	@Test
	public void testReadMember() throws Exception{
		StudentVO member = memberService.readMember("Junit");
		System.out.println(member);
	}
	
	@Test
	public void testDeleteMember() throws Exception{
		memberService.deleteMember("Junit");
		StudentVO member = memberService.readMember("Junit");
		System.out.println(member);
	}
}
