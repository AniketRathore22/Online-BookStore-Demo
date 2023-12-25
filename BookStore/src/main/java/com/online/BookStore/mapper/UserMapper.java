package com.online.BookStore.mapper;

import com.online.BookStore.entity.BookStoreRecords;
import com.online.BookStore.model.BookStore;

public class UserMapper {
    // Convert User JPA Entity into Dto
        public static BookStore mapToBookStoreDto(BookStore dto){
        BookStore bookStore = new BookStore(
                dto.getId(),
                dto.getAuthor(),
                dto.getTittle(),
                dto.getISBN(),
                dto.getGenre(),
                dto.getPublishedDate()
        );
        return bookStore;
    }
    public static BookStoreRecords mapToUser(BookStore storeDto) {
        BookStoreRecords bookStoreRecords = new BookStoreRecords(
                storeDto.getId(),
                storeDto.getAuthor(),
                storeDto.getTittle(),
                storeDto.getISBN(),
                storeDto.getGenre(),
                storeDto.getPublishedDate()
        );
        return bookStoreRecords;
    }
}
