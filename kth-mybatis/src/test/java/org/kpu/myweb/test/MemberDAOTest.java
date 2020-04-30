package org.kpu.myweb.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpu.myweb.domain.StudentVO;
import org.kpu.myweb.persistence.MemberDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MemberDAOTest {

	@Autowired
	private MemberDAO dao;
	private static Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);
	
	@Test
	public void testReadByid() throws Exception {
		StudentVO vo;
		vo = dao.read("hansol");

		logger.info(vo.toString());
	}
	@Test
	public void testReadList() throws Exception {
		List<StudentVO> voList;
		voList = dao.readList();

		for(StudentVO svo : voList) {
			logger.info(svo.toString());
		}
	}
}
