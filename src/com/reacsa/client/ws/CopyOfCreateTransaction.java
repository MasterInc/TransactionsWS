package com.reacsa.client.ws;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.datacontract.schemas._2004._07.cxs_payments.AccountType;
import org.datacontract.schemas._2004._07.cxs_platform.DiscountType;
import org.datacontract.schemas._2004._07.cxs_subsystem.PaymentDetailType;
import org.datacontract.schemas._2004._07.cxs_subsystem.TenderType;

import com.ivend.client.objects.TransactionItem;
import com.ivend.client.objects.Transactions;
import com.ivend.iintegrationservice._2010._12.ArrayOfPostTransactionItem;
import com.ivend.iintegrationservice._2010._12.ArrayOfPostTransactionLineItemAttribute;
import com.ivend.iintegrationservice._2010._12.ArrayOfTransactionPayment;
import com.ivend.iintegrationservice._2010._12.IIntegrationService;
import com.ivend.iintegrationservice._2010._12.IntegrationService;
import com.ivend.iintegrationservice._2010._12.ObjectFactory;
import com.ivend.iintegrationservice._2010._12.PostTransaction;
import com.ivend.iintegrationservice._2010._12.PostTransactionItem;
import com.ivend.iintegrationservice._2010._12.PostTransactionLineItemAttribute;
import com.ivend.iintegrationservice._2010._12.SaveTransaction;
import com.ivend.iintegrationservice._2010._12.Transaction;
import com.ivend.iintegrationservice._2010._12.TransactionPayment;
import com.reacsa.utils.Utils;

public class CopyOfCreateTransaction {
	
	
	Utils util = new Utils();
	public CopyOfCreateTransaction(){
	
	}
	
	
	public void createTransaction(Transactions transCollection){
			
		 try{
			 
		 List<TransactionItem> transactions = transCollection.getItems();
 
		 for (TransactionItem transaction : transactions) {
			
		 
			IntegrationService is = new IntegrationService();
			IIntegrationService port = is.getPort(IIntegrationService.class);
			
			
			ObjectFactory factory = new ObjectFactory();		
				
			
			PostTransaction pt = new PostTransaction();
			
			pt.setMessage(util.createJaxbElementString("Message", transaction.getMessage()));
	
			pt.setGenerateIntegrationEvent(transaction.getGenerateEnterpriseEvent());
			
			//JAXBElement<String> enterpriseName = factory.createEnterpriseCompanyName("Refrigeración y Accesorios, S.A. de C.V");
			pt.setEnterpriseName(util.createJaxbElementString("EnterpriseName", transaction.getEnterpriseName()));
		
			//pt.setUserFieldsList(transaction.getUserFieldList());
			pt.setStoreId("0100");
			pt.setPOSId("0100M");
			pt.setUserId("CAJA1");
			
			
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(new Date());
			XMLGregorianCalendar transDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
			pt.setTransactionDate(transDate);
			
			pt.setBusinessDate(transDate);
			
			QName fooQName = new QName("http://www.iVend.com/IIntegrationService/2010/12", "TransactionId");
			JAXBElement<String> transId = new JAXBElement<String>(fooQName,String.class, "MiTransaccion01");
			pt.setTransactionId(transId);
			
			
			
			QName fooQName2 = new QName("http://www.iVend.com/IIntegrationService/2010/12", "CustomerRefNumber");
			JAXBElement<String> custRefNumber = new JAXBElement<String>(fooQName2,String.class, "MXN_16.58480_Contado_0100|0101");
			pt.setCustomerRefNumber(custRefNumber);
			
			pt.setCustomerId("0001000005");
			
			QName fooQNameContactId = new QName("http://www.iVend.com/IIntegrationService/2010/12", "ContactId");
			JAXBElement<String> contactId = new JAXBElement<String>(fooQNameContactId,String.class, "REFACCION TOLUCA");;
			pt.setContactId(contactId );
			
			pt.setDiscountType(DiscountType.NONE);
			pt.setDiscountAmount(new BigDecimal(0.00));
			pt.setDiscountPercent(new BigDecimal(0.00));
			pt.setSubTotal(new BigDecimal(100.00));
			pt.setTotal(new BigDecimal(116.00));
			pt.setComment(null);
			
			pt.setIsSuspended(false);
			pt.setValidate(true);
			
			
			//QName fooQName00 = new QName("http://www.iVend.com/IIntegrationService/2010/12", "LayawayPlanId");
			//JAXBElement<String> layAwayPlanId = new JAXBElement<String>(fooQName00,String.class, "0");
			pt.setLayawayPlanId(null);
			
			pt.setLayawayAdvanceAmount(new BigDecimal(0));
			pt.setPayableAmount(new BigDecimal(116.00));
			pt.setTotalTaxableAmount(new BigDecimal(100.00));
						
			/*TransactionItemList*/
			PostTransactionItem pti = new PostTransactionItem();
			
			pti.setMessage(null);
			pti.setGenerateIntegrationEvent(true);
			pti.setEnterpriseName(null);
			
			pti.setProductId("AC001");
			pti.setDescription("AIRE ACONDICIONADO C40 modificacion 2");
			pti.setTaxCodeId("V3");
			pti.setQuantity(new BigDecimal(1.00));
			pti.setTaxRate(new BigDecimal(16.00));
			
			pti.setTax(new BigDecimal(16.00));
			pti.setSubTotal(new BigDecimal(100.00));
			pti.setTotal(new BigDecimal(116.00));
			pti.setDiscountType(DiscountType.NONE);
			pti.setDiscountAmount(new BigDecimal(0.00));
			pti.setDiscountPercent(new BigDecimal(0.00));
			pti.setPrice(new BigDecimal(100.00));
			
			
			
			QName fooQName4 = new QName("http://www.iVend.com/IIntegrationService/2010/12", "ProductDetailNumber");
			JAXBElement<String> productDetailNumber = new JAXBElement<String>(fooQName4,String.class, "1111-01");;
			pti.setProductDetailNumber(productDetailNumber );
			
			QName fooQName5 = new QName("http://www.iVend.com/IIntegrationService/2010/12", "OriginalDocumentId");
			JAXBElement<String> originalDocId = new JAXBElement<String>(fooQName5,String.class, "0");;
			pti.setOriginalDocumentId(originalDocId );
						
			pti.setSurchargeTotal(new BigDecimal(0.00));
			pti.setOriginalDocumentKey(new Long("0"));
			pti.setOriginalDetailKey(new Long("0"));
			pti.setSurchargeList(null);
			pti.setManualDiscountType(DiscountType.NONE);
			pti.setManualDiscountAmount(new BigDecimal(0.00));
			pti.setManualDiscountPercent(new BigDecimal(0.00));
			pti.setCouponDiscountAmount(new BigDecimal(0.00));
			pti.setPromotionalDiscountAmount(new BigDecimal(0));
			pti.setSalesPerson(null);
			pti.setUOMQuantity(new BigDecimal(1.00));
			pti.setUOMBaseQuantity(new BigDecimal(1.00));
			
			
			QName fooQName6 = new QName("http://www.iVend.com/IIntegrationService/2010/12", "UOMId");
			JAXBElement<String> uomId = new JAXBElement<String>(fooQName6,String.class, "PI");;
			pti.setUOMId(uomId );
			
			pti.setOriginalPrice(new BigDecimal(100.00));
			
			
			/*
			PostTransactionLineItemAttribute ptlia = new PostTransactionLineItemAttribute();
			
			ptlia.setMessage(null);
			ptlia.setGenerateIntegrationEvent(false);
			ptlia.setEnterpriseName(null);
			ptlia.setUserFieldsList(null);
			ptlia.setAttributeValue(null);
			ptlia.setItemAttributeKey(60000000000001L);
			
			
			QName fooQName7 = new QName("http://www.iVend.com/IIntegrationService/2010/12", "ItemAttributeName");
			JAXBElement<String> itemAttrName= new JAXBElement<String>(fooQName7,String.class, "Precio USD");
			ptlia.setItemAttributeName(itemAttrName);
			
			ptlia.setSource(new Integer("0"));
			ptlia.setSourceKey(60000000000398L);
			
			
		     ArrayOfPostTransactionLineItemAttribute posTransLineItemAttr = new ArrayOfPostTransactionLineItemAttribute();
		     posTransLineItemAttr.getPostTransactionLineItemAttributes().add(ptlia);
		    
		     QName fooQNameTLI = new QName("http://www.iVend.com/IIntegrationService/2010/12", "TransactionLineItemAttributes");
		     JAXBElement<ArrayOfPostTransactionLineItemAttribute> transLineItemAttr = 
		         new JAXBElement<ArrayOfPostTransactionLineItemAttribute>(fooQNameTLI, ArrayOfPostTransactionLineItemAttribute.class, posTransLineItemAttr);
		     
			 pti.setTransactionLineItemAttributes(transLineItemAttr );
			
			
			ArrayOfPostTransactionItem apti = new ArrayOfPostTransactionItem();
			apti.getPostTransactionItems().add(pti);
			QName fooQNameSIL = new QName("http://www.iVend.com/IIntegrationService/2010/12", "SaleItemList");
			JAXBElement<ArrayOfPostTransactionItem> saleItemList =  new JAXBElement<ArrayOfPostTransactionItem>(fooQNameSIL, ArrayOfPostTransactionItem.class, apti);
			pt.setSaleItemList(saleItemList);
			*/
			/*
			PostTransactionSaleAttribute ptsaNombre = new PostTransactionSaleAttribute();
			
			ptsaNombre.setMessage(null);
			ptsaNombre.setGenerateIntegrationEvent(true);
			ptsaNombre.setEnterpriseName(null);
			ptsaNombre.setUserFieldsList(null);
			
			
			QName fooQName8 = new QName("http://www.iVend.com/IIntegrationService/2010/12", "AttributeValue");
			JAXBElement<String> attrValue = new JAXBElement<String>(fooQName8,String.class, "323223");
			ptsaNombre.setAttributeValue(attrValue);
			
			ptsaNombre.setSaleAttributeKey(50000000000001L);
			
			QName fooQName9 = new QName("http://www.iVend.com/IIntegrationService/2010/12", "SaleAttributeName");
			JAXBElement<String> saleAttrName = new JAXBElement<String>(fooQName9,String.class, "Nombre");
			ptsaNombre.setSaleAttributeName(saleAttrName);
		
			PostTransactionSaleAttribute ptsaTel = new PostTransactionSaleAttribute();
			
			ptsaTel.setMessage(null);
			ptsaTel.setGenerateIntegrationEvent(true);
			ptsaTel.setEnterpriseName(null);
			ptsaTel.setUserFieldsList(null);
			
			QName fooQName10 = new QName("http://www.iVend.com/IIntegrationService/2010/12", "AttributeValue");
			JAXBElement<String> attrValueTel = new JAXBElement<String>(fooQName10,String.class, "32322333");
			ptsaTel.setAttributeValue(attrValueTel);
			
			ptsaTel.setSaleAttributeKey(50000000000002L);
			
			QName fooQName11 = new QName("http://www.iVend.com/IIntegrationService/2010/12", "SaleAttributeName");
			JAXBElement<String> saleAttrNombreTel = new JAXBElement<String>(fooQName11,String.class, "Telefono");
			ptsaTel.setSaleAttributeName(saleAttrNombreTel);
			
		
			ArrayOfPostTransactionSaleAttribute postTransSaleAttr = new ArrayOfPostTransactionSaleAttribute();
			postTransSaleAttr.getPostTransactionSaleAttributes().add(ptsaNombre);
			postTransSaleAttr.getPostTransactionSaleAttributes().add(ptsaTel);
			
			
			QName fooQNameAPTS = new QName("http://www.iVend.com/IIntegrationService/2010/12", "TransactionSaleAttributes");
			JAXBElement<ArrayOfPostTransactionSaleAttribute> transSaleAttr = new JAXBElement<ArrayOfPostTransactionSaleAttribute>(fooQNameAPTS, ArrayOfPostTransactionSaleAttribute.class, postTransSaleAttr);
			pt.setTransactionSaleAttributes(transSaleAttr);
		    */
			
			pt.setPOSDocumentNumberSeriesKey(null);
			pt.setCurrentNumberOfSeries(null);
			pt.setUpdateCurrentNumberOfSeries(null);
			pt.setGiftCertificateList(null);
			pt.setHasDiscountOverride(true);
			pt.setSalesOrderAdvanceAmount(null);
			pt.setLoyaltyId(null);
			pt.setCouponId(null);
			pt.setTax(new BigDecimal(16.00));
			
			pt.setSalesPerson(null);
			pt.setIVendTransactionKey(null);
			pt.setHasPromotionDiscount(null);
			pt.setSurchargeList(null);
			
			
			TransactionPayment tp = new TransactionPayment();
			
			tp.setMessage(null);
			tp.setGenerateIntegrationEvent(false);
			tp.setEnterpriseName(null);
			tp.setUserFieldsList(null);
			
			long transactionKey = 60000000000432L;
			tp.setTransactionKey(transactionKey );
			
			tp.setPaymentTypeId("EFECTIVO");
			
			tp.setTenderType(TenderType.CASH);
			tp.setDetailKey(new Long(0));
			tp.setDetailType(PaymentDetailType.NONE);
			tp.setAmount(new BigDecimal(100.00));
			tp.setChangeAmount(new BigDecimal(0.00));
			tp.setForeignCurrencyChangeAmount(new BigDecimal(0.00));
			tp.setCashBackAmount(new BigDecimal(0.00));
			tp.setRoundingAmount(new BigDecimal(0.00));
			
			tp.setAccountNumber(null);
			tp.setCardNumber(null);
			tp.setName(null);
			tp.setExpirationDate(null);
			tp.setZipCode(null);
			tp.setAccountType(AccountType.OTHERS);
			tp.setAddress(null);
			tp.setCity(null);
			tp.setState(null);
			
			
			QName fooQName12 = new QName("http://www.iVend.com/IIntegrationService/2010/12", "CurrencyId");
			JAXBElement<String> currencyId = new JAXBElement<String>(fooQName12,String.class, "MXN");
			tp.setCurrencyId(currencyId);
			
			tp.setIsVoided(false);
			tp.setHasAuthorization(false);
			tp.setHasCardSwipe(false);
			tp.setAuthorizationCode(null);
			tp.setPaymentReferenceNumber(null);
			tp.setRefunded(false);
			tp.setForeignCurrencyAmount(new BigDecimal(0.00));
			tp.setExchangeRate(new BigDecimal(0.00));
			tp.setIsStoreCredit(false);
			tp.setGiftCertificateType(null);
			tp.setSignature(null);
			tp.setExchangeRateKey(new Long(0));
			tp.setPaymentAttributes(null);
			tp.setDiscountAmount(new BigDecimal(0.00));
			tp.setSurchargeAmount(new BigDecimal(0.00));
			tp.setNetPayableAmount(new BigDecimal(0.00));
			tp.setHasSurcharge(false);
			tp.setPaidAmount(new BigDecimal(116.00));
			tp.setSurchargeKey(new Long(0));
			tp.setSurchargeId(null);
			

			ArrayOfTransactionPayment arrayTransactionPayments = new ArrayOfTransactionPayment();
			arrayTransactionPayments.getTransactionPayments().add(tp);
			
			
			QName fooQNamePayments = new QName("http://www.iVend.com/IIntegrationService/2010/12", "Payments");
			JAXBElement<ArrayOfTransactionPayment> payments = new JAXBElement<ArrayOfTransactionPayment>(fooQNamePayments, ArrayOfTransactionPayment.class, arrayTransactionPayments);
			
			pt.setPayments(payments);
			
		
			PostTransaction result = port.saveTransaction(pt);
			System.out.println("Restult : " + result.getMessage().getValue());
			System.out.println("iVendKey: " +  result.getIVendTransactionKey().intValue());
			
		  
			
			/*Crea XML*/
			
			System.out.println("Generating XML...");
			
			JAXBContext context = JAXBContext.newInstance(SaveTransaction.class);
			
			SaveTransaction ts = factory.createSaveTransaction();
			QName fooQNameTransaction = new QName("http://www.iVend.com/IIntegrationService/2010/12", "Transaction");
			JAXBElement<PostTransaction> postTrans = new JAXBElement<PostTransaction>(fooQNameTransaction,PostTransaction.class,pt);
			ts.setTransaction(postTrans);
			
			
			 Marshaller m = context.createMarshaller();
			 m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			 m.marshal(ts, new File("C:/Temp/SaveTransaction.xml"));
		
		  }
			 
		  }catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
    }
	
	
	public void createTransactionStructure(Transactions transCollection){
		
		 try{
			 
			 List<TransactionItem> transactions = transCollection.getItems();
	 
			 for (TransactionItem transaction : transactions) {
				
			 
				IntegrationService is = new IntegrationService();
				IIntegrationService port = is.getPort(IIntegrationService.class);
				
				
				ObjectFactory factory = new ObjectFactory();		
					
				
				PostTransaction pt = new PostTransaction();
				
				pt.setMessage(util.createJaxbElementString("Message", transaction.getMessage()));
		
			 }
			 
		  }catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
	}
	
	
	
}
