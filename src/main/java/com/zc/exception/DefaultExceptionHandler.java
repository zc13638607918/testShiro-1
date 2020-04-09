package com.zc.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName DefaultExceptionHandler
 * @Description TODO
 * @Author 周超
 * @Date 2020/4/8 22:40
 * @Version 1.0
 **/
@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processUnauthenticatedException(NativeWebRequest request,UnauthorizedException e){
        ModelAndView mv = new ModelAndView("unauthorized");
        //ModelAndView mv = new ModelAndView();
        //mv.setViewName("unauthorized");
        mv.addObject("e",e);
        return mv;
    }
}
