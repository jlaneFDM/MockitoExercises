package com.mavenbookstore.www.BookStore;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
	
	private List<Book> bookList;
	IReadItemCommand ric;
	
	public Catalog(IReadItemCommand mockRIC) {
		bookList = new ArrayList<Book>();;
		this.ric = mockRIC;
		
	}



	public List<Book> getAllBooks(){
		
		bookList = ric.readAll();
				
		return bookList;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	
}
