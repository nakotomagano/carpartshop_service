package com.mycompany.carshop.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sun.xml.txw2.annotation.XmlElement;

/**
 * Part class consists of information such as:
 * it's manufacturer, car system it belongs to, price, etc.
 * @author Veljko Matovic
 * Oct 7, 2017
 *
 */

@Entity
@Table(name = "carpart")
public class Part {
    @Id
    @GeneratedValue //(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_part")
    private int partId;
    @Column(name = "part_name")
    private String partName;
    @ManyToOne
    @JoinColumn(name = "id_sys")
    private CarSystem system;
    @OneToOne
    @JoinColumn(name = "id_man")
    private Manufacturer man;
    @OneToOne
    @JoinColumn(name = "id_model")
    private Model model;
    @JoinColumn(name = "price")
    private float price;
    @JoinColumn(name = "quantity")
    private int quantity;

    public Part() {

    }

    public Part(String partName, CarSystem cs, Manufacturer m, float price, int quantity) {
        setPartName(partName);
        setCarSystem(cs);
        setMan(m);
        setPrice(price);
        setQuantity(quantity);
    }

    public Part(int partId, String partName) {
        setPartId(partId);
        setPartName(partName);
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public CarSystem getCarSystem() {
        return system;
    }

    public void setCarSystem(CarSystem system) {
        this.system = system;
    }

    public Manufacturer getMan() {
        return man;
    }

    public void setMan(Manufacturer man) {
        this.man = man;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns name of the car part.
     * @return
     */
    public String printPartName() {
        return getPartName();
    }


}
