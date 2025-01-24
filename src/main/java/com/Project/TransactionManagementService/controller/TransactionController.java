package com.Project.TransactionManagementService.controller;

import com.Project.TransactionManagementService.dto.TransactionDetailsDto;
import com.Project.TransactionManagementService.model.TransactionEntity;
import com.Project.TransactionManagementService.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/{transactionId}/details")
    public ResponseEntity<TransactionDetailsDto> getTransactionDetails(@PathVariable Long transactionId) {
        TransactionDetailsDto details = transactionService.getTransactionDetails(transactionId);
        return ResponseEntity.ok(details);
    }

    // Get all transactions
    @GetMapping
    public ResponseEntity<List<TransactionEntity>> getAllTransactions() {
        List<TransactionEntity> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    // Get a transaction by ID
    @GetMapping("/{transactionId}")
    public ResponseEntity<?> getTransactionById(@PathVariable Long transactionId) {
        Optional<TransactionEntity> transaction = transactionService.getTransactionById(transactionId);
        if (transaction.isPresent()) {
            return ResponseEntity.ok(transaction.get());
        } else {
            return ResponseEntity.status(404).body("Transaction not found with ID: " + transactionId);
        }
    }


    // Add a new transaction
    @PostMapping
    public ResponseEntity<TransactionEntity> addTransaction(@RequestBody TransactionEntity transaction) {
        TransactionEntity savedTransaction = transactionService.addTransaction(transaction);
        return ResponseEntity.status(201).body(savedTransaction);
    }

    // Update a transaction
    @PutMapping("/{transactionId}")
    public ResponseEntity<?> updateTransaction(@PathVariable Long transactionId, @RequestBody TransactionEntity updatedTransaction) {
        Optional<TransactionEntity> updated = transactionService.updateTransaction(transactionId, updatedTransaction);
        if (updated.isPresent()) {
            return ResponseEntity.ok(updated.get());
        } else {
            return ResponseEntity.status(404).body("Transaction not found with ID: " + transactionId);
        }
    }


    // Delete a transaction
    @DeleteMapping("/{transactionId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long transactionId) {
        if (transactionService.deleteTransaction(transactionId)) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(404).body("Transaction not found with ID: " + transactionId);
        }
    }
}
