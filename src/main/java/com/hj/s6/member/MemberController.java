package com.hj.s6.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.hj.s6.util.Pager;



@Controller
@RequestMapping("/member/**")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="memberList", method=RequestMethod.GET)
	public ModelAndView boardList(Pager memberPager, ModelAndView mv) throws Exception{
		List<MemberVO> ar = memberService.memberList(memberPager);
		mv.addObject("list", ar);
		mv.addObject("pager", memberPager);
		mv.setViewName("member/memberList");
		return mv;
	}
}
