package org.lba.spring5.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring5.controller.data.EmployeeFormModel;
import org.lba.spring5.db.model.EmployeeDBModel;
import org.lba.spring5.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee-web")
public class EmployeeNavigationControllerImpl implements EmployeeController{

	static final Logger logger = Logger.getLogger(EmployeeNavigationControllerImpl.class);

	@Autowired
	private EmployeeService employeeService;

	/* CREATE */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String setupForm(Model model)
	{// http://localhost:8080/spring4_db_war_all/employee-web/addEmployee
		EmployeeFormModel employeeVO = new EmployeeFormModel();
		model.addAttribute("employee", employeeVO);
		return "/form/addEmployee";
	}

	@Override
	@RequestMapping(value = "/submitAddEmployee", method = RequestMethod.POST)
	public String createEmployee(@ModelAttribute("employee") EmployeeFormModel aEmployee, BindingResult result) {

		//Validation code start
		boolean error = false;
		//Verifying if information is same as input by user  
		logger.debug("Employee form data: " + aEmployee.toString()); 

		error = validateEmployeeForm(aEmployee, result);
		
		if(error) {
			return "employees/form/addEmployee";
		}

		EmployeeDBModel employee = new EmployeeDBModel(aEmployee.getName(), aEmployee.getSurname());
		employeeService.saveEmployee(employee);

		return "redirect:/employee-web/readEmployees";
	}

	private boolean validateEmployeeForm(EmployeeFormModel aEmployee,  BindingResult result) {

		boolean error = false;
		
		if(aEmployee.getName().isEmpty()){
			result.rejectValue("name", "error.name");
			error = true;
		}

		if(aEmployee.getSurname().isEmpty()){
			result.rejectValue("surname", "error.surname");
			error = true;
		}
		
		return error;
	}

	/* READ */
	@Override
	@GetMapping("/readEmployees")
	public String readAllEmployees(ModelMap model) {
		// http://localhost:8080/spring4_db_war_all/employee-web/readEmployees
		List<EmployeeDBModel> employeesFromDB = employeeService.listAllEmployees();
		model.addAttribute("employees",employeesFromDB);
		return "/allEmployees";
	}

	/* UPDATE */
	@Override
	public EmployeeFormModel updateEmployee(EmployeeFormModel aEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	/* DELETE */
	@Override
	public EmployeeFormModel deleteEmployee(EmployeeFormModel aEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/delete-employee/{id}" }, method = RequestMethod.GET)
	public String deleteEmployeeById(@PathVariable String id) {
		 employeeService.deleteEmployeeById(Long.parseLong(id));
		 
		 return "redirect:/employee-web/readEmployees";
	}


}
