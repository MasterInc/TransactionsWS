
package com.ivend.iintegrationservice._2010._12;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetQueueByWarehouseWithoutStatusUpdateResult" type="{http://www.iVend.com/IIntegrationService/2010/12}ArrayOfIntegrationQueue" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getQueueByWarehouseWithoutStatusUpdateResult"
})
@XmlRootElement(name = "GetQueueByWarehouseWithoutStatusUpdateResponse")
public class GetQueueByWarehouseWithoutStatusUpdateResponse {

    @XmlElementRef(name = "GetQueueByWarehouseWithoutStatusUpdateResult", namespace = "http://www.iVend.com/IIntegrationService/2010/12", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfIntegrationQueue> getQueueByWarehouseWithoutStatusUpdateResult;

    /**
     * Gets the value of the getQueueByWarehouseWithoutStatusUpdateResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIntegrationQueue }{@code >}
     *     
     */
    public JAXBElement<ArrayOfIntegrationQueue> getGetQueueByWarehouseWithoutStatusUpdateResult() {
        return getQueueByWarehouseWithoutStatusUpdateResult;
    }

    /**
     * Sets the value of the getQueueByWarehouseWithoutStatusUpdateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIntegrationQueue }{@code >}
     *     
     */
    public void setGetQueueByWarehouseWithoutStatusUpdateResult(JAXBElement<ArrayOfIntegrationQueue> value) {
        this.getQueueByWarehouseWithoutStatusUpdateResult = value;
    }

}
