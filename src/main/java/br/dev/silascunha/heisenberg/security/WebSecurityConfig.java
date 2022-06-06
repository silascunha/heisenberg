package br.dev.silascunha.heisenberg.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig {

    @Autowired
    private UsuarioDetailsService usuarioDetailsService;
    @Autowired
    private AuthEntryPointJwt authEntryPointJwt;

    private static final String[] PUBLIC_PATHS = {
        "/auth/login",
        "/swagger-ui/**",
        "/v3/api-docs/**"
    };

    private static final String[] PUBLIC_GET_PATHS = {
            "/status",
            "/exames/**",
            "/orientacoes/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authEntryPointJwt).and()
                .authorizeRequests()
               .antMatchers(PUBLIC_PATHS).permitAll()
               .antMatchers(HttpMethod.GET, PUBLIC_GET_PATHS).permitAll()
               .anyRequest().authenticated();
                // .anyRequest().permitAll();

        http.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
