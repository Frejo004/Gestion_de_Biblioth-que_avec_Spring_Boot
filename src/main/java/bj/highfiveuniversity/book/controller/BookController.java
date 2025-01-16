package bj.highfiveuniversity.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.book.models.Book;
import bj.highfiveuniversity.book.repository.BookRepository;
import bj.highfiveuniversity.book.services.BookService;



@RestController
@RequestMapping ("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllBook() {
        bookService.getAllBooks();
        return "Listes de tous les livres" ;
    }
    
    public String searchbook(@RequestParam  String author,@RequestParam(required = false) String year){
        return "Recherche des livres de l'auteur" + author + "de l'année" + year;
    }


    @PostMapping("")
    public String addBook(@RequestBody Book livre) {
        bookService.ajouterBook(livre);
        return "Livre enrégistré avec succès" ;
    }

    @GetMapping("/{id}")
    public String getOnBook(@PathVariable Long id) {
        bookService.afficheBook(id);
        return "Le livre avec l'id " + id + " est : le livre";
    }

    // @DeleteMapping("/{id}")
    // public String deleteBook(@PathVariable Long id) {
    //     bookService.deleteBook(id);
    //     return "Le livre avec l'ID " + id + " est supprimé";
    // }

    // @PutMapping("/{id}")
    // public String updateBook(@PathVariable Long id) {
    //     bookService.updateBook(id);
    //     return "Modification : l'ID " + id + " la modification a été éffectué avec succès";
    // }
        

}
