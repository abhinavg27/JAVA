package com.cisco.prj.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cisco.prj.entity.Order;

@Repository
public class OrderDaoJpaImpl implements OrderDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOrder(Order o) {
		em.persist(o);
	}

	@Override
	public Order getOrder(int id) {
		return em.find(Order.class, id);
	}

}
