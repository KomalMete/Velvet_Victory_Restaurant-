package com.velvetvictory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velvetvictory.models.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

}
