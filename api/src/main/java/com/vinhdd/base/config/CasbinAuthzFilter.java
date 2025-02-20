package com.vinhdd.base.config;

import com.vinhdd.base.model.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CasbinAuthzFilter extends OncePerRequestFilter {

    private final Enforcer enforcer;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain chain) throws IOException, ServletException {

//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String path = request.getRequestURI();
//        String method = request.getMethod();
//
//        boolean isAllowed = enforcer.enforce(user.getId(), path, method);
//
//        if (!isAllowed) {
//            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        }
        chain.doFilter(request, response);
    }
}