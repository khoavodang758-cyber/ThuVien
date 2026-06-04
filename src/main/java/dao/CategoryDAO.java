package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDAO {
	
	/**
	 * Get all categories
	 */
	public List<Map<String, Object>> getAllCategories() {
		List<Map<String, Object>> categories = new ArrayList<>();
		try {
			Connection con = DBContext.getConnection();
			String sql = "SELECT * FROM categories ORDER BY categoryID";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Map<String, Object> cat = new HashMap<>();
				cat.put("categoryID", rs.getInt("categoryID"));
				cat.put("categoryName", rs.getString("categoryName"));
				cat.put("description", rs.getString("description"));
				categories.add(cat);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}
	
	/**
	 * Get category by ID
	 */
	public Map<String, Object> getCategoryByID(int categoryID) {
		try {
			Connection con = DBContext.getConnection();
			String sql = "SELECT * FROM categories WHERE categoryID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryID);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Map<String, Object> cat = new HashMap<>();
				cat.put("categoryID", rs.getInt("categoryID"));
				cat.put("categoryName", rs.getString("categoryName"));
				cat.put("description", rs.getString("description"));
				rs.close();
				ps.close();
				con.close();
				return cat;
			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
