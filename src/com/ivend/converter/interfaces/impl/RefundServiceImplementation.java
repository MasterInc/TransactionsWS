package com.ivend.converter.interfaces.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ivend.client.objects.RefundItem;
import com.ivend.client.objects.Refunds;
import com.ivend.converter.interfaces.RefundService;
import com.reacsa.constants.WsConstants;
import com.reacsa.utils.Utils;

public class RefundServiceImplementation implements RefundService {

	Utils util = new Utils();

	public Refunds recoverAllPaymentsFromFile(String key) throws Exception {

		Refunds allRefunds = new Refunds();
		List<RefundItem> refundsList = new ArrayList<RefundItem>();

		List<String> refundsLines = util.getFile(WsConstants.REFUNDS_FILENAME);

		for (String refundLine : refundsLines) {

			String[] itemRefunds = null;

			if (StringUtils.isNotBlank(refundLine)) {
				itemRefunds = refundLine.split("\\" + util.getStringProperty(WsConstants.SEPARATOR), -1);
			}

			/*
			 * Si trae valor, entonces se busca un payment asociado a un
			 * transaction en especifico, dado por KEY
			 */
			if (StringUtils.isNotBlank(key) && !itemRefunds[WsConstants.UID].equalsIgnoreCase(key)) {
				continue;
			}

			RefundItem refundItem = new RefundItem();
			refundItem.setUID(itemRefunds[WsConstants.RIL_PTR_UID]);
			refundItem.setMessage(itemRefunds[WsConstants.RIL_MESSAGE]);
			refundItem.setGenerateEnterpriseEvent(itemRefunds[WsConstants.RIL_GENERATEINTEGRATIONEVENT]);
			refundItem.setEnterpriseName(itemRefunds[WsConstants.RIL_ENTERPRISENAME]);
			refundItem.setProductId(itemRefunds[WsConstants.RIL_PRODUCTID]);
			refundItem.setDescription(itemRefunds[WsConstants.RIL_DESCRIPTION]);
			refundItem.setTaxCodeId(itemRefunds[WsConstants.RIL_TAXCODEID]);
			refundItem.setQuantity(itemRefunds[WsConstants.RIL_QUANTITY]);
			refundItem.setDiscountType(itemRefunds[WsConstants.RIL_DISCOUNTTYPE]);
			refundItem.setDiscountAmount(itemRefunds[WsConstants.RIL_DISCOUNTAMOUNT]);
			refundItem.setDiscountPercent(itemRefunds[WsConstants.RIL_DISCOUNTPERCENT]);
			refundItem.setPrice(itemRefunds[WsConstants.RIL_PRICE]);
			refundItem.setProductDetailNumber(itemRefunds[WsConstants.RIL_PRODUCTDETAILNUMBER]);
			refundItem.setOriginalDocumentId(itemRefunds[WsConstants.RIL_ORIGINALDOCUMENTID]);
			refundItem.setOriginalDocumentKey(itemRefunds[WsConstants.RIL_ORIGINALDOCUMENTKEY]);
			refundItem.setManualDiscountType(itemRefunds[WsConstants.RIL_MANUALDISCOUNTTYPE]);
			refundItem.setManualDiscountAmount(itemRefunds[WsConstants.RIL_MANUALDISCOUNTAMOUNT]);
			refundItem.setManualDiscountPercent(itemRefunds[WsConstants.RIL_DISCOUNTPERCENT]);
			refundItem.setCouponDiscountAmount(itemRefunds[WsConstants.RIL_COUPONDISCOUNTAMOUNT]);
			refundItem.setUomId(itemRefunds[WsConstants.RIL_UOMID]);
			refundItem.setUomQuantity(itemRefunds[WsConstants.RIL_UOMQUANTITY]);
			refundItem.setUomBaseQuantity(itemRefunds[WsConstants.RIL_UOMBASEQUANTITY]);
			refundItem.setOriginalPrice(itemRefunds[WsConstants.RIL_ORIGINALPRICE]);
			/*
			refundItem.setCouponId(itemRefunds[WsConstants.SIL_CUOPONID]);
			refundItem.setiVendTransactionItemKey(itemRefunds[WsConstants.SIL_IVENDTRANSACTIONKEY]);
			refundItem.setTransactionItemId(itemRefunds[WsConstants.SIL_TRANSACTIONITEMID]);
			refundItem.setCouponSerialNumber(itemRefunds[WsConstants.SIL_CUOPONSERIALNUMBER]);
			refundItem.setProductReturnDetailNumber(itemRefunds[WsConstants.SIL_PRODUCTRETURNDETAILNUMBER]);
			*/
			refundsList.add(refundItem);
		}

		allRefunds.setItems(refundsList);

		return allRefunds;
	}

	public Refunds getRefundsByTransaction(String key) throws Exception {

		return recoverAllPaymentsFromFile(key);

	}

	@Override
	public Refunds getAllRefunds() throws Exception {
		return recoverAllPaymentsFromFile(null);
	}

}
