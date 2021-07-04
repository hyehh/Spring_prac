package com.springlec.basespringmybatis02.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.basespringmybatis02.dao.BDao;

public class BListCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		BDao dao = sqlSession.getMapper(BDao.class);
		model.addAttribute("list", dao.listDao());
	}

}
