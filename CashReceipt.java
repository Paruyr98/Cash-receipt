package com.example.accessingdatamysql.entyty;


import jakarta.persistence.*;

@Entity(name = "cash_receipt")
public class CashReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSales;
    private Long receiptPrice;

    private String data;

    private String cashier;

    public CashReceipt(Long receiptPrice, String data, String cashier) {
        this.receiptPrice = receiptPrice;
        this.data = data;
        this.cashier = cashier;
    }

    public CashReceipt() {
    }

    public Long getIdSales() {
        return idSales;
    }

    @Override
    public String toString() {
        return "CashReceipt{" +
                "idSales=" + idSales +
                ", receiptPrice=" + receiptPrice +
                ", data='" + data + '\'' +
                ", cashier='" + cashier + '\'' +
                '}';
    }
}
