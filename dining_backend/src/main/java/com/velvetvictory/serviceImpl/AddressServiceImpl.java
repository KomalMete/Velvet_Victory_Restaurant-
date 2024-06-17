package com.velvetvictory.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velvetvictory.dto.request.AddressRequest;
import com.velvetvictory.models.Address;
import com.velvetvictory.models.Customer;
import com.velvetvictory.repository.AddressRepository;
import com.velvetvictory.repository.CustomerRepository;
import com.velvetvictory.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public Object saveOrUpdateAddress(AddressRequest addressRequest) {
		
		Address address;
		if(addressRepo.existsById(addressRequest.getId()))
		{
			address = addressRepo.findById(addressRequest.getId()).get();
		}
		else
		{
			address = new Address();
		}
		address.setId(addressRequest.getId());
		address.setCity(addressRequest.getCity());
		address.setAddress(addressRequest.getAddress());
		address.setLandmark(addressRequest.getLandmark());
		address.setPincode(addressRequest.getPincode());
		address.setState(addressRequest.getState());
		
		//after JWT u can do this instead of passing customerId manually
		Customer customer = customerRepo.findById(addressRequest.getCustomerId()).orElseThrow(()-> new IllegalArgumentException("Customer Id doesnt exist"));
		address.setCustomer(customer);
		
		addressRepo.save(address);
		return "Address details saved successfully..";
	}

}
