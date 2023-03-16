package com.backendmarch.librarymanagementsystem.Repository;

import com.backendmarch.librarymanagementsystem.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository  extends JpaRepository<Transaction,Integer> {
}
