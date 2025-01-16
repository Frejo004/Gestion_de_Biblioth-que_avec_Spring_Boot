package bj.highfiveuniversity.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniversity.book.models.Author;

public interface AuthorRepository extends JpaRepository <Author, Long> {
    List<Author> findByNomContaining ();
}
