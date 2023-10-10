package com.dao;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.sql.Connection;


public class DBConnectionManager {

	private static Connection con = null;
	private static Properties proper=null;
	static {
		try {
			proper=new Properties();
			proper.load(new FileInputStream("database.properties"));
			String driver=proper.getProperty("drivername");
			String url=proper.getProperty("url");
			String name=proper.getProperty("name");
			String pass=proper.getProperty("pass");
			Class.forName(driver);
			con=DriverManager.getConnection(url,name,pass);
		}catch(Exception e) {}
	}
	public static Connection getConnection() 
	{
	    
	    // Write code here
	    
 		return con;	
	}
}