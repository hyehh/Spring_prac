package com.springlec.basespringmvc02.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.basespringmvc02.command.BCommand;
import com.springlec.basespringmvc02.command.BContentCommand;
import com.springlec.basespringmvc02.command.BDeleteCommand;
import com.springlec.basespringmvc02.command.BListCommand;
import com.springlec.basespringmvc02.command.BModifyCommand;
import com.springlec.basespringmvc02.command.BWriteCommand;

@Controller
public class BController {

	private BCommand listCommand = null;
	private BCommand writeCommand = null;
	private BCommand contentCommand = null;
	private BCommand modifyCommand = null;
	private BCommand deleteCommand = null;
	
	@Autowired
	public void autoCommand(BCommand list, BCommand write, BCommand content, BCommand modify, BCommand delete) {
		this.listCommand = list;
		this.writeCommand = write;
		this.contentCommand = content;
		this.modifyCommand = modify;
		this.deleteCommand = delete;
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		System.out.println("list()");
		
		listCommand.execute(model);
		
		return "list";
	}
	
	@RequestMapping("write")
	public String write() {
		return "write";
	}
	
	@RequestMapping("writeAdd")
	public String writeAdd(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		writeCommand.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("content")
	public String content(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		contentCommand.execute(model);
		
		return "content";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		deleteCommand.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("modify")
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		modifyCommand.execute(model);
		
		return "redirect:list";
	}
}
