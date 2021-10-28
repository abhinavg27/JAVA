package com.cisco.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cisco.prj.dto.ReportDTO;
import com.cisco.prj.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{

	@Query("select new com.cisco.prj.dto.ReportDTO(o.oid, o.orderDate, o.total, c.email, c.firstName) from Order o inner join o.customer c")
	List<ReportDTO> getReport();
}
