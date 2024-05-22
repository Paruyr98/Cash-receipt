package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.entyty.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}