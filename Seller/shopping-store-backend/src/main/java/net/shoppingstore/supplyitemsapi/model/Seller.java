package net.shoppingstore.supplyitemsapi.model;

import javax.persistence.*;

@Entity
@Table(name = "sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "seller_name")
    private String sellerName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public Seller() {
    }

    public Seller(long id, String sellerName, String email, String password) {
        this.id = id;
        this.sellerName = sellerName;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String sellerEmail) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String sellerPassword) {
        this.password = password;
    }
}