package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.entyty.CashReceipt;
import org.springframework.data.repository.CrudRepository;

public interface CashReceiptRepository extends CrudRepository<CashReceipt, Integer> {
}
