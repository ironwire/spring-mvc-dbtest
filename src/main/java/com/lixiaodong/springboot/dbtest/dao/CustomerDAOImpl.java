package com.lixiaodong.springboot.dbtest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lixiaodong.springboot.dbtest.entity.Customer;

@Repository
public class CustomerDAOImpl {

	//need to inject the session factory
	@Autowired
	@PersistenceContext
	private EntityManager entityManager;

	
	@Transactional
	public List<Customer> getCustomers() {
		//make a specific query you want
		String jpql = "select c from Customer c ";
		//String jpql = "from Customer ";
		TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
		 

		List<Customer> customers = query.getResultList();
		
		return customers;
	}

}
