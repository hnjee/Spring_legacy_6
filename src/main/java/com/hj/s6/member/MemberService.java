package com.hj.s6.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hj.s6.member.memberFile.MemberFileDAO;
import com.hj.s6.member.memberFile.MemberFileVO;
import com.hj.s6.util.FileSaver;
import com.hj.s6.util.Pager;


@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private MemberFileDAO memberFileDAO;
	
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
	
	public int memberDelete(String id) throws Exception{
		return memberDAO.memberDelete(id);
	}
	
	public int membersDelete(List<String> list) throws Exception{
		return memberDAO.membersDelete(list);
	}
	
	public int memberUpdate(MemberVO memberVO) throws Exception{
		return memberDAO.memberUpdate(memberVO);
	}
	
	public int memberJoin(MemberVO memberVO, MultipartFile avatar, HttpSession session)throws Exception{
		//HDD에 저장 resources/memberUpload/
		//1. 파일을 HDD 에 저장
		
		String path = session.getServletContext().getRealPath("/resources/memberUpload");
		System.out.println(path);
		String fileName = fileSaver.saveByUtils(avatar, path);
		
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId(memberVO.getId());
		memberFileVO.setFileName(fileName);
		memberFileVO.setOriName(avatar.getOriginalFilename());
		//2. 파일명을 DB에 저장
		
		 int result = memberDAO.memberJoin(memberVO);
		 result = memberFileDAO.fileInsert(memberFileVO);
		return result;//memberDAO.memberJoin(memberVO);
	}

	public int fileDelete(String id, HttpSession session)throws Exception{
		MemberFileVO memberFileVO = memberFileDAO.fileSelect(id);
		int result = memberFileDAO.fileDelete(id);
		if(result>0) {
			String path = session.getServletContext().getRealPath("/resources/memberUpload");
			result = fileSaver.deleteFile(memberFileVO.getFileName(), path);
		}
		return result;
	}
	
}
