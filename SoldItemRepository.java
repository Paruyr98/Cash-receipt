package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.entyty.SoldItem;
import org.springframework.data.repository.CrudRepository;

public interface SoldItemRepository extends CrudRepository<SoldItem, Integer> {
}
