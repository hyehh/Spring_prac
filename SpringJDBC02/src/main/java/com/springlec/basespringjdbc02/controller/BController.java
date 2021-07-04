package com.springlec.basespringjdbc02.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.basespringjdbc02.command.BCommand;
import com.springlec.basespringjdbc02.command.BListCommand;
import com.springlec.basespringjdbc02.util.Constant;

@Controller
public class BController {
	
	private JdbcTemplate template;
	BCommand command = null;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	// select
	@RequestMapping("list")
	public String list(Model model) {
		command = new BListCommand();
		command.execute(model);
		return "list";
	}
	
}
