package br.com.store.domain;

import javax.persistence.*;

@Entity( name = "STORE")
public class Store {

    @Column( name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column( name = "NAME")
    private String name;

    public Store(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
