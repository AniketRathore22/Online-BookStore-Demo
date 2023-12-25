package com.online.BookStore.repository;

import com.online.BookStore.model.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookServiceRepository extends JpaRepository<BookStore,Long> {
}
