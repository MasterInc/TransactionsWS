
package com.ivend.iintegrationservice._2010._12;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "APIException", targetNamespace = "http://www.iVend.com/IIntegrationService/2010/12")
public class IIntegrationServiceGetWarehouseAPIExceptionFaultFaultMessage
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private APIException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public IIntegrationServiceGetWarehouseAPIExceptionFaultFaultMessage(String message, APIException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public IIntegrationServiceGetWarehouseAPIExceptionFaultFaultMessage(String message, APIException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.ivend.iintegrationservice._2010._12.APIException
     */
    public APIException getFaultInfo() {
        return faultInfo;
    }

}
