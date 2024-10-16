package com.velvetvictory.serviceImpl;

import java.util.function.Supplier;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.velvetvictory.dto.request.ChangePasswordDTO;
import com.velvetvictory.dto.request.CustomerRequest;
import com.velvetvictory.dto.request.LoginDTO;
import com.velvetvictory.models.Customer;
import com.velvetvictory.repository.CustomerRepository;
import com.velvetvictory.service.CustomerService;

import lombok.Value;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;

	    @org.springframework.beans.factory.annotation.Value("${spring.mail.username}")
	    private String fromEmail;

	    @Autowired
	    private TemplateEngine templateEngine;

	@Override
	public Object addCustomer(CustomerRequest customerRequest)
	{
		
		if(customerRequest != null)
		{
			Customer customer = new Customer();
			
			customer.setId(customerRequest.getId());
			customer.setFirstName(customerRequest.getFirstName());
			customer.setLastName(customerRequest.getLastName());
			customer.setEmail(customerRequest.getEmail());
			customer.setPassword(customerRequest.getPassword());
			customer.setContact(customerRequest.getContact());
			customer.setRole(customerRequest.getRole());
			
			
			
	      //email with html-content
          try{
              Context context = new Context();
              context.setVariable("firstName", customer.getFirstName());
              context.setVariable("lastName", customer.getLastName());
              context.setVariable("otp", generateOTP());
              this.sendEmailWithTemplate("komaldmete16@gmail.com", "Sign Up", context);
              customerRepository.save(customer);
  				return "Customer Registration Successfull..";
          }
          catch (MessagingException e)
          {
              e.printStackTrace();
             return "Customer Registration Not Successfull..";
          }
		}
		else
		{
			return "Customer Registration Not Successfull..";
		}
	}
	

    public void sendEmailWithTemplate(String to, String subject, Context context) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");

        mimeMessageHelper.setFrom(fromEmail);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);

        String htmlContent = templateEngine.process("Registration", context);
        mimeMessageHelper.setText(htmlContent,true);

        javaMailSender.send(mimeMessage);

    }

    public String generateOTP()
    {
    	//java8 feature
    	Supplier<String> s = () -> {
    		String otp = "";
    		for(int i=0; i<=5; i++)
    		{
    			otp = otp + (int)(Math.random()*10);
    		}
    		return otp;
    	};
    	String generatedOTP = s.get();
    	return generatedOTP;
    }

	@Override
	public Object deleteCustomerById(Long id) {
		
		if(customerRepository.existsById(id))
		{
			customerRepository.deleteById(id);
			return "Customer deleted successfully..";
		}
		else
		{
			return "Customer doesnt exist..";
		}
	}


	@Override
	public Object customerLogin(LoginDTO dto) {
		if(dto != null)
		{
			Customer customer = customerRepository.findByEmail(dto.getEmail());
			
			if(customer != null)
			{
				if(dto.getPassword().equals(customer.getPassword()))
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


	@Override
	public Object forgotPassword(LoginDTO dto) {
		
		if(dto != null)
		{
			Customer customer = customerRepository.findByEmail(dto.getEmail());
			
			String oldPassword = customer.getPassword();
			
			//System.out.println(oldPassword);
			//System.out.println(dto.getPassword());
			
			if(dto.getPassword().equals(oldPassword))
			{
				
				return "New-Password can not be same as Old-Password";

			}
			else
			{
				customer.setPassword(dto.getPassword());
				customerRepository.save(customer);
				return "New-Password saved successfully..";
			}
		}
		else
		{
			return "Please provide Email and Password";
		}
	}


	@Override
	public Object changePassword(ChangePasswordDTO changePasswordDTO) {
		
		Customer customer = customerRepository.findByEmail(changePasswordDTO.getEmail());
		
		String oldPassword = changePasswordDTO.getOldPassword();
		
		String newPassword = changePasswordDTO.getNewPassword();
		
		if(customer.getPassword().equals(oldPassword))
		{
			if(newPassword != null)
			{
				customer.setPassword(newPassword);
				customerRepository.save(customer);
				return "Password changed successfully..";
			}
			else
			{
				return "New password can't be null";
			}
		}
		else
		{
			return "Provided Old-Password is not correct..";
		}
	}
}
