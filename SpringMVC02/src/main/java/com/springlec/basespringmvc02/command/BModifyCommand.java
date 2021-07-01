package com.springlec.basespringmvc02.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.basespringmvc02.dao.BDao;

public class BModifyCommand implements BCommand {

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
		
		String bName = httpServletRequest.getParameter("bName");
		String bTitle = httpServletRequest.getParameter("bTitle");
		String bContent = httpServletRequest.getParameter("bContent");
		int bId = Integer.parseInt(httpServletRequest.getParameter("bId"));
		
		dao.modify(bName, bTitle, bContent, bId);
	}

}
