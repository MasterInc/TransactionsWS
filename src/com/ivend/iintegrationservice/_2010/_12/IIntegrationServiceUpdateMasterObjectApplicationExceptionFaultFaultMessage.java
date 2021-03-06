
package com.ivend.iintegrationservice._2010._12;

import javax.xml.ws.WebFault;
import org.datacontract.schemas._2004._07.system.ApplicationException;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ApplicationException", targetNamespace = "http://schemas.datacontract.org/2004/07/System")
public class IIntegrationServiceUpdateMasterObjectApplicationExceptionFaultFaultMessage
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ApplicationException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public IIntegrationServiceUpdateMasterObjectApplicationExceptionFaultFaultMessage(String message, ApplicationException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public IIntegrationServiceUpdateMasterObjectApplicationExceptionFaultFaultMessage(String message, ApplicationException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.datacontract.schemas._2004._07.system.ApplicationException
     */
    public ApplicationException getFaultInfo() {
        return faultInfo;
    }

}
