package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class UserDAO {
	public User login(String username, String password) {
        String sql =
                "SELECT * FROM Users " +
                "WHERE Username=? AND Password=?";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                User u = new User();
                u.setUserID(
                        rs.getInt("UserID"));
                u.setUsername(
                        rs.getString("Username"));
                u.setPassword(
                        rs.getString("Password"));
                u.setFullName(
                        rs.getString("FullName"));
                u.setRole(
                        rs.getString("Role"));
                return u;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
