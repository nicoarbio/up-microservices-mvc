package com.nicoarbio.cardealership.branchservice.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class ResponseHeaderFilter extends OncePerRequestFilter {

    private final static String X_SERVICE_NAME = "X-Service-Name";
    private final static String X_REQUEST_ID = "X-Request-ID";

    @Value("${spring.application.name}")
    private String SERVICE_NAME;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String requestId = request.getHeader(X_REQUEST_ID);
        if (requestId == null || requestId.isBlank()) {
            requestId = UUID.randomUUID().toString(); // Using Api Gateway, we should not generate a new requestId here, we expect it to be set by the gateway
        }

        response.setHeader(X_SERVICE_NAME, SERVICE_NAME);
        response.setHeader(X_REQUEST_ID, requestId); // This requestId should be also configured in the context/MDC

        chain.doFilter(request, response);
    }

}
