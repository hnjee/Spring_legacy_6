package com.hj.s6.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hj.s6.util.Pager;


@Service
public class MemberService {
	@Autowired 
	private MemberDAO memberDAO;
	
	public List<MemberVO> memberList(Pager memberPager) throws Exception{							
		memberPager.makeRow();	
		long totalCount = memberDAO.memberCount(memberPager); 
		memberPager.makePage(totalCount);
		
		System.out.println(totalCount);
		System.out.println(memberPager.getTotalPage());
		System.out.println(memberPager.getTotalBlock());
		return memberDAO.memberList(memberPager);
	}
	
	public MemberVO memberLogin(MemberVO memberVO) throws Exception{
		return memberDAO.memberLogin(memberVO);
	}
	
	public int memberJoin(MemberVO memberVO) throws Exception{
		return memberDAO.memberJoin(memberVO);
	}
	
	public long memberIdCheck(String id) throws Exception{
		return memberDAO.memberIdCheck(id);
	}
}
