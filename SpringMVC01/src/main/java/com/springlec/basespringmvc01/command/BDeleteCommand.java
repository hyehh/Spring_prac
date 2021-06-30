package com.springlec.basespringmvc01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.basespringmvc01.dao.BDao;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest) map.get("request");
		
		int bId = Integer.parseInt(httpServletRequest.getParameter("bId"));
		
		BDao dao = new BDao();
		dao.delete(bId);
	}

}
