package bj.highfiveuniversity.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import bj.highfiveuniversity.book.models.Book;
import bj.highfiveuniversity.book.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    //ajouter de livre
    public Book ajouterBook(Book livre) {
        return bookRepository.save(livre); 
    }

    //modifier de livre
    public Book updateBook(Book newLivre, Long id) {

        //récupération de l'Id du livre
        Book MonLivre  = afficheBook(id);

        //update des données
        MonLivre.setTitle(newLivre.getTitle());
        MonLivre.setIsbn(newLivre.getIsbn());
        MonLivre.setDate_publication(newLivre.getDate_publication());
        return bookRepository.save(MonLivre);
    }


    //supprimer un livre
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    //afficher un livre
    public Book afficheBook(Long id){
        return bookRepository.findById(id).get();
    }

    //la liste des livres
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    //rechercher un livre
    public List<Book> searchBook(@RequestParam String title) {
        return bookRepository.findByTitleContaining(title);
    }
}
