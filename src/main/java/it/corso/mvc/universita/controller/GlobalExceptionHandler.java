package it.corso.mvc.universita.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest request, Exception exception) {
		logger.error("Generic Exception Occured : URL=" + request.getRequestURL());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", exception);
		modelAndView.addObject("url", request.getRequestURL());
		modelAndView.setViewName("exception");
		return modelAndView;
	}
}
