package bj.highfiveuniversity.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // //modifier de livre
    // public Book updateBook(Long id) {
    //     return bookRepository.save(id).get(); 
    // }

    // //supprimer un livre
    // public Book deleteBook(Long id) {
    //     return bookRepository.deleteById(id);
    // }

    //afficher un livre
    public Book afficheBook(Long id){
        return bookRepository.findById(id).get();
    }

    //la liste des livres
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
