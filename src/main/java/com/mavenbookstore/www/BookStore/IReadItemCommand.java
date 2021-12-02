package com.mavenbookstore.www.BookStore;

import java.util.List;

public interface IReadItemCommand {
	List<Book> readAll(); 
	Book getItem(String id);

}
