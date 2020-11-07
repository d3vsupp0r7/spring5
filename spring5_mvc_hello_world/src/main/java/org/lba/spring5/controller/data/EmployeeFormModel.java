package org.lba.spring5.controller.data;

import java.io.Serializable;

public class EmployeeFormModel implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1871187265329449986L;

	private Long id;
	private String name;
	private String surname;
	
	public EmployeeFormModel() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "EmployeeFormModel [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}

}
