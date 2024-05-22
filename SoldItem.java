package com.example.accessingdatamysql.entyty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name = "sold_items")
public class SoldItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long idSales;
    String name;
    Long count;
    Long price;
    Long totalPrice;

    public SoldItem() {
    }

    public SoldItem(Long idSales, String name, Long count, Long price) {
        this.idSales = idSales;
        this.name = name;
        this.count = count;
        this.price = price;
        totalPrice = count * price;
    }

    public Long getId() {
        return id;
    }

    public Long getIdSales() {
        return idSales;
    }

    public Long getTotalPrice() {
        return count * price;
    }

    public String getName() {
        return name;
    }


    public Long getCount() {
        return count;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SoldItem{" +
                "id=" + id +
                ", idSales=" + idSales +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
