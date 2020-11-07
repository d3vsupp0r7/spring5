package org.lba.spring5.config.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring5.config.data.AppInfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppInfoController {

	static final Logger logger = Logger.getLogger(AppInfoController.class);

	@Autowired
	private ApplicationContext applicationContext;

	@RequestMapping("/infoContextBeans")
	public String infoContextBeans(Model model) {

		logger.debug("*** infoContextBeans - START ***");
		// http://localhost:8080/spring5_mvc_hello_world/infoContextBeans
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		List<AppInfoBean> beanInContextList = new ArrayList<AppInfoBean>();

		int i = 1;
		for (String beanName : beanNames) {

			logger.debug(beanName + " : " + applicationContext.getBean(beanName).getClass().toString());
			AppInfoBean bean = new AppInfoBean(i,beanName,applicationContext.getBean(beanName).getClass().toString()); 
			/**/
			beanInContextList.add(bean);
			/**/
			i++;
		}

		model.addAttribute("beanInContextList", beanInContextList);
		logger.debug("*** infoContextBeans - END ***");
		return "infoContextBeans.html";
	}

	@RequestMapping("/infoContextBeansByName")
	public String infoContextBeansByName(@RequestParam String beanName, Model model) {
		//	http://localhost:8080/spring5_mvc_hello_world/infoContextBeansByName?beanName=employeeServiceImpl

		logger.debug("*** infoContextBeansByName - START ***");
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		List<AppInfoBean> beanInContextList = new ArrayList<AppInfoBean>();

		int i = 1;
		for (String currentBeanName : beanNames) {

			if(currentBeanName.equals(beanName)) {
				logger.debug(currentBeanName + " : " + applicationContext.getBean(currentBeanName).getClass().toString());
				AppInfoBean bean = new AppInfoBean(i,currentBeanName,applicationContext.getBean(currentBeanName).getClass().toString()); 
				/**/
				beanInContextList.add(bean);
				/**/
				i++;
			}
		}

		model.addAttribute("beanInContextList", beanInContextList);
		logger.debug("*** infoContextBeansByName - END ***");
		
		return "infoContextBeans.html";
	}
}
