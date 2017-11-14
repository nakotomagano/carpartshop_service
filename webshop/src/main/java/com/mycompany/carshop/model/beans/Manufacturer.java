package com.mycompany.carshop.model.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Manufacturer of car part.
 *
 * @author Veljko Matovic
 * Oct 7, 2017
 *
 */
@XmlRootElement(name = "manufacturer")
@Entity
@Table(name = "manufacturer")
public class Manufacturer implements Serializable {

    private static final long serialVersionUID = 820561643817122817L;

    @Id
    @GeneratedValue
    @Column(name = "id_man")
    private int manId;
    @Column(name = "man_name")
    private String manName;

    public Manufacturer() {

    }

    @XmlElement
    public int getManId() {
        return manId;
    }

    public void setManId(int manId) {
        this.manId = manId;
    }

    @XmlElement
    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    @Override
    public String toString() {
        return manName;
    }

}
