package com.mycompany.carshop.model.beans;

import java.util.ArrayList;

/**
 * List of Parts. Used as an argument for inserting multiple parts for example.
 * Also, can be used in future as a return type of getParts By{...} methods.
 * @author Veljko Matovic
 * Oct 16, 2017
 */
public class PartList {

    private  ArrayList<Part> parts;

    public ArrayList<Part> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }
}
