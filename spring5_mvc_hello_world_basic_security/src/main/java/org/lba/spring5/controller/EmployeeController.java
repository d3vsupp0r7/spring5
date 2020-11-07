package org.lba.spring5.controller;

import org.lba.spring5.controller.data.EmployeeFormModel;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

public interface EmployeeController {

	//C
	public String createEmployee(@ModelAttribute("employee") EmployeeFormModel aEmployee, BindingResult result);
	//R
	public String readAllEmployees(ModelMap model);
	//U
	public EmployeeFormModel updateEmployee(EmployeeFormModel aEmployee);
	//D
	public EmployeeFormModel deleteEmployee(EmployeeFormModel aEmployee);
	public String deleteEmployeeById(@PathVariable  String id);
}
