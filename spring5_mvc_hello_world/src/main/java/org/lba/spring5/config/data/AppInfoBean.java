package org.lba.spring5.config.data;

import java.io.Serializable;

public class AppInfoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2716896034373055943L;
	private int id;
	private String beanName;
	private String beanClassName;
	
	public AppInfoBean(int id, String beanName, String beanClassName) {
		super();
		this.id = id;
		this.beanName = beanName;
		this.beanClassName = beanClassName;
	}

	public String getBeanClassName() {
		return beanClassName;
	}

	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
	}

	public AppInfoBean() {
		// TODO Auto-generated constructor stub
	}

	public AppInfoBean(int id, String beanName) {
		super();
		this.id = id;
		this.beanName = beanName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	@Override
	public String toString() {
		return "AppInfoBean [id=" + id + ", beanName=" + beanName + ", beanClassName=" + beanClassName + "]";
	}

}
