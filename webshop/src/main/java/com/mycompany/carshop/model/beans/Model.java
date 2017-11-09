package com.mycompany.carshop.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model of car part.
 *
 * @author Veljko Matovic
 * Oct 7, 2017
 *
 */
@XmlRootElement(name = "model")
@Entity
@Table(name = "model")
public class Model {
    @Id
    @GeneratedValue
    @Column(name = "model_id")
    private int modelId;
    @Column(name = "model_name")
    private String modelName;

    public Model() {

    }

    @XmlElement
    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    @XmlElement
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return modelName;
    }

}
