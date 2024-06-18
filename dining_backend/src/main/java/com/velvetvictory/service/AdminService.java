package com.velvetvictory.service;

import com.velvetvictory.dto.request.AdminRequest;
import com.velvetvictory.dto.request.LoginDTO;

public interface AdminService {

	Object saveOrUpdateAdmin(AdminRequest adminRequest);

	Object deleteAdminById(Long id);

	Object adminLogin(LoginDTO dto);

}
