package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.example.model.Model;
@Repository
public class Dao {
	@Autowired
	JdbcTemplate temp;
	
	public List<Model> getAll() {
		// TODO Auto-generated method stub
		System.out.println("reached get method");
		List<Model> li= new ArrayList<Model>();
		temp.query("select * from carinfo", new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				li.add(new Model(rs.getInt("id"),rs.getString("name"),rs.getString("category")));
			}
		});
		return li;
		
	}

	
	public int additem(String name,String category) 
	{
		String query = "insert into carinfo(name,category) values(?,?)";
		return temp.update(query,name,category);
		
		
	}
	public int deleteIteam(int id)
	{
		String query="delete from carinfo where id=?";
		return temp.update(query,id);
	}
	public int updateIteam(int id,String name,String category)
	{
		String query="update carinfo set name=?,category=? where id=?";
		return temp.update(query,name,category,id);
	}


}
