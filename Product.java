package com.example.accessingdatamysql.entyty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "products")
public class Product {
    @Id
    private Long id;

    private String name;

    private Long price;

    private Long stock;

    public Long getStock() {
        return stock;
    }


    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public Long getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}