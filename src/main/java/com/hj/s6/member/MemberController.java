package com.hj.s6.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ModelAndView memberList(Pager memberPager, ModelAndView mv) throws Exception{
		List<MemberVO> ar = memberService.memberList(memberPager);
		mv.addObject("list", ar);
		mv.addObject("pager", memberPager);
		mv.setViewName("member/memberList");
		return mv;
	}
	
	@GetMapping("memberLogin")
	public void memberLogin () {
	}
	
	@PostMapping("memberLogin")
	public ModelAndView memberLogin (MemberVO memberVO, ModelAndView mv, HttpSession session) throws Exception{
		memberVO = memberService.memberLogin(memberVO);
		if(memberVO!=null) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		} else {
			mv.addObject("result", "Login Fail");
			mv.addObject("path", "./memberLogin");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	@GetMapping("memberJoin")
	public void memberJoin() throws Exception{
	}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(ModelAndView mv, MemberVO memberVO) throws Exception{
		int res = memberService.memberJoin(memberVO);
		String msg = "Member Join Fail";
		if(res>0) {
			msg="Member Join Success";
		} 
		mv.addObject("result", msg);
		mv.addObject("path", "../");	//index
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@RequestMapping(value= "memberPage")
	public void memberPage() {
	}
	
	@RequestMapping(value= "memberUpdate")
	public void memberUpdate() {
	}
	
	
	
}
