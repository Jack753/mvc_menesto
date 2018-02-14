package it.corso.mvc.model.book;

import org.apache.log4j.net.SyslogAppender;

public class Book {
	private String isbn;
	private String titolo;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
}
