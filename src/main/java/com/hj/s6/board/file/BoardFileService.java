package com.hj.s6.board.file;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hj.s6.util.FileSaver;

@Service
public class BoardFileService {
	@Autowired
	private BoardFileDAO boardFileDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileSaver fileSaver;
	
	public int fileDelete(String fileName) throws Exception{
		String path = servletContext.getRealPath("/resources/summer");
		return fileSaver.deleteFile(fileName, path);
	}
	
	public String fileInsert(MultipartFile files) throws Exception{
		String path = servletContext.getRealPath("/resources/summer");
		System.out.println(path);
		
		path = fileSaver.saveByTransfer(files, path);
		path = servletContext.getContextPath()+"/resources/summer/"+path;
		return path;
	}
	
	public BoardFileVO fileSelect(BoardFileVO boardFileVO)throws Exception{
		return boardFileDAO.fileSelect(boardFileVO);
	}
	
}