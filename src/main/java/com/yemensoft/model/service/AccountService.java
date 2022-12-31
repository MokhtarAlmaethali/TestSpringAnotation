package com.yemensoft.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yemensoft.model.mapper.AccountDAO;

@Service
public class AccountService {
	
	public static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	
	
	@Autowired
	private AccountDAO accountDAO;
	/**
	 * in order to control db transaction, sqls should be executed on the same connection
	 * solution: operation inside transfer money use the same connection
	 * 
	 * 		1. class called ThreadLocal(only one value inside), value inside this class can be 
	 * 			shared by all functions run in one thread
	 */
	public void transferMoney(){
		
		Connection conn=null;
		try{
			try{
			
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?useUnicode=true&characterEncoding=utf8", "root", "root");
			// dont commit until finished all the methods
			conn.setAutoCommit(false);
			//put the connection into localthread
			tl.set(conn);
			//1. deduct money from A
			accountDAO.updateBalance(1, -500);
			//to made an error
			Integer.parseInt("s");
			//2. add money to B
			accountDAO.updateBalance(2,500);
			conn.commit();
			}
			catch(Exception e)
			{
			//rollback
					conn.rollback();
					e.printStackTrace();
			}
			finally
			{
				//close the connection
					conn.close();
			}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}

}
