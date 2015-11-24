package com.ivend.converter.interfaces;



import com.ivend.client.objects.Payments;

public interface PaymentService {

	Payments getAllPayments() throws Exception;

	Payments getPaymentsByTransaction(String key) throws Exception;
}
