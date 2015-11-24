package com.ivend.converter.interfaces.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ivend.client.objects.PaymentItem;
import com.ivend.client.objects.Payments;

import com.ivend.converter.interfaces.PaymentService;
import com.reacsa.constants.WsConstants;
import com.reacsa.utils.Utils;

public class PaymentsServiceImplementation implements PaymentService {

	Utils util = new Utils();

	@Override
	public Payments getAllPayments() throws Exception {

		return recoverAllPaymentsFromFile(null);

	}

	@Override
	public Payments getPaymentsByTransaction(String key) throws Exception {
		return recoverAllPaymentsFromFile(key);

	}

	private Payments recoverAllPaymentsFromFile(String key) throws Exception {

		Payments allPayments = new Payments();
		List<PaymentItem> paymentsList = new ArrayList<PaymentItem>();

		List<String> paymentsLines = util.getFile(WsConstants.PAYMENTS_FILENAME);

		for (String paymentLine : paymentsLines) {
			String[] itemPayments = null;
			if (StringUtils.isNotBlank(paymentLine)) {
				itemPayments = paymentLine.split("\\" + util.getStringProperty(WsConstants.SEPARATOR), -1);
			}

			/* Si no es un item de tipo payment, se descarta la linea */
			if (!itemPayments[WsConstants.ROWTYPE].equalsIgnoreCase(WsConstants.PAYENT_ROW)) {
				continue;
			}

			/*
			 * Si trae valor, entonces se busca un payment asociado a un
			 * transaction en especifico, dado por KEY
			 */
			if (StringUtils.isNotBlank(key) && !itemPayments[WsConstants.UID].equalsIgnoreCase(key)) {
				continue;
			}

			PaymentItem paymentItem = new PaymentItem();
			paymentItem.setUID(itemPayments[WsConstants.PYMT_PTR_UID]);
			paymentItem.setMessage(itemPayments[WsConstants.PYMT_MESSAGE]);
			
			
			boolean generateEnterpriseEvent =itemPayments[WsConstants.PYMT_GENERATEINTEGRATIONEVENT] != null && 
					itemPayments[WsConstants.PYMT_GENERATEINTEGRATIONEVENT].equalsIgnoreCase("true")  ? true: false;
			
			paymentItem.setGenerateEnterpriseEvent(generateEnterpriseEvent);
			paymentItem.setUserFieldList(itemPayments[WsConstants.PYMT_USERFIELDLIST]);
			paymentItem.setTransactionKey(itemPayments[WsConstants.PYMT_TRANSACTIONKEY]);
			paymentItem.setPaymentTypeId(itemPayments[WsConstants.PYMT_PAYMENTTYPEID]);
			paymentItem.setTenderType(itemPayments[WsConstants.PYMT_TENDERTYPE]);
			paymentItem.setDetailKey(itemPayments[WsConstants.PYMT_DETAILKEY]);
			paymentItem.setDetailType(itemPayments[WsConstants.PYMT_DETAILTYPE]);
			paymentItem.setAmount(itemPayments[WsConstants.PYMT_AMOUNT]);
			paymentItem.setPaidAmount(itemPayments[WsConstants.PYMT_PAIDAMOUNT]);
			paymentItem.setAccountType(itemPayments[WsConstants.PYMT_ACCOUNTTYPE]);
			paymentItem.setCurrencyId(itemPayments[WsConstants.PYMT_CURRENCYID]);
			paymentItem.setIsVoided(itemPayments[WsConstants.PYMT_ISVOIDED]);

			paymentsList.add(paymentItem);

		}

		allPayments.setItems(paymentsList);

		return allPayments;
	}

}
