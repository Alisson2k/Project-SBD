package br.com.store.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity( name="person" )
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_person;

    private String phone;

    private String country;

    private String fname;

    private String lname;

    private String cpf;

    private String state;

    private String email;

    private String address;

    private Date bdate;

    public long getId() {
        return id_person;
    }

    public void setId(long id) {
        this.id_person = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id_person=" + id_person +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", cpf='" + cpf + '\'' +
                ", state='" + state + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", bdate=" + bdate +
                '}';
    }
}
