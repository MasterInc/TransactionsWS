
package com.ivend.iintegrationservice._2010._12;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfFulfillmentPlanSurcharge complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfFulfillmentPlanSurcharge">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FulfillmentPlanSurcharge" type="{http://www.iVend.com/IIntegrationService/2010/12}FulfillmentPlanSurcharge" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfFulfillmentPlanSurcharge", propOrder = {
    "fulfillmentPlanSurcharges"
})
public class ArrayOfFulfillmentPlanSurcharge {

    @XmlElement(name = "FulfillmentPlanSurcharge", nillable = true)
    protected List<FulfillmentPlanSurcharge> fulfillmentPlanSurcharges;

    /**
     * Gets the value of the fulfillmentPlanSurcharges property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fulfillmentPlanSurcharges property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFulfillmentPlanSurcharges().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FulfillmentPlanSurcharge }
     * 
     * 
     */
    public List<FulfillmentPlanSurcharge> getFulfillmentPlanSurcharges() {
        if (fulfillmentPlanSurcharges == null) {
            fulfillmentPlanSurcharges = new ArrayList<FulfillmentPlanSurcharge>();
        }
        return this.fulfillmentPlanSurcharges;
    }

}
