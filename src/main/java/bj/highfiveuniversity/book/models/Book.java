package bj.highfiveuniversity.book.models;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "Livres")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String isbn;

    private LocalDate  date_publication;


    @ManyToMany
    @JoinTable(
        name = "auteur_Livre",
        joinColumns = @JoinColumn(name = "Livre_id"),
        inverseJoinColumns = @JoinColumn( name = "auteur_id")
    )
    private Set<Author> auteurs;



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
