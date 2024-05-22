package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.service.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("productService")
@org.springframework.stereotype.Controller
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("soldItems", service.getSoldItems());
        model.addAttribute("receiptPrice", service.getReceiptPrice());
        return "home.html";
    }

    @GetMapping("/print")
    public String print(Model model) {
        model.addAttribute("soldItems", service.getSoldItems());
        model.addAttribute("receiptPrice", service.getReceiptPrice());
        model.addAttribute("cashier", Service.getCashier());
        return "print.html";
    }

    @PostMapping("/addSoldItem")
    public String addSoldItem(@RequestParam("id") int id, @RequestParam("count") Long count) {
        service.addSoldItem(id, count);
        return "redirect:/";
    }

    @PostMapping("/addReceipt")
    public String addReceipt() {
        service.save();
        return "redirect:/print";
    }

    @PostMapping("/addCashier")
    public String addCashier(@RequestParam("cashier") String cashier) {
        Service.setCashier(cashier);
        return "redirect:/print";
    }

    @PostMapping("/changePrice")
    public String changePrice(@RequestParam String nameSoldItem, @RequestParam Long newPrice) {
        service.changePriceSoldItem(nameSoldItem, newPrice);
        return "redirect:/";
    }


    @GetMapping("/clear")
    public String clear() {
        service.clear();
        return "redirect:/";
    }
}