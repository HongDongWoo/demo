package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();

        if(url.contains("test")){
            StringBuffer sb = new StringBuffer();
            sb.append("<html><body>HONGDONGWOO</body></html>");

            response.setContentType("text/html; charset=utf-8");

            response.getWriter().println(sb.toString());

            return;
        }else{
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
    }
}
