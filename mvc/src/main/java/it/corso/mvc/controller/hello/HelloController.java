package it.corso.mvc.controller.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	private String printHello() {
		return "hello";
	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	private String getBook(@PathVariable int id) {
		System.out.println("request book " + id);
		return "view"+ id;
	}

	
}
