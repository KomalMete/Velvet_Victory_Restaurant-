package com.velvetvictory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velvetvictory.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
