package com.springboot.day05.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter2 implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest rsq = (HttpServletRequest) servletRequest;
    System.out.println("MyFilter2,url: " + rsq.getRequestURI());
    filterChain.doFilter(rsq,servletResponse);
  }

  @Override
  public void destroy() {

  }
}
