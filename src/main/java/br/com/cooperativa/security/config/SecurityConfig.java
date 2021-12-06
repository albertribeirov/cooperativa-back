package br.com.cooperativa.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Ainda não foi sobrescrito o método de autenticação, somente o de acesso aos endpoints

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Only - admin role - can POST, PUT and DELETE a new record.
        http.
                csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/cliente/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/cliente/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/cliente/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/cooperado/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/cooperado/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/cooperado/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/detalhamentovenda/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/detalhamentovenda/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/detalhamentovenda/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/endereco/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/endereco/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/endereco/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/estoque/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/estoque/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/estoque/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/material/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/material/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/material/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/movimentacaoestoque/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/movimentacaoestoque/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/movimentacaoestoque/*").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().httpBasic();


    }
}
