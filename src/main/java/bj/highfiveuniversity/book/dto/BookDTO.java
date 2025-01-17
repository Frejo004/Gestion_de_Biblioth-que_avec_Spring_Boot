package bj.highfiveuniversity.book.dto;

import java.time.LocalDate;


public class BookDTO {
    private Long id;
    private String title;
    private String isbn;
    private LocalDate  date_publication;

    //construtor
    public BookDTO(Long id, String title, String isbn, LocalDate date_publication) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.date_publication = date_publication;
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


    public LocalDate getDate_publication() {
        return date_publication;
    }


    public void setDate_publication(LocalDate date_publication) {
        this.date_publication = date_publication;
    }

    
    

}
