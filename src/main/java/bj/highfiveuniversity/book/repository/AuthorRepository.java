package bj.highfiveuniversity.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniversity.book.models.Author;

public interface AuthorRepository extends JpaRepository <Author, Long> {

}
