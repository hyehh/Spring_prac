package com.springlec.basespringmvc01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.basespringmvc01.command.BCommand;
import com.springlec.basespringmvc01.command.BContentCommand;
import com.springlec.basespringmvc01.command.BDeleteCommand;
import com.springlec.basespringmvc01.command.BListCommand;
import com.springlec.basespringmvc01.command.BModifyCommand;
import com.springlec.basespringmvc01.command.BWriteCommand;

@Controller
public class BController {

	BCommand command = null;
	
	@RequestMapping("list")
	public String list(Model model) {
		System.out.println("list()");
		
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("write")
	public String write(Model model) {
		return "write";
	}
	
	@RequestMapping("writeAdd")
	public String writeAdd(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("content")
	public String content(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("modify")
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}
