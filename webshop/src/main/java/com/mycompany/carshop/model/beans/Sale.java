package com.mycompany.carshop.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Purchase informations. Such as:
 * - Buyer (Member)
 * - Part(s) bought
 * - price
 * - date/time
 * - delivery information
 * - payment information
 * @author Veljko Matovic
 * Oct 10, 2017
 *
 */

@Entity
@Table(name = "deal")
public class Sale {
    @Id
    @GeneratedValue
    @Column(name = "id_deal")
    private int saleId;

    @ManyToOne
    @JoinColumn(name = "id_cust")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "id_part")
    private Part part;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "amount")
    private float amount;

    public Sale() {

    }

    public Sale(Member m, Part p, int quant, float am) {
        setMember(m);
        setPart(p);
        setQuantity(quant);
        setAmount(am);
    }

    public Sale(int quant, float am) {
        setQuantity(quant);
        setAmount(am);
    }

    public int getDealId() {
        return saleId;
    }

    public void setDealId(int dealId) {
        this.saleId = dealId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

}
