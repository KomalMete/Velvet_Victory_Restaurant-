package com.velvetvictory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.velvetvictory.models.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query(value = " select * from cart where customer_id = :customerId ", nativeQuery = true)
	List<Cart> getCartByCustomerID(Long customerId);
}
