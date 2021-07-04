package com.springlec.basespringmybatis02.dao;

import java.util.ArrayList;

import com.springlec.basespringmybatis02.dto.BDto;

public interface BDao {

	public ArrayList<BDto> listDao();
	
	public BDto viewDao(int seqno);
	
	public void writeDao(String name, String telno, String address, String email, String relation);
	
	public void deleteDao(int seqno);

	public void updateDao(String name, String telno, String address, String email, String relation, int seqno);
	
	public ArrayList<BDto> listQuery(String query, String content);
	
}
