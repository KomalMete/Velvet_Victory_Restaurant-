package com.velvetvictory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.velvetvictory.models.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

	@Query(value = "select * from orders where customer_id = :customerId", nativeQuery = true)
	List<Orders> getAllOrdersFromCustomerId(Long customerId);
}
