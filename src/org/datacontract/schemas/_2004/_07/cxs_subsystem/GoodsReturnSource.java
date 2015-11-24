
package org.datacontract.schemas._2004._07.cxs_subsystem;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GoodsReturnSource.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GoodsReturnSource">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="GoodsReceiptPO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GoodsReturnSource", namespace = "http://schemas.datacontract.org/2004/07/CXS.SubSystem.Purchasing")
@XmlEnum
public enum GoodsReturnSource {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("GoodsReceiptPO")
    GOODS_RECEIPT_PO("GoodsReceiptPO");
    private final String value;

    GoodsReturnSource(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GoodsReturnSource fromValue(String v) {
        for (GoodsReturnSource c: GoodsReturnSource.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
