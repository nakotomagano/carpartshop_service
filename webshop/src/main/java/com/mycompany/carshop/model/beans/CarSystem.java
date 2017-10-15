package com.mycompany.carshop.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Each vehicle consists of several systems of car parts.
 * Example: Exhaust system, fuel system.
 *
 * @author Veljko Matovic
 * Oct 7, 2017
 *
 */

@Entity
@Table(name = "system")
public class CarSystem {
    @Id
    @GeneratedValue
    @Column(name = "id_system")
    private int systemId;
    @Column(name = "sys_name")
    private String systemName;

    public CarSystem() {

    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

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
