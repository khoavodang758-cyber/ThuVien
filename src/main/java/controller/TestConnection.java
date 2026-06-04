package controller;

import java.sql.Connection;

import dao.DBContext;

public class TestConnection {
	   public static void main(String[] args) {

	        Connection con =
	            DBContext.getConnection();

	        System.out.println(con);
	    }
}
