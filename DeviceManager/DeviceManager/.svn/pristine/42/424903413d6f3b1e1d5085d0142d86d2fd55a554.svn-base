package com.soft.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Filter:当前的Filter可以处理乱码的问题
 * 
 * @author Administrator
 * 
 */
public class CharacterEncondingFilter implements Filter {
	private FilterConfig config;
	private String encoding = "utf-8";

	@Override
	public void destroy() {
		config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		//如何还有下一个Filter，那么就交给下一个Filter来处理，如果没有Filter，就调用Servlet
		chain.doFilter(request, response);

	}
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		//获取初始化参数(web.xml)
		encoding = config.getInitParameter("encoding");
		//encoding = config.getServletContext().getInitParameter("encoding");
	}

}
