package com.ivend.converter.interfaces;


import com.ivend.client.objects.Sales;

public interface SalesService {

	Sales getAllSales() throws Exception;

	Sales getSalesByTransaction(String key) throws Exception;
}
