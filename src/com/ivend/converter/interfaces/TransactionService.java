package com.ivend.converter.interfaces;


import com.ivend.client.objects.Transactions;

public interface TransactionService {

	Transactions getAllTransactions() throws Exception;
}
