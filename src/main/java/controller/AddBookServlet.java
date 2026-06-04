package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBooks")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
	        HttpServletResponse response)
	        throws ServletException, IOException {
	    String title = request.getParameter("title");
	    String author = request.getParameter("author");
	    String publisher = request.getParameter("publisher");
	    int publishYear = Integer.parseInt( request.getParameter("publishYear"));
	    int quantity = Integer.parseInt( request.getParameter("quantity"));
	    int categoryID = Integer.parseInt(request.getParameter("categoryID"));
	    String image = request.getParameter("image");
	    BookDAO dao = new BookDAO();
	    dao.addBook(
	            title,
	            author,
	            publisher,
	            publishYear,
	            quantity,
	            categoryID,
	            image);
	    response.sendRedirect("books");
	}

}
