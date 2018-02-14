package it.corso.mvc.model.dao;

import org.springframework.stereotype.Repository;

import it.corso.mvc.model.book.Book;

@Repository
public class BookDao implements IBookDao {

	
	@Override
	public Book getBook(String isbn) {
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitolo("Roma");
		return book;
	}
	
	
}
