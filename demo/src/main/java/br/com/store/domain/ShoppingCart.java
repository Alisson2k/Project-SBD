package br.com.store.domain;

import br.com.store.repository.ProductRepository;

import javax.persistence.*;

@Entity(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_cart;

    @ManyToOne
    @JoinColumn
    private Person person;

    @ManyToOne
    @JoinColumn
    private Product product;

    @Column(name = "quantity")
    private  int quantity;

    @Column(name = "total_price")
    private float total_price;

    public long getId_cart() {
        return id_cart;
    }

    public void setId_cart(long id_cart) {
        this.id_cart = id_cart;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id_cart=" + id_cart +
                ", person=" + person +
                ", product=" + product +
                ", quantity=" + quantity +
                ", total_price=" + total_price +
                '}';
    }
}
