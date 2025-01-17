package bj.highfiveuniversity.book.dto;

import java.time.LocalDate;
import java.util.Set;

import bj.highfiveuniversity.book.models.Author;


public class BookDTO {
    private Long id;
    private String title;
    private String isbn;

    //construtor
    public BookDTO(Long id, String title, String isbn, Set<Author> date_publication) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
    }


    //Getters and Setters
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    

}
