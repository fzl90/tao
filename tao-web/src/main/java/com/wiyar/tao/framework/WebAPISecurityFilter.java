package com.wiyar.tao.framework;


import javax.servlet.*;
import java.io.IOException;

/**
 * Created by fzl on 16/5/13.
 */
public class WebAPISecurityFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
