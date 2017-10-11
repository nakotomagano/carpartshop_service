
package com.techdata.carshop.clientWs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for manufacturer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="manufacturer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="manId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="manName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "manufacturer", propOrder = {
    "manId",
    "manName"
})
public class Manufacturer {

    protected int manId;
    protected String manName;

    /**
     * Gets the value of the manId property.
     * 
     */
    public int getManId() {
        return manId;
    }

    /**
     * Sets the value of the manId property.
     * 
     */
    public void setManId(int value) {
        this.manId = value;
    }

    /**
     * Gets the value of the manName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManName() {
        return manName;
    }

    /**
     * Sets the value of the manName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManName(String value) {
        this.manName = value;
    }

}
