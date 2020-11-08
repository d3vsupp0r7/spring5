# Scope

Implement a spring5 mvc OAuth2 Authentication without springboot framework.

# Application endpoints

**Root context:** http://localhost:8080/spring5_mvc_hello_world_basic_security_oidc_github/  

**Other resource app link:** http://localhost:8080/spring5_mvc_hello_world_basic_security_oidc_github/employee-web/readEmployees  

**Root context:** http://localhost:8080/spring5_mvc_hello_world_basic_security_oidc_github/login/oauth2/code/github  


# OIDC/OAuth2 Authorization callback URL

**template url:** {baseUrl}/login/oauth2/code/{registrationId}  
ES: http://localhost:8080/spring5_mvc_hello_world_basic_security_oidc_github/login/oauth2/code/github  

# Important security patter for SecurityConfig

This configuration shows the root context as not protected, and every other path requires authentication  

## Spring security context path config (Base)

```
http.antMatcher("/**").authorizeRequests()
.antMatchers("/").permitAll()
.anyRequest().authenticated()
.and().oauth2Login();
```

## Spring security context path config (Using OAuth2 approach)

```
@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/oauth2/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.oauth2Login()
		.clientRegistrationRepository(ClientRegistrationRepository())
		.authorizedClientService(authorizedClientService())
		.and()
		.csrf().disable();
		;
	}
```	

# GitHub reference

Implicit flow not supported by Github  
https://docs.github.com/en/free-pro-team@latest/developers/apps/authorizing-oauth-apps

## Baeldung
https://www.baeldung.com/spring-security-5-oauth2-login#1-creating-a-clientregistrationrepository-bean