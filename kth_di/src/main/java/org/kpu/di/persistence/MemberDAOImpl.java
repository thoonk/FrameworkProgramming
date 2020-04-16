package org.kpu.di.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.kpu.di.domain.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public StudentVO read(String id) throws Exception{
		
		StudentVO vo=null;
		try {
			vo=jdbcTemplate.queryForObject(
					"SELECT * FROM STUDENT WHERE ID=?",
					new BeanPropertyRowMapper<StudentVO>(StudentVO.class), id);
				
		}catch(EmptyResultDataAccessException e) {
			return vo;
		}
		return vo;
	}
	
	public List<StudentVO> readList() throws Exception {
		List<StudentVO> studentlist = jdbcTemplate.query( 
		     "SELECT * FROM STUDENT", 
		     	new RowMapper<StudentVO>() {
		    	 	public StudentVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		    	 		StudentVO vo = new StudentVO();
		    	 		vo.setId(rs.getString("ID"));
		    	 		vo.setPasswd(rs.getString("PASSWD"));
		    	 		vo.setUsername(rs.getString("USERNAME"));
		    	 		vo.setSnum(rs.getString("SNUM"));
		    	 		vo.setDepart(rs.getString("DEPART"));
		    	 		vo.setMobile(rs.getString("MOBILE"));
		    	 		vo.setEmail(rs.getString("EMAIL"));
		    	 		return vo;
		    	 	}
             	}
		);
		return studentlist;
	}
	
	public void add(StudentVO vo) throws Exception {
		jdbcTemplate.update(
			"INSERT INTO STUDENT (ID, PASSWD, USERNAME, SNUM, DEPART, MOBILE, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?)"
			, vo.getId(), vo.getPasswd(), vo.getUsername(), vo.getSnum(), vo.getDepart(), vo.getMobile(), vo.getEmail());
	}
	
	public void update(StudentVO vo) throws Exception{
		
		jdbcTemplate.update("UPDATE STUDENT SET PASSWD = ?, MOBILE = ?, EMAIL = ?  WHERE ID = ?",
				vo.getPasswd(),
				vo.getMobile(),
				vo.getEmail(),
				vo.getId());
	}
	
	public void delete(String id) throws Exception{
		jdbcTemplate.update("DELETE FROM STUDENT WHERE ID = ?", id);
	}
	
}
