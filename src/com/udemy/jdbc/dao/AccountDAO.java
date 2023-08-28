package com.udemy.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {

	public static void main(String[] args) {
       
		//DriverManager.getConnection("url", username, password)  This will give exception, thrown in main method 
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useSSL=false","root","root");
			//?//characterEncoding=latin1\\
					System.out.println(connection);
					Statement statement = connection.createStatement();
					//int result=statement.executeUpdate("insert into account values(1,'Kulkarni','Rutuja',100000)");
					//taking int is our choice
					//System.out.println(result + " rows are updated");
					//statement.executeUpdate("update account set bal=500000 where accno=1");
					//statement.executeUpdate("delete	from account where accno=1");
					ResultSet rs = statement.executeQuery("select * from account");
					//when there are more data use while
					while(rs.next()){
						System.out.print(" "+rs.getString(1));  //put 2 to get surname
						
						System.out.print(" "+rs.getString(3));
					
						System.out.print(" "+rs.getString(4));
						
					}
					}
		catch (SQLException e)
		{
			e.printStackTrace();
	}
	     //JAVA 7
		//try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useSSL=false","root","root");
		//Statement statement = connection.createStatement(); }
	}
}
