package br.com.store.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "CLIENT_REPORT")
public class ClientReport {

    @ManyToOne
    @JoinColumn
    private Person person;

    @Column(name = "average_rate")
    private float average_rate;

    @Column(name = "satisfaction_level")
    private int satisfaction_level;

    @Column(name = "shopping_number")
    private int shopping_number;

    @Column(name = "prefer_category")
    private String prefer_category;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public float getAverage_rate() {
        return average_rate;
    }

    public void setAverage_rate(float average_rate) {
        this.average_rate = average_rate;
    }

    public int getSatisfaction_level() {
        return satisfaction_level;
    }

    public void setSatisfaction_level(int satisfaction_level) {
        this.satisfaction_level = satisfaction_level;
    }

    public int getShopping_number() {
        return shopping_number;
    }

    public void setShopping_number(int shopping_number) {
        this.shopping_number = shopping_number;
    }

    public String getPrefer_category() {
        return prefer_category;
    }

    public void setPrefer_category(String prefer_category) {
        this.prefer_category = prefer_category;
    }

    @Override
    public String toString() {
        return "ClientReport{" +
                "person=" + person +
                ", average_rate=" + average_rate +
                ", satisfaction_level=" + satisfaction_level +
                ", shopping_number=" + shopping_number +
                ", prefer_category='" + prefer_category + '\'' +
                '}';
    }
}
