package bj.highfiveuniversity.book.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping ("/books")
public class BookController {

    @GetMapping
    public String getAllBooks() {
        return "Listes de tous les livres";
    }
    
    public String searchbook(@RequestParam  String author,@RequestParam(required = false) String year){
        return "Recherche des livres de l'auteur" + author + "de l'année" + year;
    }


    @PostMapping
    public String addBook() {
        return "Livre ajouté avec succès";
    }

    @GetMapping("/{id}")
    public String getOnBook(@PathVariable Long id) {
        return "Le livre avec l'id " + id + " est : le livre";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        return "Le livre avec l'ID " + id + " est supprimé";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable Long id) {
        return "Modification : l'ID " + id + " la modification a été éffectué avec succès";
    }
        

}
