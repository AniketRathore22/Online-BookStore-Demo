package com.online.BookStore.service;

import com.online.BookStore.model.BookStore;

import java.util.List;

public interface BookService {
    BookStore createUser(BookStore dto);

    BookStore createBookRecords(BookStore dto);

    List<BookStore> getAllBookRecords();

    BookStore getBookRecordsById(Long id);

    BookStore updateBookRecords(BookStore dto);

    void deleteBookRecords(Long userId);
}
