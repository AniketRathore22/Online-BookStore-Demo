package com.online.BookStore.service;

import com.online.BookStore.entity.BookStoreRecords;
import com.online.BookStore.mapper.UserMapper;
import com.online.BookStore.model.BookStore;
import com.online.BookStore.repository.BookServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookServiceRepository bookServiceRepository;
    @Override
    public BookStore createUser(BookStore dto) {
        BookStoreRecords bookStoreRecords = UserMapper.mapToUser(dto);
        BookStore saveBooks= bookServiceRepository.save(dto);
        BookStore userDto = UserMapper.mapToBookStoreDto(saveBooks);
        return userDto;
    }

    @Override
    public BookStore createBookRecords(BookStore dto) {
        BookStoreRecords bookStoreRecords = UserMapper.mapToUser(dto);
        BookStore saveBooks= bookServiceRepository.save(dto);
        BookStore userDto = UserMapper.mapToBookStoreDto(saveBooks);
        return userDto;
    }

    @Override
    public List<BookStore> getAllBookRecords() {
     List<BookStore> bookStore =  bookServiceRepository.findAll();
      return bookStore.stream().map(UserMapper::mapToBookStoreDto)
              .collect(Collectors.toList());
    }

    @Override
    public BookStore getBookRecordsById(Long id) {
     Optional<BookStore> bookStoreRecords =  bookServiceRepository.findById(id);
     BookStore bookStore1=  bookStoreRecords.get();
      return  UserMapper.mapToBookStoreDto(bookStore1);
    }

    @Override
    public BookStore updateBookRecords(BookStore dto) {
        BookStore existingBook= bookServiceRepository.findById(dto.getId()).get();
        existingBook.setTittle(dto.getTittle());
        existingBook.setPublishedDate(dto.getPublishedDate());
        existingBook.setISBN(dto.getISBN());
        existingBook.setGenre(dto.getGenre());
        existingBook.setAuthor(dto.getAuthor());
    BookStore bookStore =  bookServiceRepository.save(existingBook);

  return  UserMapper.mapToBookStoreDto(bookStore);
           }

    @Override
    public void deleteBookRecords(Long userId) {
        bookServiceRepository.findById(userId);

    }
}
