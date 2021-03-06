
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
 *         &lt;element name="siteId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastSequenceNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="backupSequenceNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
    "siteId",
    "lastSequenceNo",
    "backupSequenceNo"
})
@XmlRootElement(name = "GetReplicationSendDump")
public class GetReplicationSendDump {

    @XmlElementRef(name = "siteId", namespace = "http://www.iVend.com/IIntegrationService/2010/12", type = JAXBElement.class, required = false)
    protected JAXBElement<String> siteId;
    protected Long lastSequenceNo;
    protected Long backupSequenceNo;

    /**
     * Gets the value of the siteId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSiteId() {
        return siteId;
    }

    /**
     * Sets the value of the siteId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSiteId(JAXBElement<String> value) {
        this.siteId = value;
    }

    /**
     * Gets the value of the lastSequenceNo property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLastSequenceNo() {
        return lastSequenceNo;
    }

    /**
     * Sets the value of the lastSequenceNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLastSequenceNo(Long value) {
        this.lastSequenceNo = value;
    }

    /**
     * Gets the value of the backupSequenceNo property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBackupSequenceNo() {
        return backupSequenceNo;
    }

    /**
     * Sets the value of the backupSequenceNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBackupSequenceNo(Long value) {
        this.backupSequenceNo = value;
    }

}
