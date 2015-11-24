package com.ivend.converter.interfaces.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ivend.client.objects.Payments;
import com.ivend.client.objects.Refunds;
import com.ivend.client.objects.Sales;
import com.ivend.client.objects.TransactionItem;
import com.ivend.client.objects.Transactions;
import com.ivend.converter.interfaces.TransactionService;
import com.reacsa.constants.WsConstants;
import com.reacsa.utils.Utils;


public class TransactionServiceImplementation implements TransactionService {


	Utils util = new Utils();


	@Override
	public Transactions getAllTransactions() throws Exception {

		Transactions allTransactions = new Transactions();
		List<TransactionItem> transactionList = new ArrayList<TransactionItem>();

		List<String> transactionLines = util.getFile(WsConstants.TRANSACTION_FILENAME);
		
		for (String fileLine : transactionLines) {
		
			String[] itemTransaction = null;
			
			if (StringUtils.isNotBlank(fileLine)) {
				itemTransaction = fileLine.split("\\" + util.getStringProperty(WsConstants.SEPARATOR), -1);
			}
			
			/* Si no es un row de tipo transaccion (TSR), omitirlo */
			if (!itemTransaction[WsConstants.ROWTYPE].equalsIgnoreCase(WsConstants.TRANSACTION_ROW)){
				continue;
			}
			
			TransactionItem transaction = new TransactionItem();
			transaction.setUID(itemTransaction[WsConstants.UID]);
			transaction.setMessage(itemTransaction[WsConstants.MESSAGE]);
			
			boolean generateEnterpriseEvent =itemTransaction[WsConstants.GENERATEINTEGRATIONEVENT] != null && 
											 itemTransaction[WsConstants.GENERATEINTEGRATIONEVENT].equalsIgnoreCase("true")  ? true: false;
			
			transaction.setGenerateEnterpriseEvent(generateEnterpriseEvent);
			
			transaction.setEnterpriseName(itemTransaction[WsConstants.ENTERPRISENAME]);
			transaction.setUserFieldList(itemTransaction[WsConstants.USERFIELDLIST]);
			transaction.setStoreId(itemTransaction[WsConstants.STOREID]);
			transaction.setPosId(itemTransaction[WsConstants.POSID]);
			transaction.setUserId(itemTransaction[WsConstants.USERID]);
			transaction.setTransactionDate(itemTransaction[WsConstants.TRANSACTIONDATE]);
			transaction.setBusinessDate(itemTransaction[WsConstants.BUSINESSDATE]);
			transaction.setTransactionId(itemTransaction[WsConstants.TRANSACTIONID]);
			transaction.setCustomerId(itemTransaction[WsConstants.CUSTOMERID]);
			transaction.setContactId(itemTransaction[WsConstants.CONTACTID]);
			transaction.setDiscountType(itemTransaction[WsConstants.DISCOUNTTYPE]);
			transaction.setDiscountAmount(itemTransaction[WsConstants.DISCOUNTAMOUNT]);
			transaction.setDiscountPercent(itemTransaction[WsConstants.DISCOUNTPERCENT]);
			
			
			SalesServiceImplementation salesService = new SalesServiceImplementation();
			Sales sales = salesService.getSalesByTransaction(itemTransaction[WsConstants.UID]);
			transaction.setSalesItems(sales);

			
			RefundServiceImplementation refundService = new RefundServiceImplementation();
			Refunds refunds = refundService.getRefundsByTransaction(itemTransaction[WsConstants.UID]);
			transaction.setRefundItems(refunds);
	
			
			PaymentsServiceImplementation paymentService = new PaymentsServiceImplementation();
			Payments payments = paymentService.getPaymentsByTransaction(itemTransaction[WsConstants.UID]);
			transaction.setPayments(payments);
			
			
			
			transactionList.add(transaction);
			
		}
		
	
			

		allTransactions.setItems(transactionList);
		return allTransactions;
	}




}
