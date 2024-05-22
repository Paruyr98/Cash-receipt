package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.entyty.CashReceipt;
import com.example.accessingdatamysql.entyty.Product;
import com.example.accessingdatamysql.entyty.SoldItem;
import com.example.accessingdatamysql.repository.CashReceiptRepository;
import com.example.accessingdatamysql.repository.ProductRepository;
import com.example.accessingdatamysql.repository.SoldItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Service {
    private final ProductRepository productRepository;
    private final CashReceiptRepository cashReceiptRepository;
    private final SoldItemRepository soldItemRepository;

    @Autowired
    public Service(ProductRepository productRepository, CashReceiptRepository cashReceiptRepository, SoldItemRepository soldItemRepository) {
        this.productRepository = productRepository;
        this.cashReceiptRepository = cashReceiptRepository;
        this.soldItemRepository = soldItemRepository;
    }

    private static String cashier;
    private static final List<SoldItem> soldItems = new ArrayList<>();


    public void addSoldItem(int id, Long quantity) {

        try {
            Product product = productRepository.findById(id).orElseThrow();
            soldItems.add(
                    new SoldItem(product.getId(), product.getName(), quantity, product.getPrice())
            );
        } catch (Exception ignored) {
        }

    }

    public void save() {
        CashReceipt savedReceipt = cashReceiptRepository.save(new CashReceipt(
                getReceiptPrice(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                getCashier()));


        for (SoldItem soldItem : soldItems) {
            SoldItem soldItem1 = new SoldItem(
                    savedReceipt.getIdSales(), soldItem.getName(), soldItem.getCount(), soldItem.getPrice());


            soldItemRepository.save(soldItem1);
        }
    }

    public void changePriceSoldItem(String nameSoldItem, Long newPrice) {
        for (SoldItem soldItem : soldItems) {
            if (soldItem.getName().equals(nameSoldItem)) {
                soldItem.setPrice(newPrice);
                break;
            }
        }
    }

    public void clear() {
        soldItems.clear();
    }

    public List<SoldItem> getSoldItems() {
        return soldItems;
    }

    public static String getCashier() {
        return cashier;
    }

    public static void setCashier(String cashier) {
        Service.cashier = cashier;
    }

    public Long getReceiptPrice() {
        return soldItems.stream().mapToLong(SoldItem::getTotalPrice).sum();
    }

}