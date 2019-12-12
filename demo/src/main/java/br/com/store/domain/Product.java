package br.com.store.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity(name="PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_prod;

    @Column(name = "name")
    private String name;

    @Column(name = "unit_price")
    private float unit_price;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private int rating;

    @Column(name = "amount")
    private int amount;

    public long getId_prod() {
        return id_prod;
    }

    public void setId_prod(long id_prod) {
        this.id_prod = id_prod;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_prod=" + id_prod +
                ", name='" + name + '\'' +
                ", unit_price=" + unit_price +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", amount=" + amount +
                '}';
    }
}


