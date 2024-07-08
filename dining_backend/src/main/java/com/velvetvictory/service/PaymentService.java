package com.velvetvictory.service;

import com.velvetvictory.dto.request.PaymentDTO;

public interface PaymentService {

	Object transaction(PaymentDTO paymentDTO);

}
