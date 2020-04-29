package com.hj.s6;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hj.s6.board.BoardVO;
import com.hj.s6.notice.NoticeService;
import com.hj.s6.util.Pager;

@Controller
@RequestMapping("json")
public class JsonController {
	@Autowired NoticeService noticeService;
	
	@GetMapping("json1")
	@ResponseBody
	public List<BoardVO> json1(Pager pager) throws Exception{
		//ModelAndView mv = new ModelAndView();
		BoardVO boardVO = noticeService.boardSelect(2);
		List<BoardVO> ar = noticeService.boardList(pager);
		
		//mv.addObject("result", "{\"name\":\"hj\"}");
		//mv.addObject("result", json);
		//mv.setViewName("common/ajaxResult");
		return ar;
	}
}
