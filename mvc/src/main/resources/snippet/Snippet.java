package snippet;

public class Snippet {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest request, Exception ex){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception" + ex);
		modelAndView.addObject("url", request.getRequestURL());
		
		modelAndView.setViewName("exception");
		return modelAndView;
		
	}
	
}

