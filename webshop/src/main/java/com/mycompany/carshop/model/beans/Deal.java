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
 * Oct 7, 2017
 *
 */
@Entity
@Table(name = "deal")
//@org.hibernate.annotations.Entity(dynamicInsert = true)
public class Deal { // implements Serializable
    //private static final long serialVersionUID = -2601498877024740886L;
    @Id
    @GeneratedValue //(generator="increment")
    //@GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id_deal")
    private int dealId;


    @ManyToOne
    @JoinColumn(name = "id_cust")
    private Member member;


    @ManyToOne
    @JoinColumn(name = "id_part")
    private Part part;


    @JoinColumn(name = "quantity")
    private int quantity;

    @JoinColumn(name = "amount")
    private float amount;

    public Deal() {

    }

    public int getDealId() {
        return dealId;
    }

    public void setDealId(int dealId) {
        this.dealId = dealId;
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
