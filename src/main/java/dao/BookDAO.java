package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.book;

public class BookDAO {
	public void addBook(String title, String author, String publisher, int publishYear, int quantity, int categoryID, String image) {
        String sql =
            "INSERT INTO books " +
            "(Title,Author,Publisher," +
            "PublishYear,Quantity," +
            "CategoryID,Image) " +
            "VALUES(?,?,?,?,?,?,?)";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, publisher);
            ps.setInt(4, publishYear);
            ps.setInt(5, quantity);
            ps.setInt(6, categoryID);
            ps.setString(7, image);
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
	public List<book> getAllBooks() {
	    List<book> list = new ArrayList<>();
	    try {
	        Connection con = DBContext.getConnection();
	        System.out.println("Connection = " + con);
	        String sql = "SELECT * FROM books";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	            System.out.println(
	                "Tim thay sach: "
	                + rs.getString("Title")
	            );
	            book b = new book();
	            b.setBookID(rs.getInt("BookID"));
	            b.setTitle(rs.getString("Title"));
	            b.setAuthor(rs.getString("Author"));
	            b.setPublisher(rs.getString("Publisher"));
	            b.setPublishYear(rs.getInt("PublishYear"));
	            b.setQuantity(rs.getInt("Quantity"));
	            b.setCategoryID(rs.getInt("CategoryID"));
	            b.setImage(rs.getString("Image"));
	            list.add(b);
	        }
	        System.out.println(
	            "Tong so sach lay duoc = "
	            + list.size()
	        );
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	    
	    
	}
}
