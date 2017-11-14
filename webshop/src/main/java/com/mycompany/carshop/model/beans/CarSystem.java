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
 * Each vehicle consists of several systems of car parts.
 * Example: Exhaust system, fuel system.
 *
 * @author Veljko Matovic
 * Oct 7, 2017
 *
 */
@XmlRootElement(name = "carSystem")
@Entity
@Table(name = "system")
public class CarSystem implements Serializable {

    private static final long serialVersionUID = -5896454273573485308L;

    @Id
    @GeneratedValue
    @Column(name = "id_system")
    private int systemId;
    @Column(name = "sys_name")
    private String systemName;

    public CarSystem() {

    }

    @XmlElement
    public int getSystemId() {
        return systemId;
    }
    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    @XmlElement
    public String getSystemName() {
        return systemName;
    }
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @Override
    public String toString() {
        return systemName;
    }

}
