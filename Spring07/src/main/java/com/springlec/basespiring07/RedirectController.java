package com.springlec.basespiring07;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

	@RequestMapping("studentConfirm")
	public String confrim(HttpServletRequest httpServletRequest, Model model) {
		
		String id = httpServletRequest.getParameter("id");
		
		if(id.equals("abc")) {
			return "redirect:studentOK";
//			return "student/studentOK";
		}else {
			return "redirect:studentNG";
//			return "student/studentNG";
		}
	}
	
	@RequestMapping("studentOK")
	public String ok(Model model) {
		return "student/studentOK";
	}
	
	@RequestMapping("studentNG")
	public String ng(Model model) {
		return "student/studentNG";
	}
	
}
