package com.nicoarbio.cardealership.branchservice.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ResponseHeaderFilter implements Filter {

    @Value("${spring.application.name}")
    private String SERVICE_NAME;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (response instanceof HttpServletResponse httpResponse) {
            httpResponse.setHeader("X-Service-Name", SERVICE_NAME);
        }
        chain.doFilter(request, response);
    }

}
