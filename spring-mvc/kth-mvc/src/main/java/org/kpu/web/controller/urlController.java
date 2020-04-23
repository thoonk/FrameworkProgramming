package org.kpu.web.controller;


import org.kpu.web.domain.StudentVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class urlController {
	private static final Logger logger = LoggerFactory.getLogger(urlController.class);
	
	@RequestMapping(value="/try/{msg}", method=RequestMethod.GET)
	public String getUserTest(@PathVariable("msg") String msg) {
		logger.info(msg);
		logger.info(" /try URL called. then getUserTest method executed.");
		return "result_a";
	}
	
	@RequestMapping(value="/tryA", method = RequestMethod.GET)
	public String getUserTest1(@RequestParam("msg") String msg ) {
		logger.info(msg);
		logger.info(" /tryA URL called. then getUserTest1 method executed.");

//		model.addAttribute("msg", msg);
		return "result_a";
	}
	
	@RequestMapping(value="/tryB", method = RequestMethod.GET)
	public String getUserTest2( @ModelAttribute("msg") String msg) {
		logger.info(msg);
		logger.info(" /tryB URL called. then getUserTest2 method executed.");
		return "result_b";
	}
	
	@RequestMapping(value={"/tryC", "/tryD"}, method = RequestMethod.GET)
	public String getUserTest3( @ModelAttribute("msg") String msg) {
		logger.info(msg);
		logger.info(" /tryC or /tryD URL called. then getUserTest3 method executed.");
		return "result_c";
	}
	
	@RequestMapping(value={"/tryF"}, method = RequestMethod.GET)
	public String getUserTest4Get() {

		logger.info(" /tryF URL GET method called. then getUserTest4Get method executed.");
		return "register";
	}
	
	@RequestMapping(value={"/tryF"}, method = RequestMethod.POST)
	public String setUserTest5Post( @ModelAttribute("student") StudentVO vo) {
		logger.info(vo.toString());
		logger.info(" /tryF URL POST method called. then setUserTest5Post method executed.");
		return "result_info";
	}
	
	@RequestMapping(value={"/tryFwd"}, method = RequestMethod.GET)
	public String setUserTest6(@ModelAttribute("msg") String msg) {
		logger.info(msg);
		logger.info(" /tryFwd URL GET method called. then setUserTest6 method executed.");
		return "forward:/tryB";
	}
	
	@RequestMapping(value={"/tryRdt"}, method = RequestMethod.GET)
	public String setUserTest7(@ModelAttribute("msg") String msg) {
		logger.info(msg);
		logger.info(" /tryRdt URL GET method called. then setUserTest7 method executed.");
		return "redirect:/tryB";
	}
	
}
