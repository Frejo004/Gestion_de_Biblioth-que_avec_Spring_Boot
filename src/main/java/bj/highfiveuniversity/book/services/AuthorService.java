package bj.highfiveuniversity.book.services;

import java.util.List;

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

    //afficher tout les auteur
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    //suppiimer un auteur
    public void deleteAuteur(Long id) {
        authorRepository.deleteById(id);
    }

    //mofidier un auteur
    public void updateAuthor(Author newauteur, Long id) {
        Author MonAuteur = afficherAuteur(id);

        MonAuteur.setNom(newauteur.getNom());
        MonAuteur.setPrenom(newauteur.getPrenom());
        MonAuteur.setNationnalite(newauteur.getNationnalite());
        MonAuteur.setAge(newauteur.getAge());
        
        authorRepository.save(MonAuteur);
    }


    //rechercher un auteur
    public List<Author> searchAuthor(String title) {
        return authorRepository.findByNomContaining();
    }

}
