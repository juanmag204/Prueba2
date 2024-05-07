package co.edu.usco.pw.springboot_crud01.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/h2-console/**").permitAll() // Permitir el acceso a ciertas rutas sin autenticación
                .antMatchers("/", "/admin/**").hasRole("ROLE_ADMIN") // Definir rutas para roles específicos
                .antMatchers("/user/**").hasRole("ROLE_USER")
                .anyRequest().authenticated() // Todas las demás rutas requieren autenticación
                .and()
                .formLogin(); // Configurar el formulario de inicio de sesión

        http.csrf().disable(); // Deshabilitar la protección CSRF
        http.headers().frameOptions().disable(); // Deshabilitar las opciones del marco
    }



}
