package com.springlec.basespringmvc01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.basespringmvc01.dao.BDao;

public class BWriteCommand implements BCommand {

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
		
		BDao dao = new BDao();
		dao.write(bName, bTitle, bContent);

	}

}
