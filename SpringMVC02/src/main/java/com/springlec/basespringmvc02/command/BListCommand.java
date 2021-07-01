package com.springlec.basespringmvc02.command;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.basespringmvc02.dao.BDao;
import com.springlec.basespringmvc02.dto.BDto;

public class BListCommand implements BCommand {

	private BDao dao = null;
	
	@Autowired
	public void autoDao(BDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		ArrayList<BDto> list = dao.list();
		model.addAttribute("list", list);
		
	}

}
