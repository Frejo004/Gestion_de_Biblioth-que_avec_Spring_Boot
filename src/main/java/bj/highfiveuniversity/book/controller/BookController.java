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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.book.dto.BookDTO;
import bj.highfiveuniversity.book.dto.CreateBookDTO;
import bj.highfiveuniversity.book.mapper.BookMapper;
import bj.highfiveuniversity.book.models.Book;
import bj.highfiveuniversity.book.services.BookService;
import jakarta.validation.Valid;



@RestController
@RequestMapping ("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //afficher tout les livres
    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBook() {
        List<BookDTO> livres = bookService.getAllBooks();
        return ResponseEntity.ok(livres) ;
    }
    
    public String searchbook(@RequestParam  String author,@RequestParam(required = false) String year){
        return "Recherche des livres de l'auteur" + author + "de l'année" + year;
    }


    //enregistrer un nouveau livre
    @PostMapping
    public ResponseEntity<BookDTO> addBook(@Valid @RequestBody CreateBookDTO CreateBookDTO) {

        Book livre = new Book();
        livre.setTitle(CreateBookDTO.getTitle());
        livre.setIsbn(CreateBookDTO.getIsbn());
        livre.setDate_publication(CreateBookDTO.getDate_publication());

        Book newBook = bookService.ajouterBook(livre);

        BookDTO livreDto = BookMapper.toDto(newBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(livreDto) ;
    }


    //afficher un livre
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getOnBook(@PathVariable Long id) {
        BookDTO livre =  bookService.afficheBook(id);
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
