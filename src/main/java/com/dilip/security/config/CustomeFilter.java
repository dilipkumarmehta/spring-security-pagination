package com.dilip.security.config;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CustomeFilter implements Filter {

	@Override
	public void init(FilterConfig response) {
		System.out.println("Inir :: Called");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httrequest = (HttpServletRequest) request;
		Principal userPrincipal = httrequest.getUserPrincipal();
		System.out.println("userPrinciple::" + userPrincipal);
		// String name = Optional.ofNullable(userPrincipal).get().getName();
		// StringBuffer requestURL =
		// Optional.ofNullable(httrequest).get().getRequestURL();
		chain.doFilter(httrequest, response);

	}

	@Override
	public void destroy() {
		System.out.println("Destroy::called");

	}
}
