package org.lba.spring5.db.repository;

import javax.transaction.Transactional;

import org.lba.spring5.db.model.EmployeeDBModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<EmployeeDBModel, Long>{

	/*Spring5 - changes*/
	EmployeeDBModel findAllById(Long id);

	EmployeeDBModel findByName(String name);
	
	@Transactional
	@Modifying
	@Query("update EmployeeDBModel e set e.name = :name, e.surname = :surname where e.id = :id")
	int updateEmployeeById(@Param("id") long id, @Param("name")String name, @Param("surname")String surname);
}
