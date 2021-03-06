
package org.datacontract.schemas._2004._07.cxs_subsystem;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SaleAttributeCaptureType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SaleAttributeCaptureType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BeginingOfSale"/>
 *     &lt;enumeration value="EndOfSale"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SaleAttributeCaptureType", namespace = "http://schemas.datacontract.org/2004/07/CXS.SubSystem.Core")
@XmlEnum
public enum SaleAttributeCaptureType {

    @XmlEnumValue("BeginingOfSale")
    BEGINING_OF_SALE("BeginingOfSale"),
    @XmlEnumValue("EndOfSale")
    END_OF_SALE("EndOfSale");
    private final String value;

    SaleAttributeCaptureType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SaleAttributeCaptureType fromValue(String v) {
        for (SaleAttributeCaptureType c: SaleAttributeCaptureType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
