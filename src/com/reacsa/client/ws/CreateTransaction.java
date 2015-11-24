package com.reacsa.client.ws;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceRef;

import org.datacontract.schemas._2004._07.cxs_payments.AccountType;
import org.datacontract.schemas._2004._07.cxs_subsystem.PaymentDetailType;

import com.ivend.client.objects.PaymentItem;
import com.ivend.client.objects.Payments;
import com.ivend.client.objects.RefundItem;
import com.ivend.client.objects.Refunds;
import com.ivend.client.objects.Sales;
import com.ivend.client.objects.SalesItem;
import com.ivend.client.objects.TransactionItem;
import com.ivend.client.objects.Transactions;
import com.ivend.iintegrationservice._2010._12.ArrayOfPostTransactionItem;
import com.ivend.iintegrationservice._2010._12.ArrayOfTransactionPayment;
import com.ivend.iintegrationservice._2010._12.IIntegrationService;
import com.ivend.iintegrationservice._2010._12.IntegrationService;
import com.ivend.iintegrationservice._2010._12.ObjectFactory;
import com.ivend.iintegrationservice._2010._12.PostTransaction;
import com.ivend.iintegrationservice._2010._12.PostTransactionItem;
import com.ivend.iintegrationservice._2010._12.TransactionPayment;
import com.reacsa.utils.Utils;

public class CreateTransaction {
	
	Config cfg = new Config();
	Utils util = new Utils();
	
	//static String URL_WEBSERVICE = cfg.getStringProperty("url.webservice");
	
	@WebServiceRef(wsdlLocation = "http://10.0.1.8:8642/iVendAPI/iVendAPI.svc?wsdl")
	
	
	static private String fileName;
	
	public CreateTransaction(){
	
	}
	
	
	public void createTransactionStructure(Transactions transCollection){
		
		 try{
			 
			 List<TransactionItem> transactions = transCollection.getItems();
	 
			 for (TransactionItem transaction : transactions) {
				
			/*SaveTransaction*/
				IntegrationService is = new IntegrationService();
				IIntegrationService port = is.getPort(IIntegrationService.class);
				
				
				ObjectFactory factory = new ObjectFactory();		
					
			/*PostTransaction*/	
				PostTransaction pt = new PostTransaction();
				
				pt.setMessage(util.createJaxbElementString("Message", transaction.getMessage()));
				pt.setGenerateIntegrationEvent(transaction.getGenerateEnterpriseEvent());
				
				pt.setEnterpriseName(util.createJaxbElementString("EnterpriseName", transaction.getEnterpriseName()));

				pt.setUserFieldsList(null);
				
				pt.setStoreId(transaction.getStoreId());
				pt.setPOSId(transaction.getPosId());
				pt.setUserId(transaction.getUserId());
				
				pt.setTransactionDate(util.createXmlGregorianCalendar(transaction.getTransactionDate(), "dd/MM/yyyy"));
				pt.setBusinessDate(util.createXmlGregorianCalendar(transaction.getBusinessDate(), "dd/MM/yyyy"));
				
				pt.setTransactionId(util.createJaxbElementString("TransactionId", transaction.getTransactionId()));
				
				pt.setCustomerId(transaction.getCustomerId());
				
				pt.setContactId(util.createJaxbElementString("ContactId", transaction.getContactId()));
				
				pt.setDiscountType(util.createDiscountType(transaction.getDiscountType()));
				
				pt.setDiscountAmount(util.convertToBigDecimal(transaction.getDiscountAmount()));
				
				
				/*TODO: Checar si hay regla para validar entrada a ventas o devoluciones */
				
				/*SaleItemList*/
				Sales SalesItemList = transaction.getSalesItems();
				ArrayOfPostTransactionItem arrayPostTransactionSales = new ArrayOfPostTransactionItem();
				
				if( SalesItemList.getItems().size() > 0){
				
					for (SalesItem salesItem : SalesItemList.getItems()) {
						/*PostTransactionItem pt*/
						PostTransactionItem pti = new PostTransactionItem();
						
						pti.setMessage(util.createJaxbElementString("Message",salesItem.getMessage()));
						
						pti.setGenerateIntegrationEvent(salesItem.getGenerateEnterpriseEvent());
						
						pti.setEnterpriseName(util.createJaxbElementString("EnterpriseName", salesItem.getEnterpriseName()));
						
						pti.setProductId(salesItem.getProductId());
						
						pti.setDescription(salesItem.getDescription());
						
						pti.setTaxCodeId(salesItem.getTaxCodeId());
						
						pti.setQuantity(util.convertToBigDecimal(salesItem.getQuantity()));
						
						pti.setDiscountType(util.createDiscountType(salesItem.getDiscountType()));
						
						pti.setDiscountAmount(util.convertToBigDecimal(salesItem.getDiscountAmount()));
						
						pti.setDiscountPercent(util.convertToBigDecimal(salesItem.getDiscountPercent()));
						
						pti.setPrice(util.convertToBigDecimal(salesItem.getPrice()));
						
						pti.setProductDetailNumber(util.createJaxbElementString("ProductDetailNumber", salesItem.getProductDetailNumber()));
						
						pti.setOriginalDocumentId(util.createJaxbElementString("OriginalDocumentId", salesItem.getOriginalDocumentId()));
						
						pti.setSurchargeTotal(util.convertToBigDecimal(salesItem.getSurchargeTotal()));
						
						pti.setOriginalDocumentKey(util.convertToLong(salesItem.getOriginalDocumentKey()));
						
						pti.setOriginalDetailKey(util.convertToLong(salesItem.getOriginalDetailKey()));
						
						pti.setManualDiscountType(util.createDiscountType(salesItem.getDiscountType()));
						
						pti.setManualDiscountAmount(util.convertToBigDecimal(salesItem.getManualDiscountAmount()));
						
						pti.setManualDiscountPercent(util.convertToBigDecimal(salesItem.getManualDiscountPercent()));
						
						pti.setCouponDiscountAmount(util.convertToBigDecimal(salesItem.getCouponDiscountAmount()));
						
						pti.setPromotionalDiscountAmount(util.convertToBigDecimal(salesItem.getPromotionalDiscountAmount()));
						
						pti.setUOMQuantity(util.convertToBigDecimal(salesItem.getUomQuantity()));
						
						pti.setUOMBaseQuantity(util.convertToBigDecimal(salesItem.getUomBaseQuantity()));
						
						pti.setUOMId(util.createJaxbElementString("UOMid", salesItem.getUomId()));
						
						pti.setOriginalPrice(util.convertToBigDecimal(salesItem.getOriginalPrice()));
						
						//pti.setCouponId(util.createJaxbElementString("CouponId", salesItem.getCouponId()));
						
						//pti.setIVendTransactionItemKey(util.convertToLong(salesItem.getiVendTransactionItemKey()));
						
						//pti.setTransactionItemId(util.createJaxbElementString("TransactionItemId", salesItem.getTransactionItemId()));
						
						///pti.setCouponSerialNumber(util.createJaxbElementString("Coupon", salesItem.getCouponSerialNumber()));
						
						//pti.setProductReturnDetailNumber(util.createJaxbElementString("ProducReturnDetailNumber", salesItem.getProductReturnDetailNumber()));
						
							arrayPostTransactionSales.getPostTransactionItems().add(pti);
						}
								
						QName fooQNameSales = new QName("http://www.iVend.com/IIntegrationService/2010/12", "SaleItemList");
						JAXBElement<ArrayOfPostTransactionItem> sale = new JAXBElement<ArrayOfPostTransactionItem>(fooQNameSales, ArrayOfPostTransactionItem.class, arrayPostTransactionSales);					
						pt.setSaleItemList(sale);
					
					}
					
					
					/*RefundItemList*/
					Refunds refundsItemList = transaction.getRefundItems();
					
					ArrayOfPostTransactionItem arrayPostTransactionRefunds = new ArrayOfPostTransactionItem();
					
					if ( refundsItemList.getItems().size() > 0){ 
						
					for (RefundItem refundsItem : refundsItemList.getItems()) {
						/*PostTransactionItem pt*/
						PostTransactionItem pti = new PostTransactionItem();
						pti.setMessage(util.createJaxbElementString("Message",refundsItem.getMessage()));
						
						
						pti.setProductId(refundsItem.getProductId());
						
						pti.setDescription(refundsItem.getDescription());
						
						pti.setTaxCodeId(refundsItem.getTaxCodeId());
						
						pti.setQuantity(util.convertToBigDecimal(refundsItem.getQuantity()));
						
						pti.setDiscountType(util.createDiscountType(refundsItem.getDiscountType()));
						
						pti.setDiscountAmount(util.convertToBigDecimal(refundsItem.getDiscountAmount()));
						
						pti.setDiscountPercent(util.convertToBigDecimal(refundsItem.getDiscountPercent()));
						
						pti.setPrice(util.convertToBigDecimal(refundsItem.getPrice()));
						
						pti.setProductDetailNumber(util.createJaxbElementString("ProductDetailNumber", refundsItem.getProductDetailNumber()));
						
						pti.setOriginalDocumentId(util.createJaxbElementString("OriginalDocumentId", refundsItem.getOriginalDocumentId()));
						
						pti.setSurchargeTotal(util.convertToBigDecimal(refundsItem.getSurchargeTotal()));
						
						pti.setOriginalDocumentKey(util.convertToLong(refundsItem.getOriginalDocumentKey()));
						
						pti.setOriginalDetailKey(util.convertToLong(refundsItem.getOriginalDetailKey()));
						
						pti.setManualDiscountType(util.createDiscountType(refundsItem.getDiscountType()));
						
						pti.setManualDiscountAmount(util.convertToBigDecimal(refundsItem.getManualDiscountAmount()));
						
						pti.setManualDiscountPercent(util.convertToBigDecimal(refundsItem.getManualDiscountPercent()));
						
						pti.setCouponDiscountAmount(util.convertToBigDecimal(refundsItem.getCouponDiscountAmount()));
						
						pti.setPromotionalDiscountAmount(util.convertToBigDecimal(refundsItem.getPromotionalDiscountAmount()));
						
						pti.setUOMQuantity(util.convertToBigDecimal(refundsItem.getUomQuantity()));
						
						pti.setUOMBaseQuantity(util.convertToBigDecimal(refundsItem.getUomBaseQuantity()));
						
						pti.setUOMId(util.createJaxbElementString("UOMid", refundsItem.getUomId()));
						
						pti.setOriginalPrice(util.convertToBigDecimal(refundsItem.getOriginalPrice()));
						
						//pti.setCouponId(util.createJaxbElementString("CouponId", refundsItem.getCouponId()));
						
						//pti.setIVendTransactionItemKey(util.convertToLong(refundsItem.getiVendTransactionItemKey()));
						
						//pti.setTransactionItemId(util.createJaxbElementString("TransactionItemId", refundsItem.getTransactionItemId()));
						
						//pti.setCouponSerialNumber(util.createJaxbElementString("Coupon", refundsItem.getCouponSerialNumber()));
						
						//pti.setProductReturnDetailNumber(util.createJaxbElementString("ProductReturnDetailNumber", refundsItem.getProductReturnDetailNumber()));
						
							arrayPostTransactionRefunds.getPostTransactionItems().add(pti);
						}
					
						QName fooQNameRefunds = new QName("http://www.iVend.com/IIntegrationService/2010/12", "RefundItemList");
						JAXBElement<ArrayOfPostTransactionItem> refund = new JAXBElement<ArrayOfPostTransactionItem>(fooQNameRefunds, ArrayOfPostTransactionItem.class, arrayPostTransactionRefunds);					
						pt.setRefundItemList(refund);
					}
					
					
					
					/*Payments*/
					
					Payments payments = transaction.getPayments();
			
					ArrayOfTransactionPayment arrayTransactionPayments = new ArrayOfTransactionPayment();
					
					if (payments.getItems().size() > 0) {
					
					for (PaymentItem paymentItem : payments.getItems()) {
						
						/*PostTransactionItem pt*/
						TransactionPayment tp = new TransactionPayment();
						
						
						tp.setMessage(util.createJaxbElementString("Message",paymentItem.getMessage()));
						
						tp.setGenerateIntegrationEvent(paymentItem.getGenerateEnterpriseEvent());
						
						tp.setEnterpriseName(util.createJaxbElementString("EnterpriseName",paymentItem.getEnterpriseName()));
						
						tp.setUserFieldsList(null);
						
						tp.setTransactionKey(util.convertToLong(paymentItem.getTransactionKey()));
						
						tp.setPaymentTypeId(paymentItem.getPaymentTypeId());
						
						tp.setTenderType(util.createTenderType(paymentItem.getTenderType()));
						
						tp.setDetailKey(util.convertToLong(paymentItem.getDetailKey()));
						
						tp.setDetailType(PaymentDetailType.fromValue(paymentItem.getDetailType()));
						
						tp.setAmount(util.convertToBigDecimal(paymentItem.getAmount()));
						
						tp.setChangeAmount(null);
						tp.setForeignCurrencyChangeAmount(null);
						tp.setCashBackAmount(null);
						tp.setRoundingAmount(null);
						tp.setAccountNumber(null);
						tp.setCardNumber(null);
						tp.setName(null);
						tp.setExpirationDate(null);
						tp.setZipCode(null);
						
						System.out.println(paymentItem.getTransactionKey());						
						tp.setAccountType(AccountType.fromValue(paymentItem.getAccountType()));
						
						tp.setAddress(null);
						tp.setCity(null);
						tp.setState(null);
						
						
						tp.setCurrencyId(util.createJaxbElementString("CurrencyId", paymentItem.getCurrencyId()));
						
						tp.setIsVoided(false);
						
						tp.setHasAuthorization(null);
						tp.setHasCardSwipe(null);
						tp.setAuthorizationCode(null);
						tp.setPaymentReferenceNumber(null);
						tp.setOriginalReferenceNumber(null);
						tp.setRefunded(null);
						tp.setForeignCurrencyAmount(null);
						tp.setExchangeRate(null);
						tp.setIsStoreCredit(null);
						tp.setGiftCertificateType(null);
						tp.setSignature(null);
						tp.setExchangeRateKey(null);
						tp.setPaymentAttributes(null);
						tp.setDiscountAmount(null);
						tp.setSurchargeAmount(null);
						tp.setNetPayableAmount(null);
						tp.setHasSurcharge(null);
						
						
						tp.setPaidAmount(util.convertToBigDecimal(paymentItem.getPaidAmount()));
						
						tp.setSurchargeKey(null);
						tp.setSurchargeId(null);
				
						arrayTransactionPayments.getTransactionPayments().add(tp);
						
						}
								
						QName fooQNamePayments = new QName("http://www.iVend.com/IIntegrationService/2010/12", "Payments");
						JAXBElement<ArrayOfTransactionPayment> payment = new JAXBElement<ArrayOfTransactionPayment>(fooQNamePayments, ArrayOfTransactionPayment.class, arrayTransactionPayments);
						
						pt.setPayments(payment);
					
					}
									
					/*Save Transaction*/
					PostTransaction result = port.saveTransaction(pt);
					System.out.println("Restult : " + result.getMessage().getValue());
					System.out.println("iVendKey: " +  result.getIVendTransactionKey().intValue());
		
					/*Generate XML*/
					
					fileName = "SaveTransaction_" + pt.getCustomerId() +".xml";
					
					util.generateXML(factory, pt, fileName);
			 }
			 
		  }catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
	}
	
	
	
}
