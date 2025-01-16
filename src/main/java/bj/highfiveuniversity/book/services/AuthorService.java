package bj.highfiveuniversity.book.services;

import org.springframework.beans.factory.annotation.Autowired;

import bj.highfiveuniversity.book.models.Author;
import bj.highfiveuniversity.book.repository.AuthorRepository;

public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    //ajouter un auteur
    public Author ajouterAuteur(Author author) {
        return authorRepository.save(author);
    }

    //afficher un auteur
    public Author afficherAuteur(Long id) {
        return authorRepository.findById(id).get();
    }

    // //suppiimer un auteur
    // public Author deleteAuteur(Long id) {
    //     return authorRepository.deleteById(id).get();
    // }

    // //mofidier un auteur
    // public Author updateAuthor(Long id) {
    //     return authorRepository.save(id).get();
    // }



}
