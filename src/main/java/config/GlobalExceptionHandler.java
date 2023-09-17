package config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NoHandlerFoundException.class)
  public ModelAndView handleNotFound(NoHandlerFoundException ex) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("redirect:/home");
    return mav;
  }

  @ResponseStatus(HttpStatus.FORBIDDEN)
  @ExceptionHandler(AccessDeniedException.class)
  public ModelAndView handleAccessDenied(AccessDeniedException ex) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("redirect:/home");
    return mav;
  }
}
