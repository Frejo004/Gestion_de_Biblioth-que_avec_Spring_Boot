package bj.highfiveuniversity.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.book.models.Author;
import bj.highfiveuniversity.book.services.AuthorService;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping
    public String addAuthor(@RequestBody Author auteur){
        authorService.ajouterAuteur(auteur);
        return"Auteur ajouter avec succès";
    }

    @GetMapping("/{id}")
    public Author getOnAuthor(@PathVariable Long id) {
        return authorService.afficherAuteur(id);
    }


    @PutMapping("/{id}")
    public String updateAuthor(@RequestBody Author newAuthor, @PathVariable Long id) {
        authorService.updateAuthor( newAuthor, id);
        return " Auteur modifié avec succès !";
    }


    @DeleteMapping("/{id}")
    public String deleteAuthor(Long id) {
        authorService.deleteAuteur(id);
        return "Auteur supprimé avec succès !";
    }

    

}
