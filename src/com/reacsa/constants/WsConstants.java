package com.reacsa.constants;

public final class WsConstants {
	
	//private WsConstants(){}

	public static String QNAME ="http://www.iVend.com/IIntegrationService/2010/12";
	public static String DATE_FORMAT = "dd/MMM/yyyy";
	
    public static String CONF = "";
  
	public static String TRANSACTION_ROW = "PTR";
	public static String SALES_ROW = "SIL";
	public static String REFUND_ROW = "RIL";
	public static String PAYENT_ROW = "PYMT";
	
    public static String TRANSACTION_FILENAME = "transactions.file";
	public static String PAYMENTS_FILENAME = "payments.file";
	public static String REFUNDS_FILENAME = "refunds.file";
	public static String SALES_FILENAME = "sales.file";
	public static String FILE_PATH = "file.path.load";
	public static String SEPARATOR = "file.line.separator";
	public static String URL_WEBSERVICE = "url.webservice";
	public static String FILE_PATH_SAVE_XML = "file.path.savexml";

    public static int ROWTYPE = 0;
    public static int UID = 1;
    public static int MESSAGE = 2;
    public static int GENERATEINTEGRATIONEVENT = 3;
    public static int ENTERPRISENAME =4;
    public static int USERFIELDLIST = 5;
    public static int STOREID =6;
    public static int POSID =7;
    public static int USERID =8;
    public static int TRANSACTIONDATE =9;
    public static int BUSINESSDATE =10;
    public static int TRANSACTIONID =11;
    public static int CUSTOMERID =12;
    public static int CONTACTID =13;
    public static int DISCOUNTTYPE =14;
    public static int DISCOUNTAMOUNT =15;
    public static int DISCOUNTPERCENT =16;
    
    public static int SIL_ROWTYPE =0;
    public static int SIL_PTR_UID =1;
    public static int SIL_MESSAGE =2;
    public static int SIL_GENERATEINTEGRATIONEVENT =3;
    public static int SIL_ENTERPRISENAME =4;
    public static int SIL_PRODUCTID =5;
    public static int SIL_DESCRIPTION =6;
    public static int SIL_TAXCODEID =7;
    public static int SIL_QUANTITY =8;
    public static int SIL_DISCOUNTTYPE =9;
    public static int SIL_DISCOUNTAMOUNT =10;
    public static int SIL_DISCOUNTPERCENT =11;
    public static int SIL_PRICE =12;
    public static int SIL_PRODUCTDETAILNUMBER =13;
    public static int SIL_ORIGINALDOCUMENTID =14;
    public static int SIL_SURCHARGETOTAL =15;
    public static int SIL_ORIGINALDOCUMENTKEY =16;
    public static int SIL_ORIGINALDETAILKEY =17;
    public static int SIL_MANUALDISCOUNTTYPE =18;
    public static int SIL_MANUALDISCOUNTAMOUNT =19;
    public static int SIL_MANUALDISCOUNTPERCENT =20;
    public static int SIL_COUPONDISCOUNTAMOUNT =21;
    public static int SIL_PROMOTIONALDISCOUNTAMOUNT =22;
    public static int SIL_UOMQUANTITY =23;
    public static int SIL_UOMBASEQUANTITY =24;
    public static int SIL_UOMID =25;
    public static int SIL_ORIGINALPRICE =26;
    public static int SIL_CUOPONID =27;
    public static int SIL_IVENDTRANSACTIONKEY =28;
    public static int SIL_TRANSACTIONITEMID =29;
    public static int SIL_CUOPONSERIALNUMBER =30;
    public static int SIL_PRODUCTRETURNDETAILNUMBER =31;
	
    public static int RIL_ROWTYPE =0;
    public static int RIL_PTR_UID =1;
    public static int RIL_MESSAGE =2;
    public static int RIL_GENERATEINTEGRATIONEVENT =3;
    public static int RIL_ENTERPRISENAME =4;
    public static int RIL_PRODUCTID =5;
    public static int RIL_DESCRIPTION =6;
    public static int RIL_TAXCODEID =7;
    public static int RIL_QUANTITY =8;
    public static int RIL_DISCOUNTTYPE =9;
    public static int RIL_DISCOUNTAMOUNT =10;
    public static int RIL_DISCOUNTPERCENT =11;
    public static int RIL_PRICE =12;
    public static int RIL_PRODUCTDETAILNUMBER =13;
    public static int RIL_ORIGINALDOCUMENTID =14;
    public static int RIL_SURCHARGETOTAL =15;
    public static int RIL_ORIGINALDOCUMENTKEY =16;
    public static int RIL_ORIGINALDETAILKEY =17;
    public static int RIL_MANUALDISCOUNTTYPE =16;
    public static int RIL_MANUALDISCOUNTAMOUNT =19;
    public static int RIL_MANUALDISCOUNTPERCENT =20;
    public static int RIL_COUPONDISCOUNTAMOUNT =21;
    public static int RIL_PROMOTIONALDISCOUNTAMOUNT =22;
    public static int RIL_UOMQUANTITY =23;
    public static int RIL_UOMBASEQUANTITY =24;
    public static int RIL_UOMID =25;
    public static int RIL_ORIGINALPRICE =26;
    public static int RIL_CUOPONID =27;
    public static int RIL_IVENDTRANSACTIONKEY =28;
    public static int RIL_TRANSACTIONITEMID =29;
    public static int RIL_CUOPONSERIALNUMBER =30;
    public static int RIL_PRODUCTRETURNDETAILNUMBER =31;
    
    public static int PYMT_ROWTYPE=0;
    public static int PYMT_PTR_UID =1;
    public static int PYMT_MESSAGE =2;
    public static int PYMT_GENERATEINTEGRATIONEVENT =3;
    public static int PYMT_ENTERPRISENAME =4;
    public static int PYMT_USERFIELDLIST =5;
    public static int PYMT_TRANSACTIONKEY =6;
    public static int PYMT_PAYMENTTYPEID =7;
    public static int PYMT_TENDERTYPE =8;
    public static int PYMT_DETAILKEY =9;
    public static int PYMT_DETAILTYPE =10;
    public static int PYMT_AMOUNT =11;
    public static int PYMT_PAIDAMOUNT =12;
    public static int PYMT_ACCOUNTTYPE =13;
    public static int PYMT_CURRENCYID =14;
    public static int PYMT_ISVOIDED =15;

}
