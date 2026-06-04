package dao;

import java.sql.Connection;

public class TestConnection {
	 public static void main(String[] args) {

	        Connection con =
	            DBContext.getConnection();
	        if(con != null) {
	            System.out.println("Ket noi thanh cong");
	        } else {
	            System.out.println(
	                "Ket noi that bai");
	        }
	    }
}
