package com.webTrekk.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


public class DefaultExceptionHandler implements HandlerExceptionResolver,
		Ordered {

	@Override
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse resp, Object arg2, Exception ex) {
		
		if (arg0.getSession(false) != null) {
			arg0.getSession(false).invalidate();
			SecurityContextHolder.clearContext();
		}
	

		resp.setStatus(500);
		return new ModelAndView();
	}

	@Override
	public int getOrder() {
		return 1;
	}

}
