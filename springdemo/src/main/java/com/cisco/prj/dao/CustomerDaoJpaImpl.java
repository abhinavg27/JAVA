package com.cisco.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cisco.prj.entity.Customer;

@Repository
public class CustomerDaoJpaImpl implements CustomerDao {
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void addCustomer(Customer c) {
		em.persist(c);
	}

	@Override
	public List<Customer> getCustomers() {
		String jpql = "from Customer";
		TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
		return query.getResultList();
	}

}
