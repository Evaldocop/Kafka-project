package com.gesoft.paymentservice.service;

import com.gesoft.paymentservice.model.Payment;

public interface PaymentService {

	void sendPayment(Payment payment);
	
}
