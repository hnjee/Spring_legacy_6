package com.hj.s6.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hj.s6.board.BoardVO;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() throws Exception{
		return "notice";
	}
	
	@RequestMapping(value="noticeList", method=RequestMethod.GET)
	public ModelAndView boardList(@RequestParam(defaultValue="1") int curPage, ModelAndView mv) throws Exception{
		System.out.println(curPage);
		
		List<BoardVO> ar = noticeService.boardList(curPage);
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@RequestMapping(value="noticeSelect", method=RequestMethod.GET)
	public ModelAndView boardSelect(long num) throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardVO boardVO = noticeService.boardSelect(num);
		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public String boardWrite()throws Exception{
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(NoticeVO noticeVO, ModelAndView mv)throws Exception{
		int res = noticeService.boardWrite(noticeVO);
		if(res>0) {
			mv.setViewName("redirect:./noticeList");
		} else {
			mv.addObject("result", "Write Fail");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public String boardUpdate(long num, Model model) throws Exception{
		BoardVO boardVO = noticeService.boardSelect(num);
		model.addAttribute("vo", boardVO);
		return "board/boardUpdate";
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String boardUpdate(NoticeVO noticeVO) throws Exception{
		System.out.println("수정페이지");
		int res = noticeService.boardUpdate(noticeVO);
		System.out.println(res);
		String path="";
		if(res>0) {
			path="redirect:./noticeList";
		} else {
			path ="redirect:./noticeSelect?num="+noticeVO.getNum();
		}
		return path;
	}
	
	@RequestMapping(value = "noticeDelete", method=RequestMethod.GET)
	public String boardDelete(long num) throws Exception{
		int res = noticeService.boardDelete(num);
		String path="";
		if(res>0) {
			path="redirect:./noticeList";
		}else {
			path="redirect:./noticeList?num="+num;
		}
		return path;
	}
}
