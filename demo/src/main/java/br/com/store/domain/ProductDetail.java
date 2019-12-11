package br.com.store.domain;

import javax.persistence.*;

@Entity(name = "PRODUCT_DETAIL")
public class ProductDetail {

    @OneToOne
    @JoinColumn
    private long id_prod;

    @Column(name = "gross_weight")
    private float gross_weight;

    @Column(name = "net_weight")
    private float net_weight;

    @Column(name = "type_of_material")
    private String type_of_material;

    @Column(name = "colour")
    private String colour;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    @Column(name = "category")
    private String category;

    public long getId_prod() {
        return id_prod;
    }

    public void setId_prod(long id_prod) {
        this.id_prod = id_prod;
    }

    public float getGross_weight() {
        return gross_weight;
    }

    public void setGross_weight(float gross_weight) {
        this.gross_weight = gross_weight;
    }

    public float getNet_weight() {
        return net_weight;
    }

    public void setNet_weight(float net_weight) {
        this.net_weight = net_weight;
    }

    public String getType_of_material() {
        return type_of_material;
    }

    public void setType_of_material(String type_of_material) {
        this.type_of_material = type_of_material;
    }

    public String getColor() {
        return colour;
    }

    public void setColor(String colour) {
        this.colour = colour;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "id_prod=" + id_prod +
                ", gross_weight=" + gross_weight +
                ", net_weight=" + net_weight +
                ", type_of_material='" + type_of_material + '\'' +
                ", color='" + colour + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
