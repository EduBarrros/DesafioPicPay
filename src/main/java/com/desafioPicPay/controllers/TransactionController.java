package com.desafioPicPay.controllers;

import com.desafioPicPay.domain.transaction.Transaction;
import com.desafioPicPay.dtos.TransactionDTO;
import com.desafioPicPay.services.TrasactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TrasactionService trasactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception{

        Transaction newTransaction = this.trasactionService.createTransaction(transaction);

        return new ResponseEntity<>(newTransaction, HttpStatus.OK);

    }

}
