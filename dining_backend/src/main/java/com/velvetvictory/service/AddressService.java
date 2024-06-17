package com.velvetvictory.service;

import com.velvetvictory.dto.request.AddressRequest;

public interface AddressService {

	Object saveOrUpdateAddress(AddressRequest addressRequest);

	Object getAllAddress(String email);

	Object deleteAddressById(Long addressId, String email);

}
