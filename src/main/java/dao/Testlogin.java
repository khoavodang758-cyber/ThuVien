package dao;

import model.User;

public class Testlogin {
	public static void main(String[] args) {

        UserDAO dao = new UserDAO();
        User user = dao.login("admin","123456");
        if(user != null) {
            System.out.println(
                    "Dang nhap thanh cong");
            System.out.println(user.getFullName());
            System.out.println(user.getRole());
        } else {
            System.out.println("Sai tai khoan");
        }
    }
}
