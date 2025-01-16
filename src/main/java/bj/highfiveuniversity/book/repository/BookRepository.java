package bj.highfiveuniversity.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniversity.book.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
}
