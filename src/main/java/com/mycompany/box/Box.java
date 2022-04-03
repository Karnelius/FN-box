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
        return cost;
    }

    // Skriva någon typ av funktion/metod där this.weight * this.SelectedCountry = cost.
    /*
    Sweden = 1,3f
    China = 4,0f
    Brazil = 8,4f
    Australia = 7,2f
     */

    public void setCost(float cost) {
        this.cost  = cost;
    }

    @Override
    public String toString() {
        return "Box{" +
                "Id=" + Id +
                ", reciever='" + reciever + '\'' +
                ", weight=" + weight +
                ", color=" + color +
                ", cost=" + cost +
                '}';
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
