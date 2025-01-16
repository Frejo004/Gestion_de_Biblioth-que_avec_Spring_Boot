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
    public List<Book> getAllBook() {
        return bookService.getAllBooks();
        
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
    public Book getOnBook(@PathVariable Long id) {
        return bookService.afficheBook(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Le livre avec l'ID " + id + " est supprimé";
    }

    @PutMapping("/{id}")
    public String modifBook(@RequestBody Book newLibre, @PathVariable Long id) {
        bookService.updateBook( newLibre, id );
        return "Modification effectué avec succès";
    }
        

}
