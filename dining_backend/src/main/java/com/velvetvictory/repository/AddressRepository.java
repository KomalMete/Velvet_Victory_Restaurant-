package com.velvetvictory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velvetvictory.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> 
{
	List<Address> findByCustomerEmail(String email);
}
