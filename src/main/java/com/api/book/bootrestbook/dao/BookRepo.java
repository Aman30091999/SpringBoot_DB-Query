package com.api.book.bootrestbook.dao;

import com.api.book.bootrestbook.Controllers.model.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
