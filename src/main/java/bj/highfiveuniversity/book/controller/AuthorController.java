package bj.highfiveuniversity.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.book.dto.AuthorDTO;
import bj.highfiveuniversity.book.models.Author;
import bj.highfiveuniversity.book.services.AuthorService;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    //afficher la liste de tout les auteurs
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> auteurs =  authorService.getAllAuthors();
        return ResponseEntity.ok(auteurs);
    }

    //ajouter un nouveau auteur
    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author auteur)
    {
        Author addAuthor =  authorService.ajouterAuteur(auteur);
        return ResponseEntity.status(HttpStatus.CREATED).body(addAuthor);
    }

    
    //afficher un auter par son id
    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getOnAuthor(@PathVariable Long id) {
        AuthorDTO auteur = authorService.afficherAuteur(id);
        return ResponseEntity.ok(auteur);
    }


    //mise à jour des imformation de l'auteur
    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author newAuthor, @PathVariable Long id) {
        Author updated =  authorService.updateAuthor( newAuthor, id);
        return ResponseEntity.status(204).body(updated);
    }


    //supprimer par le id 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(Long id) {
        authorService.deleteAuteur(id);
        return ResponseEntity.noContent().build();
    }


    //rechercher par le nom de l'auteur
    @GetMapping("/search/author")
    public List<Author> getSearchAuthor(@PathVariable String nom) {
        return authorService.searchAuthor(nom);
    }
    

}
