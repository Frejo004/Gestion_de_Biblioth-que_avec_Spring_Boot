package bj.highfiveuniversity.book.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreateBookDTO {

    private Long id;

    @NotNull(message = "Merci de bien vouloir renseigner le titre du livre.")
    @Size(min = 1, max = 25, message = "Titre trop  long. Il doit être compris entre  1 et 10 caractèreres")
    private String title;

    @NotNull(message = "Merci de bien vouloir renseigner le code ISFN du livre.")
    @Pattern(regexp = "^[0-9]{13}$", message = "Code ISBN non valide. Il doit contenir que 13 chriffres ")
    private String isbn;

    @NotNull(message = "Merci de bien vouloir renseigner la date de publication du livre.")
    private LocalDate  date_publication;

    

    public CreateBookDTO(Long id, String title, String isbn, LocalDate date_publication) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.date_publication = date_publication;
    }

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
