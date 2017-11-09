package com.mycompany.carshop.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Member class represents person registered on web-site
 * with all relevant information about him/her.
 *
 * @author Veljko Matovic
 * Oct 7, 2017
 *
 */
@XmlRootElement(name = "member")
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "id_member")
    private int memberId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "money")
    private float money;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;


    public Member() {

    }

    @XmlElement
    public int getMemberId() {
        return memberId;
    }


    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }


    @XmlElement
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElement
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement
    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @XmlElement
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @XmlElement
    public Role getRole() {
        return role;
    }



    public void setRole(Role role) {
        this.role = role;
    }




}
