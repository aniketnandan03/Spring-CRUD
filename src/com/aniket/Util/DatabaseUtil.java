package com.aniket.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;
import java.sql.PreparedStatement;

@Component("databaseUtil")
public class DatabaseUtil {
	public Connection getConnection(){
		Connection con = null;
		try {
			con = this.createConnection();
		} catch (SQLException e){
			System.out.println("SQL Exception");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("class not found");
			e.printStackTrace();
		}
		
		return con;
	}
	public Connection createConnection() throws SQLException, ClassNotFoundException{
    	Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/sample";
        String user = "aniketnandan";
        String password = "5tYPUcaRyrYd6P8d"; //"4VT5WECnLLfCz8ZG" home

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, user, password);
 
        return con;
    }
	
    public void closeConnection(ResultSet rs, PreparedStatement pst, Connection con){
    	try {
	    	if (rs != null) {
				rs.close();
	        }
	    	if (pst != null) {
	    		pst.close();
	    	}
	    	if (con != null) {
	    		con.close();
	    	}
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
    /*public static void main(String[] args) {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/sample";
        String user = "aniketnandan";
        String password = "5tYPUcaRyrYd6P8d";

        try {
        	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * from user");

            if (rs.next()) {
                
                System.out.println(rs.getString(3));
            }

        } catch (SQLException ex) {
        	System.out.println("catch v1");
        	ex.printStackTrace();
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } catch (ClassNotFoundException e) {
			System.out.println("class not found");
			e.printStackTrace();
		}
    }*/
    
}