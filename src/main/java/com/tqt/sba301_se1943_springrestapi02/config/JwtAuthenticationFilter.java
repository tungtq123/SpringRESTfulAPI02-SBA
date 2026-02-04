package com.tqt.sba301_se1943_springrestapi02.config;//package com.sba301.config;
//
//import com.sba301.dto.UserDetailDTO;
//import jakarta.annotation.Nonnull;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//
//import java.io.IOException;
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    private final HandlerExceptionResolver handlerExceptionResolver;
//    private final JwtTokenProvider jwtTokenProvider;
//    private final UserDetailsService userDetailsService;
//    public JwtAuthenticationFilter(HandlerExceptionResolver handlerExceptionResolver,
//                                   JwtTokenProvider jwtTokenProvider,
//                                   UserDetailsService userDetailsService) {
//        this.handlerExceptionResolver = handlerExceptionResolver;
//        this.jwtTokenProvider = jwtTokenProvider;
//        this.userDetailsService = userDetailsService;
//    }
//    @Override
//    protected void doFilterInternal(@Nonnull HttpServletRequest request,
//                                    @Nonnull HttpServletResponse response,
//                                    @Nonnull FilterChain filterChain) throws ServletException, IOException {
//        final String authHeader = request.getHeader("Authorization");
//        String path = request.getServletPath();
//        System.out.println("Path: " + path);
//        if(path.startsWith("/api/auth/")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            System.out.println("No token found");
//            filterChain.doFilter(request, response);
//            return;
//        }
//        try {
//            final String token = authHeader.substring(7);
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            String userEmail = jwtTokenProvider.getUsernameFromToken(token);
//            if (userEmail != null && authentication == null) {
//                UserDetails userPrincipal = userDetailsService.loadUserByUsername(userEmail);
//
//                if (jwtTokenProvider.validateToken(token, (UserDetailDTO) userPrincipal)) {
//                    UsernamePasswordAuthenticationToken authenticationToken =
//                            new UsernamePasswordAuthenticationToken(
//                                    userPrincipal,
//                                    null,
//                                    userPrincipal.getAuthorities()
//                            );
//                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                }
//
//            }
//            filterChain.doFilter(request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//            handlerExceptionResolver.resolveException(request, response, null, e);
//        }
//    }
//}
