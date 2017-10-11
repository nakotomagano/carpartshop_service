
package com.techdata.carshop.clientWs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for part complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="part">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="carSystem" type="{http://impl.service.carshop.mycompany.com/}carSystem" minOccurs="0"/>
 *         &lt;element name="man" type="{http://impl.service.carshop.mycompany.com/}manufacturer" minOccurs="0"/>
 *         &lt;element name="model" type="{http://impl.service.carshop.mycompany.com/}model" minOccurs="0"/>
 *         &lt;element name="partId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="partName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "part", propOrder = {
    "carSystem",
    "man",
    "model",
    "partId",
    "partName",
    "price",
    "quantity"
})
public class Part {

    protected CarSystem carSystem;
    protected Manufacturer man;
    protected Model model;
    protected int partId;
    protected String partName;
    protected double price;
    protected int quantity;

    /**
     * Gets the value of the carSystem property.
     * 
     * @return
     *     possible object is
     *     {@link CarSystem }
     *     
     */
    public CarSystem getCarSystem() {
        return carSystem;
    }

    /**
     * Sets the value of the carSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarSystem }
     *     
     */
    public void setCarSystem(CarSystem value) {
        this.carSystem = value;
    }

    /**
     * Gets the value of the man property.
     * 
     * @return
     *     possible object is
     *     {@link Manufacturer }
     *     
     */
    public Manufacturer getMan() {
        return man;
    }

    /**
     * Sets the value of the man property.
     * 
     * @param value
     *     allowed object is
     *     {@link Manufacturer }
     *     
     */
    public void setMan(Manufacturer value) {
        this.man = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link Model }
     *     
     */
    public Model getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link Model }
     *     
     */
    public void setModel(Model value) {
        this.model = value;
    }

    /**
     * Gets the value of the partId property.
     * 
     */
    public int getPartId() {
        return partId;
    }

    /**
     * Sets the value of the partId property.
     * 
     */
    public void setPartId(int value) {
        this.partId = value;
    }

    /**
     * Gets the value of the partName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartName() {
        return partName;
    }

    /**
     * Sets the value of the partName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartName(String value) {
        this.partName = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

}
