package com.example.exception.book.db.repository;

import com.example.exception.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
