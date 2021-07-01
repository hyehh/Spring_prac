package com.springlec.basespringjdbc02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.springlec.basespringjdbc02.dto.BDto;
import com.springlec.basespringjdbc02.util.Constant;

public class BDao {
	
	JdbcTemplate template;
	
	public BDao() {
		// TODO Auto-generated constructor stub
		this.template = Constant.template;
	}
	
	public ArrayList<BDto> select() {
		String query = "select * from board";
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void write(final String bName, final String bTitle) {
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query = "insert into board (bName, bTitle, bDate) values (?,?,now())";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				return ps;
			}
		});
	}
	
	public void delete(final int bId) {
		String query = "delete from board where bId = ?";
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, bId);
			}
		});
	}
}
