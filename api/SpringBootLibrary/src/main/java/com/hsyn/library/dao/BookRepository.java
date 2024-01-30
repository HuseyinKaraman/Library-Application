package com.hsyn.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsyn.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
