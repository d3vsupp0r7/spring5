package org.lba.spring5.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApplicationListenerBean implements ApplicationListener<ApplicationEvent> {

	static final Logger logger = Logger.getLogger(ApplicationListenerBean.class);
	
	@Value("${spring.profiles.active:}")
    private String activeProfiles;
	
	@Override
	public void onApplicationEvent(ApplicationEvent event) {

		if(event instanceof ContextRefreshedEvent) {
			logger.debug("**********************************************");
			logger.debug("*****    ALL SPRING CONTEXT IS LOADED    *****");
			getActiveProfiles();
		}
	}
	
    public void getActiveProfiles() {
    	
    	logger.debug("* Application started with ACTIVE PROFILES:  *");
        for (String profileName : activeProfiles.split(",")) {
        	logger.debug("Currently active profile: " + profileName);
        }
    	logger.debug("**********************************************");
    }

}
