package com.yemensoft.model.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.yemensoft.model.service.AccountService;

@Repository
public class AccountDAO {
	
	public void updateBalance(int aid, int money){
		Connection conn=null;
		PreparedStatement statement=null;
		
		try {
			// get the connection from threadLocal
			conn=AccountService.tl.get();	
			statement= conn.prepareStatement("update account set balance=balance + "+money+" where aid=? ");
			statement.setInt(1, aid);
			//execute sql
			//JDBC, by default it's auto commit
			statement.executeUpdate();
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				statement.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
