package com.hj.s6.member;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
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
	public ModelAndView boardList(Pager memberPager, ModelAndView mv) throws Exception{
		List<MemberVO> ar = memberService.memberList(memberPager);
		mv.addObject("list", ar);
		mv.addObject("pager", memberPager);
		mv.setViewName("member/memberList");
		return mv;
	}
	
	@GetMapping("memberLogin")
	public ModelAndView memberLogin(@CookieValue(value="cId", required=false)String cId, ModelAndView mv) throws Exception{
		mv.addObject("cId", cId);
		mv.setViewName("member/memberLogin");
		return mv;
	}
	
	@PostMapping("memberLogin")
	public ModelAndView memberLogin(MemberVO memberVO, String remember, ModelAndView mv, HttpSession session, HttpServletResponse response) throws Exception {
		//쿠키 생성  
		Cookie cookie = new Cookie("cId", memberVO.getId());
		
		//remember 체크되어있는 경우 쿠키에 해당 아이디 등록  
		if(remember != null) {
			cookie.setValue(memberVO.getId());
		}
		//response(응답)에 쿠키 추가하기 
		response.addCookie(cookie);
		
		memberVO = memberService.memberLogin(memberVO);
		//로그인 성공
		if(memberVO!=null) {	
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		} 
		//로그인 실패 
		else {
			mv.addObject("result", "Login Fail");
			mv.addObject("path", "./memberLogin");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	@GetMapping("memberLogout")
	public ModelAndView memberLogout(HttpSession session, ModelAndView mv) {
		session.invalidate(); //세션 끊기
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@GetMapping("memberPage")
	public ModelAndView memberPage(ModelAndView mv) {
		mv.setViewName("member/memberPage");
		return mv;
	}
	
	@GetMapping("memberJoin")
	public ModelAndView memberJoin(ModelAndView mv) {
		mv.setViewName("member/memberJoin");
		return mv;
	}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO, ModelAndView mv) throws Exception {
		int res = memberService.memberJoin(memberVO);
		String msg = "Join Success"; 
		if(res<0) {
			msg="Join Fail";
		} 
		mv.addObject("result",msg);
		mv.addObject("path", "../");
		mv.setViewName("common/result");
	
		return mv;
	}
	@PostMapping("memberIdCheck")
	public ModelAndView memberIdCheck(String id, ModelAndView mv) throws Exception {
		long res = memberService.memberIdCheck(id);
		mv.addObject("result", res);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
}
