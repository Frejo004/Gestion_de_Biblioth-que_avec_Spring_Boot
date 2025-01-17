package bj.highfiveuniversity.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.book.models.Author;
import bj.highfiveuniversity.book.models.Book;
import bj.highfiveuniversity.book.repository.BookRepository;
import bj.highfiveuniversity.book.services.BookService;



@RestController
@RequestMapping ("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //afficher tout les livres
    @GetMapping
    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> livres = bookService.getAllBooks();
        return ResponseEntity.ok(livres) ;
    }
    
    public String searchbook(@RequestParam  String author,@RequestParam(required = false) String year){
        return "Recherche des livres de l'auteur" + author + "de l'année" + year;
    }


    //enregistrer un nouveau livre
    @PostMapping("")
    public ResponseEntity<Book> addBook(@RequestBody Book livre) {
        Book addBook = bookService.ajouterBook(livre);
        return ResponseEntity.status(HttpStatus.CREATED).body(addBook) ;
    }


    //afficher un livre
    @GetMapping("/{id}")
    public ResponseEntity<Book> getOnBook(@PathVariable Long id) {
        Book livre =  bookService.afficheBook(id);
        return ResponseEntity.ok(livre);
    }


    //supprimer un livre par son id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }


    //modifier un livre par son id
    @PutMapping("/{id}")
    public ResponseEntity<Book> modifBook(@RequestBody Book newLibre, @PathVariable Long id) {
        Book update = bookService.updateBook( newLibre, id );
        return ResponseEntity.status(204).body(update);
    }

    //recherche un livre par son titre
    @GetMapping("/search/{title}")
    public List<Book> getSearchBook(@PathVariable String title) {
        return bookService.searchBook(title);
    }
        

}
