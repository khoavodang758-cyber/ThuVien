package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("userID") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		int userID = (Integer) session.getAttribute("userID");
		CartDAO cartDAO = new CartDAO();
		
		request.setAttribute("cartItems", cartDAO.getCartItems(userID));
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("userID") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		int userID = (Integer) session.getAttribute("userID");
		String action = request.getParameter("action");
		CartDAO cartDAO = new CartDAO();
		
		if ("add".equals(action)) {
			int bookID = Integer.parseInt(request.getParameter("bookID"));
			cartDAO.addToCart(userID, bookID);
		} else if ("remove".equals(action)) {
			int bookID = Integer.parseInt(request.getParameter("bookID"));
			cartDAO.removeFromCart(userID, bookID);
		} else if ("clear".equals(action)) {
			cartDAO.clearCart(userID);
		}
		
		response.sendRedirect(request.getContextPath() + "/cart");
	}
}
