package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.book;

public class BookDAO {
	
	/**
	 * Get all books from database
	 */
	public List<book> getAllBooks() {
		List<book> books = new ArrayList<>();
		try {
			Connection con = DBContext.getConnection();
			String sql = "SELECT * FROM books ORDER BY bookID DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				book b = new book();
				b.setBookID(rs.getInt("bookID"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setPublisher(rs.getString("publisher"));
				b.setPublishYear(rs.getInt("publishYear"));
				b.setQuantity(rs.getInt("quantity"));
				b.setCategoryID(rs.getInt("categoryID"));
				b.setImage(rs.getString("image"));
				books.add(b);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}
	
	/**
	 * Get book by ID
	 */
	public book getBookByID(int bookID) {
		try {
			Connection con = DBContext.getConnection();
			String sql = "SELECT * FROM books WHERE bookID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bookID);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				book b = new book();
				b.setBookID(rs.getInt("bookID"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setPublisher(rs.getString("publisher"));
				b.setPublishYear(rs.getInt("publishYear"));
				b.setQuantity(rs.getInt("quantity"));
				b.setCategoryID(rs.getInt("categoryID"));
				b.setImage(rs.getString("image"));
				rs.close();
				ps.close();
				con.close();
				return b;
			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Get books by category
	 */
	public List<book> getBooksByCategory(int categoryID) {
		List<book> books = new ArrayList<>();
		try {
			Connection con = DBContext.getConnection();
			String sql = "SELECT * FROM books WHERE categoryID = ? ORDER BY bookID DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryID);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				book b = new book();
				b.setBookID(rs.getInt("bookID"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setPublisher(rs.getString("publisher"));
				b.setPublishYear(rs.getInt("publishYear"));
				b.setQuantity(rs.getInt("quantity"));
				b.setCategoryID(rs.getInt("categoryID"));
				b.setImage(rs.getString("image"));
				books.add(b);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}
	
	/**
	 * Add new book
	 */
	public boolean addBook(book b) {
		try {
			Connection con = DBContext.getConnection();
			String sql = "INSERT INTO books (title, author, publisher, publishYear, quantity, categoryID, image, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getPublisher());
			ps.setInt(4, b.getPublishYear());
			ps.setInt(5, b.getQuantity());
			ps.setInt(6, b.getCategoryID());
			ps.setString(7, b.getImage());
			ps.setString(8, "");
			
			int result = ps.executeUpdate();
			ps.close();
			con.close();
			return result > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Update book
	 */
	public boolean updateBook(book b) {
		try {
			Connection con = DBContext.getConnection();
			String sql = "UPDATE books SET title = ?, author = ?, publisher = ?, publishYear = ?, quantity = ?, categoryID = ?, image = ? WHERE bookID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getPublisher());
			ps.setInt(4, b.getPublishYear());
			ps.setInt(5, b.getQuantity());
			ps.setInt(6, b.getCategoryID());
			ps.setString(7, b.getImage());
			ps.setInt(8, b.getBookID());
			
			int result = ps.executeUpdate();
			ps.close();
			con.close();
			return result > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Delete book
	 */
	public boolean deleteBook(int bookID) {
		try {
			Connection con = DBContext.getConnection();
			String sql = "DELETE FROM books WHERE bookID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bookID);
			
			int result = ps.executeUpdate();
			ps.close();
			con.close();
			return result > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Search books by title
	 */
	public List<book> searchBooks(String keyword) {
		List<book> books = new ArrayList<>();
		try {
			Connection con = DBContext.getConnection();
			String sql = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ? ORDER BY bookID DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ps.setString(2, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				book b = new book();
				b.setBookID(rs.getInt("bookID"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setPublisher(rs.getString("publisher"));
				b.setPublishYear(rs.getInt("publishYear"));
				b.setQuantity(rs.getInt("quantity"));
				b.setCategoryID(rs.getInt("categoryID"));
				b.setImage(rs.getString("image"));
				books.add(b);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}
}
