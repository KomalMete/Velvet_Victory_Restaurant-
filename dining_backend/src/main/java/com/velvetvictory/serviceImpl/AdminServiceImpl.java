package com.velvetvictory.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velvetvictory.dto.request.AdminRequest;
import com.velvetvictory.dto.request.LoginDTO;
import com.velvetvictory.models.Admin;
import com.velvetvictory.models.Customer;
import com.velvetvictory.repository.AdminRepository;
import com.velvetvictory.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public Object saveOrUpdateAdmin(AdminRequest adminRequest)
	{
		Admin admin;
		
		if(adminRepo.existsById(adminRequest.getId()))
		{
			admin = adminRepo.findById(adminRequest.getId()).get();
		}
		else
		{
			admin = new Admin();
		}
		admin.setId(adminRequest.getId());
		admin.setFirstName(adminRequest.getFirstName());
		admin.setLastName(adminRequest.getLastName());
		admin.setEmail(adminRequest.getEmail());
		admin.setPassword(adminRequest.getPassword());
		admin.setContact(adminRequest.getContact());
		admin.setRole(adminRequest.getRole());
		
		adminRepo.save(admin);
		return "Admin details added successfully..";
	}

	@Override
	public Object deleteAdminById(Long id) {

		if(adminRepo.existsById(id))
		{
			adminRepo.deleteById(id);
			return "Admin deleted successfully..";
		}
		else
		{
			return "Admin doesnt exist..";
		}
	}

	@Override
	public Object adminLogin(LoginDTO dto) {
		
		if(dto != null)
		{
			Admin admin = adminRepo.findByEmail(dto.getEmail());
			
			if(admin != null)
			{
				if(dto.getPassword().equals(admin.getPassword()))
				{
					return "Login Successfull...";
				}
				else
				{
					return "Password is not correct";
				}
			}
			else
			{
				return "provided email is not correct";
			}		
		}
		else
		{
			return "DTO cant be null...";
		}
	}
	}


