package com.talentpath.artportfolio.security;

import com.talentpath.artportfolio.exceptions.InvalidCharacterException;
import com.talentpath.artportfolio.exceptions.InvalidIndexException;
import com.talentpath.artportfolio.exceptions.NullExpectedFieldException;
import com.talentpath.artportfolio.models.Image;
import com.talentpath.artportfolio.models.LicenseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@Configuration      //tells Spring that this is to be used once for config
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;


    @Autowired
    JwtAuthEntryPoint entryPoint;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    //sets up the filter that will decode incoming jwts into
    //the basic username/password authentication tokens
    @Bean
    public AuthTokenFilter jwtFilter() {
        return new AuthTokenFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .cors()
                .and()
                .csrf().disable()
                .exceptionHandling()
                    .authenticationEntryPoint( entryPoint )
                .and()
                    .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS )
                .and()

                .authorizeRequests()

                .antMatchers( HttpMethod.POST, "/api/auth/signin").permitAll()
                .antMatchers( HttpMethod.POST, "/api/auth/signup").permitAll()

                .antMatchers(HttpMethod.GET,"/api/admin/licenseReqs").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/admin/licenseReqs/pending").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/admin/grantLicense/**","/api/admin/grantLicense").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/admin/viewLicenses").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/admin/revoke/**","/api/admin/revoke").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/admin/commissions").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/admin/commissions/pending").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/admin/commissions/update/**").hasAnyRole("ADMIN")


                .antMatchers( HttpMethod.GET, "/api/userdata", "/api/userdata/**").hasRole("ADMIN")
                .antMatchers( HttpMethod.POST, "/api/userdata" ).hasRole("ADMIN")
                .antMatchers( HttpMethod.PUT, "/api/userdata" ).hasRole("ADMIN")
                .antMatchers( HttpMethod.DELETE, "/api/userdata" ).hasRole("ADMIN")





                .anyRequest().permitAll().and()
                .addFilterBefore( jwtFilter(), UsernamePasswordAuthenticationFilter.class )
        ;

    }


    //this exposes the parent class' AuthenticationManager
    //as a bean to be use later
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
