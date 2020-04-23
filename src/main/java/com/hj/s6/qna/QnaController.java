package com.hj.s6.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hj.s6.board.BoardVO;
import com.hj.s6.util.Pager;

@Controller
@RequestMapping("/qna/**") 
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() throws Exception{
		return "qna";
	}
	
	//@RequestMapping(value="", method=RequestMethod.GET)
	@GetMapping("qnaList")
	public ModelAndView qnaList(Pager pager, ModelAndView mv) throws Exception{
		List<BoardVO> ar = qnaService.boardList(pager);
		mv.setViewName("board/boardList");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		return mv;
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView boardWrite(ModelAndView mv) throws Exception{
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView boardWrite(QnaVO qnaVO, ModelAndView mv) throws Exception{
		int result = qnaService.boardWrite(qnaVO);
		String msg = "QNA 글쓰기 Fail";
		
		if(result>0) {
			msg="QNA 글쓰기 Success";
		} 
		mv.addObject("result", msg);
		mv.addObject("path", "qnaList");
		mv.setViewName("common/result");	
		return mv;
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView boardSelect(long num, ModelAndView mv) throws Exception{
		BoardVO boardVO = qnaService.boardSelect(num);
		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@GetMapping("qnaReply")
	public ModelAndView qnaReply(long num, ModelAndView mv) throws Exception{
		mv.addObject("num",num);//부모의 글번호 
		mv.setViewName("board/boardReply");
		return mv;
	}
	
	@PostMapping("qnaReply")
	public ModelAndView qnaReply(ModelAndView mv, QnaVO qnaVO) throws Exception{
		int res = qnaService.boardReply(qnaVO);
		if(res>0) {
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("result", "Replay Write Fail");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	@GetMapping("qnaUpdate")
	public ModelAndView qnaUpdate(long num, ModelAndView mv) throws Exception{
		mv.addObject("num", num); //수정하는 글의 번호
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@PostMapping("qnaUpdate")
	public ModelAndView qnaUpdate(QnaVO qnaVO, ModelAndView mv) throws Exception{
		int res = qnaService.boardUpdate(qnaVO);
		if(res>0) {
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("result", "Qna Update Fail");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	@GetMapping("qnaDelete")
	public ModelAndView qnaDelete(long num, ModelAndView mv) throws Exception{
		int res = qnaService.boardDelete(num);
		String msg = "Qna 삭제 Fail";
		
		if(res>0) {
			msg="Qna 삭제 Success";
		} 
		mv.addObject("result", msg);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");	
		return mv;
	}
}
