package br.com.store.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity( name="ORDERS" )
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_order;

    @OneToOne
    @JoinColumn
    private Long id_prod;

    @Column(name = "order_date")
    private Date order_date;

    @Column(name = "order_state")
    private String order_state;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "type_of_payment")
    private char type_of_payment;

    @Column(name = "due_date")
    private Date due_date;

    public Long getId_order() {
        return id_order;
    }

    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }

    public Long getId_prod() {
        return id_prod;
    }

    public void setId_prod(Long id_prod) {
        this.id_prod = id_prod;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getOrder_state() {
        return order_state;
    }

    public void setOrder_state(String order_state) {
        this.order_state = order_state;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public char getType_of_payment() {
        return type_of_payment;
    }

    public void setType_of_payment(char type_of_payment) {
        this.type_of_payment = type_of_payment;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id_order=" + id_order +
                ", id_prod=" + id_prod +
                ", order_date=" + order_date +
                ", order_state='" + order_state + '\'' +
                ", quantity=" + quantity +
                ", type_of_payment=" + type_of_payment +
                ", due_date=" + due_date +
                '}';
    }
}
