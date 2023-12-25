package com.online.BookStore.controller;

import com.online.BookStore.model.BookStore;
import com.online.BookStore.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("api/books")
@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<BookStore> createBookRec(@RequestBody BookStore dto){
        BookStore savedUser = bookService.createBookRecords(dto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/books/1
    @GetMapping("{id}")
    public ResponseEntity<BookStore> netbooksById(@PathVariable("id") Long id){
        BookStore user = bookService.getBookRecordsById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    // http://localhost:8080/api/books
    @GetMapping
    public ResponseEntity<List<BookStore>> getAllBooks(){
        List<BookStore> users = bookService.getAllBookRecords();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("{id}")
    // http://localhost:8080/api/books/1
    public ResponseEntity<BookStore> updateBooks(@PathVariable("id") Long userId,
                                              @RequestBody BookStore dto){
        dto.setId(userId);
        BookStore updatedUser = bookService.updateBookRecords(dto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBookRec(@PathVariable("id") Long userId){
        bookService.deleteBookRecords(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
