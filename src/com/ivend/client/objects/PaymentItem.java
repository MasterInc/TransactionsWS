package com.ivend.client.objects;

public class PaymentItem {

	String UID;
	 String message;
	 boolean generateEnterpriseEvent;
	 String enterpriseName ;
	 
	 String userFieldList ;
	 String transactionKey ;
	 String paymentTypeId ;
	 String tenderType ;
	 String detailKey ;
	 String detailType ;
	 String amount ;
	 String paidAmount ;
	 String accountType ;
	 String currencyId ;
	 String isVoided ;
	 
	 
	 
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
	 public String getTransactionKey() {
	  return transactionKey;
	 }
	 public void setTransactionKey(String transactionKey) {
	  this.transactionKey = transactionKey;
	 }
	 public String getPaymentTypeId() {
	  return paymentTypeId;
	 }
	 public void setPaymentTypeId(String paymentTypeId) {
	  this.paymentTypeId = paymentTypeId;
	 }
	 public String getTenderType() {
	  return tenderType;
	 }
	 public void setTenderType(String tenderType) {
	  this.tenderType = tenderType;
	 }
	 public String getDetailKey() {
	  return detailKey;
	 }
	 public void setDetailKey(String detailKey) {
	  this.detailKey = detailKey;
	 }
	 public String getDetailType() {
	  return detailType;
	 }
	 public void setDetailType(String detailType) {
	  this.detailType = detailType;
	 }
	 public String getAmount() {
	  return amount;
	 }
	 public void setAmount(String amount) {
	  this.amount = amount;
	 }
	 public String getPaidAmount() {
	  return paidAmount;
	 }
	 public void setPaidAmount(String paidAmount) {
	  this.paidAmount = paidAmount;
	 }
	 public String getAccountType() {
	  return accountType;
	 }
	 public void setAccountType(String accountType) {
	  this.accountType = accountType;
	 }
	 public String getCurrencyId() {
	  return currencyId;
	 }
	 public void setCurrencyId(String currencyId) {
	  this.currencyId = currencyId;
	 }
	 public String getIsVoided() {
	  return isVoided;
	 }
	 public void setIsVoided(String isVoided) {
	  this.isVoided = isVoided;
	 }
	

}
