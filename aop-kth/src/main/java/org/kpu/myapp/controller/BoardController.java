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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	// 게시판 페이지로 이동
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listBoard(Model model) throws Exception {
		List<BoardVO> boards = boardService.readBoardList();
		model.addAttribute("boards", boards);
//		for(BoardVO vo : boards) {
//			logger.info(vo.toString());
//		}
		return "board/board_list";
	}

	// 상세 정보보기로 이동
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String readBoard(@RequestParam("num") int num, Model model) throws Exception {
		BoardVO board = boardService.readAndHitBoard(num);
		model.addAttribute("board", board);
		return "board/board_read";
	}

	// 글 작성 페이지로 이동
	@RequestMapping(value = { "/write" }, method = RequestMethod.GET)
	public String showBoardWrite() throws Exception {
		return "board/board_write";
	}

	// 글쓰기 완료시 처리
	@RequestMapping(value = { "/write" }, method = RequestMethod.POST)
	public String createMember(@ModelAttribute("board") BoardVO vo) throws Exception {
		boardService.addBoard(vo);
		// logger.info(vo.toString());
		
		return "redirect:/board/list";
	}

	// --------------------수정-----------------------

	// 상세보기에서 글 수정 누르면 권한확인 페이지로 넘기는 처리
	@RequestMapping(value = { "/modify" }, method = RequestMethod.GET)
	public String showBoardModify(@RequestParam("num") int num, Model model) throws Exception {
		BoardVO board = boardService.readBoard(num);
		model.addAttribute("board", board);
		// logger.info(board.toString());
		return "board/board_modify_auth";
	}

	// 권한확인시 처리
	@RequestMapping(value = "/modifyAuth", method = RequestMethod.POST)
	public ModelAndView modifyBoardAuth(@ModelAttribute BoardVO vo) throws Exception {
		
		boolean auth = boardService.writerCheck(vo);
		BoardVO board = boardService.readBoard(vo.getNum());
		ModelAndView mav = new ModelAndView();
		if (auth == true) {
			mav.setViewName("board/board_modify");
			mav.addObject("msg", "success");
			mav.addObject("board", board);
			logger.info(board.toString());
		} else {
			mav.setViewName("/board/pop_up");
			mav.addObject("msg", "failure");
		}
		return mav;
	}

	// 글 수정완료 버튼 누르면 업데이트하고 게시판목록으로 넘기는 처리 
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String boardModify(@ModelAttribute("board") BoardVO vo) throws Exception {
		boardService.updateBoard(vo);
		logger.info(vo.toString());
		return "redirect:/board/list";
	}

	// -------------------------삭제-----------------------

	// 상세보기에서 글 수정 누르면 권한확인 페이지로 넘기는 처리
	@RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
	public String showBoardDelete(@RequestParam("num") int num, Model model) throws Exception {
		BoardVO board = boardService.readBoard(num);
		model.addAttribute("board", board);
		// logger.info(board.toString());
		return "board/board_delete_auth";
	}
	
	// 권한확인시 처리
	@RequestMapping(value = "/deleteAuth", method = RequestMethod.POST)
	public ModelAndView deleteBoardAuth(@ModelAttribute BoardVO vo) throws Exception {
		boolean auth = boardService.writerCheck(vo);
		BoardVO board = boardService.readBoard(vo.getNum());
		ModelAndView mav = new ModelAndView();
		if (auth == true) {
			mav.setViewName("redirect:/board/list");
			mav.addObject("msg", "success");
			mav.addObject("board", board);
			boardService.deleteBoard(board.getNum());
		} else {
			mav.setViewName("/board/pop_up");
			mav.addObject("msg", "failure");
		}
		return mav;
	}
}
