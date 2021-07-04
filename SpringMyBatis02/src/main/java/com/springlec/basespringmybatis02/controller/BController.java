package com.springlec.basespringmybatis02.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.basespringmybatis02.command.BCommand;
import com.springlec.basespringmybatis02.command.BListCommand;
import com.springlec.basespringmybatis02.dao.BDao;

@Controller
public class BController {

	BCommand command = null;
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/list")
	public String list(Model model) {
//		BDao dao = sqlSession.getMapper(BDao.class);
//		model.addAttribute("list", dao.listDao());
		
		command = new BListCommand();
		command.execute(sqlSession, model);
		return "addressbook/list";
	}
	
	@RequestMapping("/write")
	public String write() {
		return "addressbook/write";
	}
	
	@RequestMapping("writeAdd")
	public String writeAdd(HttpServletRequest request, Model model) {
		BDao dao = sqlSession.getMapper(BDao.class);
		dao.writeDao(request.getParameter("name"), request.getParameter("telno"), request.getParameter("address"), request.getParameter("email"), request.getParameter("relation"));
		return "redirect:list";
	}
	
	@RequestMapping("view")
	public String view(HttpServletRequest request, Model model) {
		BDao dao = sqlSession.getMapper(BDao.class);
		model.addAttribute("view", dao.viewDao(Integer.parseInt(request.getParameter("seqno"))));
		return "addressbook/view";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		BDao dao = sqlSession.getMapper(BDao.class);
		dao.deleteDao(Integer.parseInt(request.getParameter("seqno")));
		return "redirect:list";
	}
	
	@RequestMapping("modify")
	public String modify(HttpServletRequest request, Model model) {
		BDao dao = sqlSession.getMapper(BDao.class);
		dao.updateDao(request.getParameter("name"), request.getParameter("telno"), request.getParameter("address"), 
				request.getParameter("email"), request.getParameter("relation"), Integer.parseInt(request.getParameter("seqno")));
		model.addAttribute("view", dao.viewDao(Integer.parseInt(request.getParameter("seqno"))));
		return "addressbook/view";
	}
	
	
}
