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

    @Column(name = "seller_email")
    private String sellerEmail;

    @Column(name = "seller_mobile")
    private String sellerMobile;

    @Column(name = "seller_password")
    private String sellerPassword;

    public Seller() {
    }

    public Seller(long id, String sellerName, String sellerEmail, String sellerMobile, String sellerPassword) {
        this.id = id;
        this.sellerName = sellerName;
        this.sellerEmail = sellerEmail;
        this.sellerMobile = sellerMobile;
        this.sellerPassword = sellerPassword;
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

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getSellerMobile() {
        return sellerMobile;
    }

    public void setSellerMobile(String sellerMobile) {
        this.sellerMobile = sellerMobile;
    }

    public String getSellerPassword() {
        return sellerPassword;
    }

    public void setSellerPassword(String sellerPassword) {
        this.sellerPassword = sellerPassword;
    }
}
