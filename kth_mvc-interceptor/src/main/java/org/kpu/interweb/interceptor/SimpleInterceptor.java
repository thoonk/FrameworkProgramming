package org.kpu.interweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SimpleInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle (HttpServletRequest request, HttpServletResponse reponse, 
			Object handler) throws Exception{
		System.out.println("preHandle executed");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception{
		System.out.println("postHandle executed");
	}
	
	@Override
	public void afterCompletion (HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) throws Exception{
		System.out.println("afterCompletion executed. ");
	}
}
