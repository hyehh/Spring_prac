package com.springlec.basespringjdbc01.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.springlec.basespringjdbc01.dao.BDao;
import com.springlec.basespringjdbc01.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		BDao dao = new BDao();
		ArrayList<BDto> list = dao.list();
		model.addAttribute("list", list);
		
	}

}
