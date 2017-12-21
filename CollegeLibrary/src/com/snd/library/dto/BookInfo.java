package com.snd.library.dto;

public class BookInfo {

	private String bookID;
	private String bookTitle;
	private String author;
	private String publisher;
	
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID2) {
		this.bookID = bookID2;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
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
}
