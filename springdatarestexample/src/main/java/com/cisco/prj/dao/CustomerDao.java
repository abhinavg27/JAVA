package com.cisco.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cisco.prj.entity.Customer;

@RepositoryRestResource(path="members", collectionResourceRel = "members")
public interface CustomerDao extends JpaRepository<Customer, String> {

}
