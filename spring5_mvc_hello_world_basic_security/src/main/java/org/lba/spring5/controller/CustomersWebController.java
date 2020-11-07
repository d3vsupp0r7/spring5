package org.lba.spring5.controller;

import java.security.Principal;

import org.lba.spring5.db.model.Customer;
import org.lba.spring5.db.repository.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomersWebController {

    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping(path = "/home")
    public String index() {
        return "external.html";
    }

    @GetMapping(path = "/customers")
    @PreAuthorize("hasRole('ADMIN')")
    public String customers(Principal principal, Model model) {
        addCustomers();
        Iterable<Customer> customers = customerDAO.findAll();
        model.addAttribute("customers", customers);
         model.addAttribute("username", principal.getName());
        return "customers.html";
    }

    // add customers for demonstration
    public void addCustomers() {

        Customer customer1 = new Customer();
        customer1.setAddress("1111 foo blvd");
        customer1.setName("Foo Industries");
        customer1.setServiceRendered("Important services");
        customerDAO.save(customer1);

        Customer customer2 = new Customer();
        customer2.setAddress("2222 bar street");
        customer2.setName("Bar LLP");
        customer2.setServiceRendered("Important services");
        customerDAO.save(customer2);

        Customer customer3 = new Customer();
        customer3.setAddress("33 main street");
        customer3.setName("Big LLC");
        customer3.setServiceRendered("Important services");
        customerDAO.save(customer3);
    }
}
