package com.mavenbookstore.www.BookStore;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

	private List<Book> bookList;
	IReadItemCommand ric;
	IWriteItemCommand wic;

	public Catalog(IReadItemCommand mockRIC, IWriteItemCommand mockWrite) {
		bookList = new ArrayList<Book>();
		this.ric = mockRIC;
		this.wic = mockWrite;

	}

	// getter
	public List<Book> getBookList() {
		return bookList;
	}

	// setter
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	// methods
	public List<Book> getAllBooks() {

		bookList = ric.readAll();

		return bookList;
	}

	public void addBook(Book book) {
		wic.insertItem(book);

	}

}
