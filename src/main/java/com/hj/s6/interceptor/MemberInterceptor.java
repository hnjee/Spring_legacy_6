package com.hj.s6.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hj.s6.member.MemberVO;

@Component
public class MemberInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {	
		boolean check = false;
		MemberVO memberVO = (MemberVO) request.getSession().getAttribute("member");
		
		if(memberVO!=null) {
			check = true;
			System.out.println("로그인 OK");
		} else {
			System.out.println("로그인 X");
			response.sendRedirect("../member/memberLogin");
		}
		return check;
	}
}
