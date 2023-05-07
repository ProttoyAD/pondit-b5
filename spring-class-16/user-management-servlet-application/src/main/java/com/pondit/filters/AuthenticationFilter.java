package com.pondit.filters;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = "/user/*")
public class AuthenticationFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        var httpResp = (HttpServletResponse) response;
        var session = httpReq.getSession();
        var itr = session.getAttributeNames().asIterator();
        while (itr.hasNext()) {
            var sessionObj = itr.next();
            if ("loggedInUser".equals(sessionObj) && null != session.getAttribute(sessionObj)) {
                chain.doFilter(request, response);
            } else {
                httpResp.sendError(HttpServletResponse.SC_FORBIDDEN);
            }
        }
    }
}
