package com.backendmarch.librarymanagementsystem.Repository;

import com.backendmarch.librarymanagementsystem.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<LibraryCard,Integer> {
}
