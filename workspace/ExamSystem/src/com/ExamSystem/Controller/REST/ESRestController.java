package com.ExamSystem.Controller.REST;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExamSystem.BO.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@RestController
public class ESRestController {
	
	@Autowired
	public DriverManagerDataSource ds; 
	
	@RequestMapping("/welcome")
	public User welcome(String name){
		System.out.println("Entered the REST controller");
		User user = new User();
		try {
			Connection con = ds.getConnection() ;
			PreparedStatement	 ps =con.prepareStatement("Select * from usertbl where userid=1");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user.setUserId(rs.getLong(1));
				user.setUserName(rs.getString(2));
				user.setName(rs.getString(3));
				user.setPassword(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
