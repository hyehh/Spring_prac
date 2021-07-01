package com.springlec.basespringmvc02.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.basespringmvc02.dao.BDao;
import com.springlec.basespringmvc02.dto.BDto;

public class BContentCommand implements BCommand {

	private BDao dao = null;
	
	@Autowired
	public void autoDao(BDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest) map.get("request");
		
		int bId = Integer.parseInt(httpServletRequest.getParameter("bId"));
		
		BDto dto = dao.content(bId);
		model.addAttribute("content", dto);
	}

}
