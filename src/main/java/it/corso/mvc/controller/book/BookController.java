//package it.corso.mvc.controller.hello;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import it.corso.mvc.model.book.Book;
//import it.corso.mvc.model.dao.IBookDao;
//
//@Controller
//@RequestMapping("/book")
//public class BookController {
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public ModelAndView getBook() {
//		Book b = new Book();
//		b.setIsbn("12345");
//		b.setTitolo("Spring book");
//		ModelAndView modelAndView = new ModelAndView("bookView", "book", b);
//		return modelAndView;
//	}
//}


package it.corso.mvc.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.corso.mvc.model.book.Book;
import it.corso.mvc.model.dao.IBookDao;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	IBookDao book;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getBook() {
		Book b = book.getBook("12345");
		ModelAndView modelAndView = new ModelAndView("bookView", "book", b);
		return modelAndView;
	}
}
