package com.elibrary.dao;

import com.elibrary.beans.Librarian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibrarianDao {

	public static int save(Librarian bean,Connection con) throws SQLException{
		int status=0;
		PreparedStatement ps=con.prepareStatement("insert into e_librarian(name,email,password,mobile) values(?,?,?,?)");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getPassword());
		ps.setLong(4,bean.getMobile());
		status=ps.executeUpdate();

		return status;
	}
	public static int update(Librarian bean,Connection con) throws SQLException{
		int status=0;
		PreparedStatement ps=con.prepareStatement("update e_librarian set name=?,email=?,mobile=? where id=?");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setLong(3,bean.getMobile());
		ps.setInt(4,bean.getId());
		status=ps.executeUpdate();

		return status;
	}
	public static List<Librarian> view(Connection con) throws SQLException{
		List<Librarian> list=new ArrayList<Librarian>();
		PreparedStatement ps=con.prepareStatement("select * from e_librarian");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Librarian bean=new Librarian();
			bean.setId(rs.getInt("id"));
			bean.setName(rs.getString("name"));
			bean.setEmail(rs.getString("email"));
			bean.setPassword(rs.getString("password"));
			bean.setMobile(rs.getLong("mobile"));
			list.add(bean);
		}

		return list;
	}
	public static Librarian viewById(int id,Connection con) throws SQLException{
		Librarian bean=new Librarian();
		PreparedStatement ps=con.prepareStatement("select * from e_librarian where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setMobile(rs.getLong(5));
		}
		return bean;
	}
	public static int delete(int id,Connection con) throws SQLException{
		int status=0;
		PreparedStatement ps=con.prepareStatement("delete from e_librarian where id=?");
		ps.setInt(1,id);
		status=ps.executeUpdate();
		return status;
	}

	public static boolean authenticate(String email,String password,Connection con) throws SQLException{
		boolean status=false;
		PreparedStatement ps=con.prepareStatement("select * from e_librarian where email=? and password=?");
		ps.setString(1,email);
		ps.setString(2,password);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			status=true;
		}
		return status;
	}
}
