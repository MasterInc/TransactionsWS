package com.ivend.client.objects;

public class TransactionItem {

	String UID;
	String message;
	boolean generateEnterpriseEvent;
    String enterpriseName;
    String userFieldList;
	String storeId ;
	String posId ;
	String userId ;
	String transactionDate ;
	String businessDate ;
	String transactionId ;
	String customerId ;
	String contactId ;
	String discountType ;
	String discountAmount ;
	String discountPercent ;

	
	Sales salesItems;
	Refunds refundItems;
	Payments payments;
	
	

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getGenerateEnterpriseEvent() {
		return generateEnterpriseEvent;
	}

	public void setGenerateEnterpriseEvent(boolean generateEnterpriseEvent) {
		this.generateEnterpriseEvent = generateEnterpriseEvent;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getPosId() {
		return posId;
	}

	public void setPosId(String posId) {
		this.posId = posId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getBusinessDate() {
		return businessDate;
	}

	public void setBusinessDate(String businessDate) {
		this.businessDate = businessDate;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public String getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(String discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	
	public Sales getSalesItems() {
		return salesItems;
	}

	public void setSalesItems(Sales salesItems) {
		this.salesItems = salesItems;
	}

	public Refunds getRefundItems() {
		return refundItems;
	}

	public void setRefundItems(Refunds refundItems) {
		this.refundItems = refundItems;
	}

	public Payments getPayments() {
		return payments;
	}

	public void setPayments(Payments payments) {
		this.payments = payments;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getUserFieldList() {
		return userFieldList;
	}

	public void setUserFieldList(String userFieldList) {
		this.userFieldList = userFieldList;
	}


}
