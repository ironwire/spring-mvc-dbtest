package com.lixiaodong.springboot.dbtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lixiaodong.springboot.dbtest.dao.*;
import com.lixiaodong.springboot.dbtest.entity.Customer;

@Controller
@RequestMapping("/customer") 
public class CustomerController {
	
	//inject the customer DAO
	@Autowired
	private CustomerDAOImpl customerDAO;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		//get the customers from the dao
		List<Customer> theCustomers = customerDAO.getCustomers();
		//add the customers to the model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
}
