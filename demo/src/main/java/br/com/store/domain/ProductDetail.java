package br.com.store.domain;

import javax.persistence.*;

@Entity(name = "PRODUCT_DETAIL")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn
    private Product product;

    @Column(name = "gross_weigth")
    private float gross_weigth;

    @Column(name = "net_weigth")
    private float net_weigth;

    @Column(name = "type_of_material")
    private String type_of_material;

    @Column(name = "color")
    private String color;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    @Column(name = "category")
    private String category;

    public Product getId_prod() {
        return product;
    }

    public void setId_prod(Product product) {
        this.product = product;
    }

    public float getgross_weigth() {
        return gross_weigth;
    }

    public void setgross_weigth(float gross_weigth) {
        this.gross_weigth = gross_weigth;
    }

    public float getnet_weigth() {
        return net_weigth;
    }

    public void setnet_weigth(float net_weigth) {
        this.net_weigth = net_weigth;
    }

    public String getType_of_material() {
        return type_of_material;
    }

    public void setType_of_material(String type_of_material) {
        this.type_of_material = type_of_material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String colour) {
        this.color = colour;
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
                "id_prod=" + product +
                ", gross_weigth=" + gross_weigth +
                ", net_weigth=" + net_weigth +
                ", type_of_material='" + type_of_material + '\'' +
                ", color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
