package com.online.BookStore.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookStore {
    private Long id;
    private String author;
    private String tittle;
    private String ISBN;
    private String genre;
    private Date publishedDate;

}
