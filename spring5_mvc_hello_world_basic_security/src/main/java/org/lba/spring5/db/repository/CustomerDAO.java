package org.lba.spring5.db.repository;

import org.lba.spring5.db.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends CrudRepository<Customer, Long> {

}
