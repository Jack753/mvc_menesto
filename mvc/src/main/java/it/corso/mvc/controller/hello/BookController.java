package it.corso.mvc.controller.hello;

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
//		Book b = new Book();
//		b.setIsbn("1234");
//		b.setTitle("ciao");
		Book b = book.getBook("12345");
		ModelAndView modelAndView = new ModelAndView("viewBook", "book", b);

		return modelAndView;
	}

}
