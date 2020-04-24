package com.hj.s6.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hj.s6.util.Pager;

@Controller
@RequestMapping("/memo/**")
public class MemoController {
	@Autowired
	private MemoService memoService;
	
	@GetMapping("memoList")
	public void memoList(Pager pager) throws Exception {
		memoService.memoList(pager);
	}
	
	
	@GetMapping("getList")
	public ModelAndView getList(Pager pager, ModelAndView mv) throws Exception{
		List<MemoVO> ar = memoService.memoList(pager);
		mv.addObject("list", ar);
		return mv;
	}
	
	@PostMapping("memoWrite")
	public ModelAndView memoWrite(MemoVO memoVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int res = memoService.memoWrite(memoVO);
		mv.addObject("result", res);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	

}
