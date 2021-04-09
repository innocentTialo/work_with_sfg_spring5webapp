package com.africafuture.spring5webapp.repository;

import com.africafuture.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
