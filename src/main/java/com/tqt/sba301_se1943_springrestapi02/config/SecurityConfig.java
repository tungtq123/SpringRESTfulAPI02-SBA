package com.tqt.sba301_se1943_springrestapi02.config;//package com.sba301.config;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//
//import java.util.List;
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    private final JwtAuthenticationFilter jwtAuthenticationFilter;
//    private final AuthenticationProvider authenticationProvider;
//    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,
//                          AuthenticationProvider authenticationProvider) {
//        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//        this.authenticationProvider = authenticationProvider;
//
//    }
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(AbstractHttpConfigurer::disable)
//                .cors(cors -> cors.configurationSource(configurationSource()))
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider)
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(org.springframework.http.HttpMethod.OPTIONS, "/**").permitAll()
//                        .requestMatchers("/api/auth/login", "/api/auth/signup").permitAll()
//                        .requestMatchers("/api/auth/**").permitAll()
//                        .anyRequest().authenticated() )
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class).build();
//    }
//    @Bean
//    CorsConfigurationSource configurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowCredentials(true);
//        configuration.setAllowedOrigins(List.of("http://localhost:5173"));
//        configuration.setAllowedHeaders(List.of("Content-Type", "Authorization"));
//        configuration.addAllowedMethod("*");
//        return request -> configuration;
////        return new CorsConfigurationSource() {
////            @Override
////            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
////                CorsConfiguration config = new CorsConfiguration();
////                config.setAllowCredentials(true);
////                config.addAllowedOrigin("http://localhost:5173");
////                config.addAllowedHeader("*");
////                config.addAllowedMethod("*");
////                return config;
////            }
////        };
//    }
//}
