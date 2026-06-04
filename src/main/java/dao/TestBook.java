package dao;

import java.util.List;

import model.book;

public class TestBook {
	public static void main(String[] args) {

        BookDAO dao =
                new BookDAO();

        List<book> list =
                dao.getAllBooks();

        for(book b : list) {

            System.out.println(
                    b.getTitle());
        }
    }
}
