package org.kpu.myapp.controller;

import java.util.List;

import org.kpu.myapp.domain.BoardVO;
import org.kpu.myapp.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value= {"/list"}, method = RequestMethod.GET)
	public String listBoard(Model model) throws Exception{
		List<BoardVO> boards = boardService.readBoardList();
		model.addAttribute("boards", boards);
		return "board/board_list";
	}
	
	@RequestMapping(value= "/read", method = RequestMethod.GET)
	public String readBoard(@RequestParam("num") int num, Model model) throws Exception{
		BoardVO board = boardService.readBoard(num);
		boardService.hitUpdateBoard(num);
		logger.info(" /read?num=? URL called. then readMemebr method executed.");
		model.addAttribute("board", board);
		return "board/board_read";
	}
	
	@RequestMapping(value= {"/write"}, method = RequestMethod.GET)
	public String showBoardWrite() throws Exception{
		logger.info(" /register URL GET method called. then forward member_register.jsp.");
		return "board/board_write";
	}
	
	@RequestMapping(value = {"/write"}, method = RequestMethod.POST)
	public String createMember( @ModelAttribute("board") BoardVO vo) throws Exception {
		boardService.addBoard(vo);
		logger.info(vo.toString());
		logger.info(" /register URL POST method called. then createMember method executed.");
		return "redirect:/board/list";
	}
	
	@RequestMapping(value= {"/modify"}, method = RequestMethod.GET) 
	public String showBoardModify(@RequestParam("num") int num, Model model) throws Exception{ 
		BoardVO board = boardService.readBoard(num);
		model.addAttribute("board", board);
		logger.info(board.toString());
		return "board/board_modify";
	}
	
	@RequestMapping(value= "/modify", method=RequestMethod.POST)
	public String modifyBoard(@ModelAttribute("board") BoardVO vo) throws Exception{
		boardService.updateBoard(vo);
		logger.info(vo.toString());
		return "redirect:/board/list";
	}
	
	@RequestMapping(value= "/delete", method=RequestMethod.GET)
	public String delete(@RequestParam("num") int num) throws Exception{
		boardService.deleteBoard(num);
		return "redirect:/board/list";
	}
}
