package com.velvetvictory.service;

import com.velvetvictory.dto.request.ChangePasswordDTO;
import com.velvetvictory.dto.request.CustomerRequest;
import com.velvetvictory.dto.request.LoginDTO;

public interface CustomerService {

	Object addCustomer(CustomerRequest customerRequest);

	Object deleteCustomerById(Long id);

	Object customerLogin(LoginDTO dto);

	Object forgotPassword(LoginDTO dto);

	Object changePassword(ChangePasswordDTO changePasswordDTO);

}
