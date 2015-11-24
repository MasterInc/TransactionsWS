package com.ivend.converter.interfaces.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ivend.client.objects.Sales;
import com.ivend.client.objects.SalesItem;
import com.ivend.converter.interfaces.SalesService;
import com.reacsa.constants.WsConstants;
import com.reacsa.utils.Utils;

public class SalesServiceImplementation implements SalesService {

	Utils util = new Utils();

	public Sales getAllSalesFromFile(String key) throws Exception {
		
		Sales allSales = new Sales();
		List<SalesItem> salesList = new ArrayList<SalesItem>();
		
		

		List<String> salesLines = util.getFile(WsConstants.SALES_FILENAME);
		for (String salesLine : salesLines) {

			String[] itemSales = null;

			if (StringUtils.isNotBlank(salesLine)) {
				itemSales = salesLine.split("\\" + util.getStringProperty(WsConstants.SEPARATOR), -1);
			}
			
			/* Si no es un item de tipo payment, se descarta la linea */
			if (!itemSales[WsConstants.ROWTYPE].equalsIgnoreCase(WsConstants.SALES_ROW)) {
				continue;
			}

			/*
			 * Si trae valor, entonces se busca un payment asociado a un
			 * transaction en especifico, dado por KEY
			 */
			if (StringUtils.isNotBlank(key) && !itemSales[WsConstants.UID].equalsIgnoreCase(key)) {
				continue;
			}
			
			

			SalesItem salesItem = new SalesItem();
			salesItem.setUID(itemSales[WsConstants.SIL_PTR_UID]);
			salesItem.setMessage(itemSales[WsConstants.SIL_MESSAGE]);
			
			boolean generateEnterpriseEvent =itemSales[WsConstants.SIL_GENERATEINTEGRATIONEVENT] != null && 
											itemSales[WsConstants.SIL_GENERATEINTEGRATIONEVENT].equalsIgnoreCase("true")  ? true: false;
			
			salesItem.setGenerateEnterpriseEvent(generateEnterpriseEvent);
			
			
			salesItem.setEnterpriseName(itemSales[WsConstants.SIL_ENTERPRISENAME]);
			salesItem.setProductId(itemSales[WsConstants.SIL_PRODUCTID]);
			salesItem.setDescription(itemSales[WsConstants.SIL_DESCRIPTION]);
			salesItem.setTaxCodeId(itemSales[WsConstants.SIL_TAXCODEID]);
			salesItem.setQuantity(itemSales[WsConstants.SIL_QUANTITY]);
			salesItem.setDiscountType(itemSales[WsConstants.SIL_DISCOUNTTYPE]);
			salesItem.setDiscountAmount(itemSales[WsConstants.SIL_DISCOUNTAMOUNT]);
			salesItem.setDiscountPercent(itemSales[WsConstants.SIL_DISCOUNTPERCENT]);
			salesItem.setPrice(itemSales[WsConstants.SIL_PRICE]);
			salesItem.setProductDetailNumber(itemSales[WsConstants.SIL_PRODUCTDETAILNUMBER]);
			salesItem.setOriginalDocumentId(itemSales[WsConstants.SIL_ORIGINALDOCUMENTID]);
			salesItem.setOriginalDocumentKey(itemSales[WsConstants.SIL_ORIGINALDOCUMENTKEY]);
			salesItem.setManualDiscountType(itemSales[WsConstants.SIL_MANUALDISCOUNTTYPE]);
			salesItem.setManualDiscountAmount(itemSales[WsConstants.SIL_MANUALDISCOUNTAMOUNT]);
			salesItem.setManualDiscountPercent(itemSales[WsConstants.SIL_DISCOUNTPERCENT]);
			salesItem.setCouponDiscountAmount(itemSales[WsConstants.SIL_COUPONDISCOUNTAMOUNT]);
			salesItem.setUomId(itemSales[WsConstants.SIL_UOMID]);
			salesItem.setUomQuantity(itemSales[WsConstants.SIL_UOMQUANTITY]);
			salesItem.setUomBaseQuantity(itemSales[WsConstants.SIL_UOMBASEQUANTITY]);
			salesItem.setOriginalPrice(itemSales[WsConstants.SIL_ORIGINALPRICE]);
			/*
			salesItem.setCouponId(itemSales[WsConstants.SIL_CUOPONID]);
			salesItem.setiVendTransactionItemKey(itemSales[WsConstants.SIL_IVENDTRANSACTIONKEY]);
			salesItem.setTransactionItemId(itemSales[WsConstants.SIL_TRANSACTIONITEMID]);
			salesItem.setCouponSerialNumber(itemSales[WsConstants.SIL_CUOPONSERIALNUMBER]);
			salesItem.setProductReturnDetailNumber(itemSales[WsConstants.SIL_PRODUCTRETURNDETAILNUMBER]);
			*/
			salesList.add(salesItem);
		}

		allSales.setItems(salesList);

		return allSales;
	}

	@Override
	public Sales getSalesByTransaction(String key) throws Exception {

		return getAllSalesFromFile(key);
	}

	@Override
	public Sales getAllSales() throws Exception {
		return getAllSalesFromFile(null);
	}

}
