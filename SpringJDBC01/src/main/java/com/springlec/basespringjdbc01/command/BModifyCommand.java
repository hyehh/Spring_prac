package com.springlec.basespringjdbc01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.basespringjdbc01.dao.BDao;

public class BModifyCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest) map.get("request");
		
		String bName = httpServletRequest.getParameter("bName");
		String bTitle = httpServletRequest.getParameter("bTitle");
		String bContent = httpServletRequest.getParameter("bContent");
		int bId = Integer.parseInt(httpServletRequest.getParameter("bId"));
		
		BDao dao = new BDao();
		dao.modify(bName, bTitle, bContent, bId);
	}

}
