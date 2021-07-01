package com.springlec.basespringjdbc02.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import com.springlec.basespringjdbc02.util.Constant;

@Controller
public class BController {
	
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
}
