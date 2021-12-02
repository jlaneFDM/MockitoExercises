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
		IWriteItemCommand mockWrite = Mockito.mock(IWriteItemCommand.class);
		Catalog cat = new Catalog(mockRIC, mockWrite);
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
		IWriteItemCommand mockWrite = Mockito.mock(IWriteItemCommand.class);
		Catalog cat = new Catalog(mockRIC, mockWrite);
		//Act
		cat.getAllBooks();
		//Assert
		Mockito.verify(mockRIC, Mockito.times(1)).readAll();
				
	}
	
	@Test
	public void getAllBooks_ReturnsListOfBooksItReceivesFromReadAllMethodOfReadItemCommand_WhenCalled(){
		//Arrange
		IReadItemCommand mockRIC = Mockito.mock(IReadItemCommand.class);
		IWriteItemCommand mockWrite = Mockito.mock(IWriteItemCommand.class);
		Catalog cat = new Catalog(mockRIC, mockWrite);
		
		Book mockBook1 = Mockito.mock(Book.class);
		Book mockBook2 = Mockito.mock(Book.class);
		Book mockBook3 = Mockito.mock(Book.class);
		
		List<Book> mockList = new ArrayList<Book>();
		
		mockList.add(mockBook1);
		mockList.add(mockBook2);
		mockList.add(mockBook3);
		
		Mockito.when(mockRIC.readAll()).thenReturn(mockList); //thenReturn sepcifies what to return when mocking
		//" When you call this method, then return this list"
				
		List<Book> returnedBookList = cat.getAllBooks();
		
		assertEquals(mockList, returnedBookList);
			
	}
	
	@Test
	public void test_addBookMethodOfCatalogPassesBookToInsertItemMethodOfWriteItemCommand() {
		//Arrange
		IReadItemCommand mockRIC = Mockito.mock(IReadItemCommand.class);
		IWriteItemCommand mockWrite = Mockito.mock(IWriteItemCommand.class);
		Catalog cat = new Catalog(mockRIC, mockWrite);
		Book mockBook = Mockito.mock(Book.class);
		//Act 
		cat.addBook(mockBook);
		//Verify
		Mockito.verify(mockWrite, Mockito.times(1)).insertItem(mockBook);
	}
	
	@Test
	public void test_insertItemOfWriteItemCommandCalledNTimesWhereNIsNumberOfBooks() {
		//Arrange
		IReadItemCommand mockRIC = Mockito.mock(IReadItemCommand.class);
		IWriteItemCommand mockWrite = Mockito.mock(IWriteItemCommand.class);
		Book b1 = Mockito.mock(Book.class);
		Book b2 = Mockito.mock(Book.class);
		Book b3 = Mockito.mock(Book.class);
		//Act
		List<Book> books = new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		Catalog cat = new Catalog( mockRIC,mockWrite);
		cat.addBooks(books);
		//verify
		Mockito.verify(mockWrite, Mockito.times(1)).insertItem(b1);
		Mockito.verify(mockWrite, Mockito.times(1)).insertItem(b2);
		Mockito.verify(mockWrite, Mockito.times(1)).insertItem(b3);
	
	}
	
	
   @Test
   public void test_getBookReturnsValueFromReadItemCommandGetItemMethod() {
	   //Arrage
	  
	   
	   
	   
	   
	   
   }
}
