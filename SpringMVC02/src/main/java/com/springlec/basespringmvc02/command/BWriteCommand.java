package com.springlec.basespringmvc02.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.basespringmvc02.dao.BDao;

public class BWriteCommand implements BCommand {

	private BDao dao = null;
	
	@Autowired
	public void autoDao(BDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		// 이렇게 해야 데이터 값을 받아 올 수 있음
		// key값, value값 - 데이터 값 (숫자, 문자 여러가지 올 수 있어서 object 타입 선언)
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest =  (HttpServletRequest) map.get("request");
		
		String bName = httpServletRequest.getParameter("bName");
		String bTitle = httpServletRequest.getParameter("bTitle");
		String bContent = httpServletRequest.getParameter("bContent");
		
		dao.write(bName, bTitle, bContent);

	}

}
