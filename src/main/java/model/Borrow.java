package model;

import java.sql.Date;

public class Borrow {
	private int borrowID;
	private int userID;
	private int bookID;
	private Date borrowDate;
	private Date dueDate;
	private String status;
	public Borrow(int borrowID, int userID, int bookID, Date borrowDate, Date dueDate, String status) {
		super();
		this.borrowID = borrowID;
		this.userID = userID;
		this.bookID = bookID;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
		this.status = status;
	}
	public Borrow() {
		super();
	}
	public int getBorrowID() {
		return borrowID;
	}
	public void setBorrowID(int borrowID) {
		this.borrowID = borrowID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Borrow [borrowID=" + borrowID + ", userID=" + userID + ", bookID=" + bookID + ", borrowDate="
				+ borrowDate + ", dueDate=" + dueDate + ", status=" + status + "]";
	}
	
	
}
