package org.lba.spring5.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring5.db.model.EmployeeDBModel;
import org.lba.spring5.db.repository.EmployeeRepository;
import org.lba.spring5.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	/* CREATE */
	@Override
	public EmployeeDBModel saveEmployee(EmployeeDBModel employee) {

		EmployeeDBModel savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}

	/* READ */
	@Override
	public List<EmployeeDBModel> listAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeeDBModel findById(long id) {
		return employeeRepository.findAllById(id);
	}

	//	/* UPDATE */
	@Override
	public int updateEmployeeById(long id,EmployeeDBModel aEmployee) {

		int result = -1;

		result = employeeRepository.updateEmployeeById(id, aEmployee.getName(), aEmployee.getSurname());

		return result;
	}

	/* DELETE */
	@Override
	public void deleteEmployeeById(long id) {
		//Spring 5 mod
		employeeRepository.deleteById(id);
	}
	
}
