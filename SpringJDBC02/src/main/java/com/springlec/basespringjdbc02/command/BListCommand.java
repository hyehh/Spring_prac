package com.springlec.basespringjdbc02.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.springlec.basespringjdbc02.dao.BDao;
import com.springlec.basespringjdbc02.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		BDao dao = new BDao();
		ArrayList<BDto> dto = dao.list();
		model.addAttribute("list", dto);
		
	}

}
