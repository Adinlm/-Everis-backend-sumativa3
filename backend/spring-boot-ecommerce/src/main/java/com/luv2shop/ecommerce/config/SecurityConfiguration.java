package com.luv2shop.ecommerce.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // protege  /api/orders
        http.authorizeRequests()
                .antMatchers("/api/orders/**")
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();

        // añade CORS filters
        http.cors();

        // fuerza una respuesta no vacia para 401, asi se hace la respuesta mas amigable
        Okta.configureResourceServer401ResponseBody(http);

        // deshabilita el CSRF, ya que no se esta usando cookies para rastrear la sesion
        http.csrf().disable();
    }
}













