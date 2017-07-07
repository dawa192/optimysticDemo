package com.optimystic.login;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.PreparedStatement;

@Service
public class LoginService {
	public Boolean loginValidation(String username, String password ){
		String url="jdbc:mysql://localhost:3306/spring";
		String u="root";
		String p="";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,u,p);
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from login where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
		//return username.equals("dawa") && password.equals("lama");
	}

}
