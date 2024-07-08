package com.velvetvictory.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velvetvictory.dto.request.PaymentDTO;
import com.velvetvictory.models.Payment;
import com.velvetvictory.repository.PaymentRepository;
import com.velvetvictory.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public Object transaction(PaymentDTO paymentDTO) {
		
		Payment payment = new Payment();
		
		payment.setId(paymentDTO.getId());
		payment.setPaymentMode(paymentDTO.getPaymentMode());
		
		paymentRepository.save(payment);
		return "Payment Successfull..";
	}

}
