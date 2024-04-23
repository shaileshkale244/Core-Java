package com.que1;

public class Book {
	
	private int bookid;
	private String title;
	private String author;
	private Boolean isAvailable;
	private static int count=0;
	
	
	public Book(int bookid,String title,String author,Boolean isAvailable) {
		this.bookid=bookid;
		this.title=title;
		this.author=author;
		this.isAvailable=isAvailable;
		count++;
	}
	
	public static int getBookCount() {
		return count;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
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

	public Boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + ", author=" + author + ", isAvailable=" + isAvailable
				+ "]";
	}
	
	public void displayInfo() {
		System.out.println(this.toString());
	}
	
	
	
}
