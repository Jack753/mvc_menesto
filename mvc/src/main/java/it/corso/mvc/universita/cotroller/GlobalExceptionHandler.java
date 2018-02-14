package it.corso.mvc.universita.cotroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest request, Exception ex){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception" , ex);
		modelAndView.addObject("url", request.getRequestURL());
		
		modelAndView.setViewName("exception");
		return modelAndView;
		
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView handleExceptionNumber(HttpServletRequest request, Exception ex){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception" , ex);
		modelAndView.addObject("url", request.getRequestURL());
		
		modelAndView.setViewName("exception");
		return modelAndView;
		
	}
	
}
