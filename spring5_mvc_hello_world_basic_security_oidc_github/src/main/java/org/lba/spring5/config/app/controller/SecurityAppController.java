package org.lba.spring5.config.app.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityAppController {

	static final Logger logger = Logger.getLogger(SecurityAppController.class);

	
	
	@RequestMapping("/infoSecurityContext")
	public String sec(Principal principal, Model model) {
		/*String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Object rawPassword  = SecurityContextHolder.getContext().getAuthentication().getCredentials();*/
		
		SecurityContext context = SecurityContextHolder.getContext();
		/**/
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Object rawPassword  = SecurityContextHolder.getContext().getAuthentication().getCredentials();
		/**/
		logger.debug("USERNAME: " + username);
		logger.debug("RAW PASS: " + rawPassword);
	    Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            //return null;
        	logger.debug("*** [SEC] - USER NOT AUTHENTICATED ***");
        }
        
        principal = (Principal) authentication.getPrincipal();
        
        if (principal instanceof UserDetails) {
        	String usernameFromUserDetails = ((UserDetails) principal).getUsername();
        	
        	logger.debug("[SEC] - PRINCIPAL PRESENT FOR USER DETAILS ***");
        	logger.debug("[SEC] - usernameFromUserDetails: " + usernameFromUserDetails);
        	
        } else {
        	logger.debug("[SEC] - PRINCIPAL NOT PRESENT FOR USER DETAILS ***");
        }
		
        model.addAttribute("username", principal.getName());
        return "customers.html";
	}
}
