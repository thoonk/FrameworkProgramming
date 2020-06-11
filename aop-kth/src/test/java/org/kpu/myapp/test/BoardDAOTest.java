package org.kpu.myapp.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpu.myapp.domain.BoardVO;
import org.kpu.myapp.persistence.BoardDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class BoardDAOTest {

	@Autowired
	private BoardDAO dao;
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Test
	public void testReadBynum() throws Exception {
		BoardVO vo;
		vo = dao.read(1);

		logger.info(vo.toString());
	}

	@Test
	public void testReadList() throws Exception {
		List<BoardVO> voList;
		voList = dao.readList();

		for (BoardVO svo : voList) {
			logger.info(svo.toString());
		}
	}

	@Test
	public void testWriterCheckBynum() throws Exception {
		BoardVO vo;
		dao.delete(3);
	}
}
