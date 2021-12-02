package com.mavenbookstore.www.BookStore;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CatalogTest {
	
	@Test
	public void getAllBooks_ReturnsEmptyBookList_IfNoBooksAreInTheCatalogue(){
		//Arrange
		IReadItemCommand mockRIC = Mockito.mock(IReadItemCommand.class);
		Catalog cat = new Catalog(mockRIC);
		//Act
		List<Book> bookList = cat.getAllBooks();
		int zero = 0;
		//Assert
		assertEquals(bookList.size(), zero);
	}
	
	@Test
	public void getAllBooks_CallsReadAllMethodOfReadItemCommand_WhenCalled(){
		//Arrange
		IReadItemCommand mockRIC = Mockito.mock(IReadItemCommand.class);
		Catalog cat = new Catalog(mockRIC);
		//Act
		cat.getAllBooks();
		//Assert
		Mockito.verify(mockRIC, Mockito.times(1)).readAll();
				
	}
	
	@Test
	public void getAllBooks_ReturnsListOfBooksItReceivesFromReadAllMethodOfReadItemCommand_WhenCalled(){
		//Arrange
		IReadItemCommand mockRIC = Mockito.mock(IReadItemCommand.class);
		Catalog cat = new Catalog(mockRIC);
		
		Book mockBook1 = Mockito.mock(Book.class);
		Book mockBook2 = Mockito.mock(Book.class);
		Book mockBook3 = Mockito.mock(Book.class);
		
		List<Book> mockList = new ArrayList<Book>();
		
		mockList.add(mockBook1);
		mockList.add(mockBook2);
		mockList.add(mockBook3);
		
		Mockito.when(mockRIC.readAll()).thenReturn(mockList); //thenReturn sepcifies what to return when mocking
		//"Call this method then return this list"
				
		List<Book> returnedBookList = cat.getAllBooks();
		
		assertEquals(mockList, returnedBookList);
		
		
		
		
		
		
	}



}
