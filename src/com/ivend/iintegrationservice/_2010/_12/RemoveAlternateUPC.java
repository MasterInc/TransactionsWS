
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
 *         &lt;element name="alternateUPCList" type="{http://www.iVend.com/IIntegrationService/2010/12}ArrayOfUPCTranslation" minOccurs="0"/>
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
    "alternateUPCList"
})
@XmlRootElement(name = "RemoveAlternateUPC")
public class RemoveAlternateUPC {

    @XmlElementRef(name = "alternateUPCList", namespace = "http://www.iVend.com/IIntegrationService/2010/12", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfUPCTranslation> alternateUPCList;

    /**
     * Gets the value of the alternateUPCList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfUPCTranslation }{@code >}
     *     
     */
    public JAXBElement<ArrayOfUPCTranslation> getAlternateUPCList() {
        return alternateUPCList;
    }

    /**
     * Sets the value of the alternateUPCList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfUPCTranslation }{@code >}
     *     
     */
    public void setAlternateUPCList(JAXBElement<ArrayOfUPCTranslation> value) {
        this.alternateUPCList = value;
    }

}
