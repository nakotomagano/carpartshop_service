package com.techdata.carshop.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model of car part.
 *
 * @author Veljko Matovic
 * Oct 7, 2017
 *
 */
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

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

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
