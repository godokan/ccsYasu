package com.yasu.ccs.config;

//import com.yasu.ccs.security.APIKeyAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.IpAddressMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private static final String[] WHITE_LIST = {
            "/",
            "/home",
            "/profile",
            "/notice",
            "/freeboard",
            "/login",
            "/logout",
            "/signup",
            "/chkIdDuplicate",
            "/error",
            "/css/**",
            "/fonts/**",
            "/images/**",
            "/js/**"
    };

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers(WHITE_LIST);
//    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/**");
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
//                        .requestMatchers(WHITE_LIST).permitAll()
//                        .requestMatchers(new IpAddressMatcher("127.0.0.1")).permitAll())
//
//                .cors(AbstractHttpConfigurer::disable)
//                .csrf(AbstractHttpConfigurer::disable)
//                .headers((headers) -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
//                .formLogin(AbstractHttpConfigurer::disable)
//                .logout(AbstractHttpConfigurer::disable);
//
//        return http.build();
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

//@Configuration
//class ApiSecurityConfig{
//    @Value("${projectYasu.http.auth-token-header.name}")
//    private String principalRequestHeader;
//
//    @Value("${projectYasu.http.auth-token}")
//    private String principalRequestValue;
//
//    @Bean
//    public SecurityFilterChain ApisecurityFilterChain(HttpSecurity http) throws Exception {
//        APIKeyAuthFilter filter = new APIKeyAuthFilter(principalRequestHeader);
//        filter.setAuthenticationManager(authentication -> {
//            String principal = (String) authentication.getPrincipal();
//            if (!principalRequestValue.equals(principal)) {
//                throw new BadCredentialsException("The API key was not found or not the expected value.");
//            }
//            authentication.setAuthenticated(true);
//            return authentication;
//        });
//
//        http
//                .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
//                        .requestMatchers(new AntPathRequestMatcher("/api/**")).permitAll())
//                .cors(AbstractHttpConfigurer::disable)
//                .csrf(AbstractHttpConfigurer::disable)
//                .sessionManagement((sessionManagement) -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .formLogin(AbstractHttpConfigurer::disable)
//                .logout(AbstractHttpConfigurer::disable)
//                .headers((headers) -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
//                .addFilterAfter(filter, AuthorizationFilter.class);
//
//        return http.build();
//    }
//}
