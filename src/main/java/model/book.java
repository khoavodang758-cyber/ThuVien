package model;

public class book {
	private int bookID;
	private String title;
	private String author;
	private String publisher;
	private int publishYear;
	private int quantity;
	private int categoryID;
	private String image;
	public book(int bookID, String title, String author, String publisher, int publishYear, int quantity, int categoryID, String image) {
		super();
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publishYear = publishYear;
		this.quantity = quantity;
		this.categoryID = categoryID;
		this.image = image;
	}
	public book() {
		super();
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getImage() {
	    return image;
	}

	public void setImage(String image) {
	    this.image = image;
	}
	@Override
	public String toString() {
		return "book [bookID=" + bookID + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", publishYear=" + publishYear + ", quantity=" + quantity + ", categoryID=" + categoryID + "]";
	}
	
}
