package bj.highfiveuniversity.book.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import bj.highfiveuniversity.book.dto.BookDTO;
import bj.highfiveuniversity.book.mapper.BookMapper;
import bj.highfiveuniversity.book.models.Author;
import bj.highfiveuniversity.book.models.Book;
import bj.highfiveuniversity.book.repository.AuthorRepository;
import bj.highfiveuniversity.book.repository.BookRepository;
import jakarta.transaction.Transactional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public Book saveBookWithAuthor(String title, String isbn,Set<Long> authorId) {
        // Récupérer l'auteur depuis la base de données
        Set<Author> authors = authorRepository.findAllById(authorId).stream().collect(Collectors.toSet());
        // Créer un nouveau livre
        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);


        // Enregistrer le livre dans la base de données
        return bookRepository.save(book);
    }

    // ajouter de livre
    public Book ajouterBook(Book livre) {
        return bookRepository.save(livre);
    }

    // afficher un livre
    public BookDTO afficheBook(Long id) {
        Book livre = bookRepository.findById(id).get();
        return BookMapper.toDto(livre);
    }

    // la liste des livres
    public List<BookDTO> getAllBooks() {

        ///récupération des livres dans une variable
        List<Book> livres = bookRepository.findAll();
        List<BookDTO> livresDTO = new ArrayList<>();

        for(Book livre : livres) {
            BookDTO livreDto = BookMapper.toDto(livre);
            livresDTO.add(livreDto);
        }
        return livresDTO;
    }

    // modifier de livre
    public Book updateBook(Book newLivre, Long id) {

        // récupération de l'Id du livre
        Book MonLivre = bookRepository.findById(id).get();
        // update des données
        MonLivre.setTitle(newLivre.getTitle());
        MonLivre.setIsbn(newLivre.getIsbn());
        MonLivre.setDate_publication(newLivre.getDate_publication());
        return bookRepository.save(MonLivre);
    }

    // supprimer un livre
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // rechercher un livre
    public List<Book> searchBook(@RequestParam String title) {
        return bookRepository.findByTitleContaining(title);
    }
}
