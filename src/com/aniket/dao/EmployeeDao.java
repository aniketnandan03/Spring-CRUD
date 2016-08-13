package com.aniket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aniket.Util.DatabaseUtil;
import com.aniket.bean.Employee;
import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;

@Repository("empDao")
public class EmployeeDao implements IEmployeeDao {
	@Autowired
	private DatabaseUtil databaseUtil;
	
	public Connection getConnection(){
		return (Connection) this.databaseUtil.getConnection();
	}
	public int CreateNewEmployee(Employee e) throws SQLException{
		Connection con = this.getConnection();
		PreparedStatement pst = null;
		int success = 0;
		
		if(con != null){
			
			String sql = "INSERT INTO EMPLOYEE (userName, email, phone, homeTown, password) VALUES(?, ?, ?, ?, ?)";
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, e.getUserName());
			pst.setString(2, e.getEmail());
			pst.setLong(3, e.getPhone());
			pst.setString(4, e.getHomeTown());
			pst.setString(5, e.getPassword());
			
			success = pst.executeUpdate();
		}	
		this.databaseUtil.closeConnection(null, pst, con);
		return success;
	}
	
	public ArrayList<Employee> fetchEmployees() throws SQLException{
		ArrayList<Employee> empList = new ArrayList<Employee>();
		Connection con = this.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		if(con != null){
			String sql = "SELECT * FROM EMPLOYEE";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			
			while(rs.next()){
				Employee e = new Employee();
				e.setUserId(rs.getInt(1));
				e.setUserName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPhone(rs.getLong(4));
				e.setHomeTown(rs.getString(5));
				e.setPassword(rs.getString(6));
				
				empList.add(e);
			}
		}
		this.databaseUtil.closeConnection(rs, pst, con);
		return empList;
	}
	
	public Employee getEmployee(int id) throws SQLException{
		Employee e = null;
		Connection con = this.getConnection();
		
		if(con != null){
			ResultSet rs = null;
			PreparedStatement pst = null;
			
			String sql = "SELECT * FROM EMPLOYEE WHERE USERID = ?";
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			while(rs.next()){
				e = new Employee();
				e.setUserId(rs.getInt(1));
				e.setUserName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPhone(rs.getLong(4));
				e.setHomeTown(rs.getString(5));
				e.setPassword(rs.getString(6));
			}
			this.databaseUtil.closeConnection(rs, pst, con);
		}
		return e;	
	}
	
	public int updateEmployee(Employee e) throws SQLException{
		int count = 0;
		Connection con = this.getConnection();
		
		if(con != null){
			ResultSet rs = null;
			java.sql.PreparedStatement pst = null;
			
			String sql = "UPDAE EMPLOYEE SET USERNAME = ?, EMAIL = ?, PHONE = ?, HOMETOWN = ? WHERE USERID = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, e.getUserName());
			pst.setString(2, e.getEmail());
			pst.setLong(3, e.getPhone());
			pst.setString(4, e.getHomeTown());
			pst.setLong(5, e.getUserId());
			
			count = pst.executeUpdate();
			this.databaseUtil.closeConnection(rs, pst, con);
		}
		return count;
	}
}
