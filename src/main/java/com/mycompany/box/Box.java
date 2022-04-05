package com.mycompany.box;

import javax.persistence.*;

@Entity
@Table(name = "box")

public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false, length = 45)
    private String reciever;

    @Column(nullable = false)
    private float weight;

    @Column(nullable = false)
    private Integer color;

    @Column(nullable = false)
    private float cost;

    @Transient
    private String country;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public float getCost() {
        float cost = 0;

        float swe = 1.3f;
        float chi = 2.5f;
        float bra = 3.4f;
        float aus = 5.5f;

        if (getCountry()==("1")) {
            cost = getWeight() * swe;

        } else if (getCountry()==("2")) {
            cost = getWeight() * chi;


        } else if (getCountry()==("3")) {
            cost = getWeight() * bra;


        } else if (getCountry()==("4")) {
            cost = getWeight() * aus;


        }else{
            cost = 10.4f;
        }
        return cost;
    }


    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Box{" +
                "Id=" + Id +
                ", reciever='" + reciever + '\'' +
                ", weight=" + weight +
                ", color=" + color  +
                ", cost=" + cost +
                '}';
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

/*
    -- SQL-TOTAL SUM --

    SELECT
	SUM(quantityOrdered * priceEach)  orderTotal
FROM
	orderdetails
WHERE
	orderNumber = 10100;
     */
}
