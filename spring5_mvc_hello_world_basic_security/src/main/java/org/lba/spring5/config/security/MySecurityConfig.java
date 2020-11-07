package org.lba.spring5.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//	@Bean
	//	public BCryptPasswordEncoder passwordEncoder() {
	//		return new BCryptPasswordEncoder();
	//	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 Note that the order of the antMatchers() elements is significant – the more specific rules need to come first, followed by the more general ones.
		 */
		http.authorizeRequests().antMatchers("/customers**").hasAnyRole("ADMIN", "USER")
		.and()
		.authorizeRequests().antMatchers("/home**").permitAll()
		.and()
		.formLogin()
		.and()
		.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*   auth.inMemoryAuthentication().withUser("ram").password("ram123").roles("ADMIN"); */
		auth.inMemoryAuthentication()
		.passwordEncoder(passwordEncoder)
		.withUser("user").password(passwordEncoder.encode("123456")).roles("USER")
		.and()
		.withUser("admin").password(passwordEncoder.encode("123456")).roles("USER", "ADMIN");
		
		//auth.userDetailsService(userDetailsService)
	}

	/*
 @Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    // Read the file
    // Loop through all users and search for the given username
    // Return User or throw UsernameNotFoundException
    auth.userDetailsService(username -> {
            try {
                String pathToFile = // Path to file;
                List<String> users = Files.readAllLines(Paths.get(pathToFile));
                for (String user : users) {
                    String[] parts = user.split("\\s+", 2);
                    String theUsername = parts[0];
                    String password = parts[1];

                    if (username.equals(theUsername))
                        return new User(theUsername, password, Collections.singleton(new SimpleGrantedAuthority("USER")));
                }
                throw new UsernameNotFoundException("Invalid username");
            } catch (Exception e) {
                throw new UsernameNotFoundException("Invalid username");
            }
    });
}
	 */
}
