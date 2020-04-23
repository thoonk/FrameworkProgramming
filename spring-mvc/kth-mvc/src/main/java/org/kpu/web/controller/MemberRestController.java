package org.kpu.web.controller;

import java.nio.charset.Charset;

import org.kpu.web.domain.StudentVO;
// import org.kpu.web.exception.DataNotFoundException;
import org.kpu.web.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member/rest")
public class MemberRestController {

	@Autowired(required=true)
    private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberRestController.class);
	
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentVO> readMember(@PathVariable String id) throws Exception {
    	StudentVO student = memberService.readMember(id);
    	
		logger.info(" /member/rest/{id} REST-API GET method called. then readMember method executed.");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		headers.set("My-Header", "MyHeaderValue");
		return new ResponseEntity<StudentVO>(student, headers, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
	public String createMemberPost( @RequestBody StudentVO vo) throws Exception {
		memberService.addMember(vo);

		logger.info(vo.toString());
		logger.info(" /member/rest/{id} REST-API POST method called. then createMemberPost method executed.");
		return "OK";
	}
	/*
    @ExceptionHandler(DataNotFoundException.class)
    public String handleException(DataNotFoundException e) {
        return "MemberRestController: student is not found";
    }

    @ExceptionHandler
    public String handleException(Exception e) {
        return "MemberRestController: server internal error";
    }
	*/
}
