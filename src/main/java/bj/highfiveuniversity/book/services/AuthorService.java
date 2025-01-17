package bj.highfiveuniversity.book.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import bj.highfiveuniversity.book.dto.AuthorDTO;
import bj.highfiveuniversity.book.mapper.AuthorMapper;
import bj.highfiveuniversity.book.models.Author;
import bj.highfiveuniversity.book.repository.AuthorRepository;


@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    //ajouter un auteur
    public Author ajouterAuteur(Author author) {
        return authorRepository.save(author);
    }

    //afficher un auteur
    public AuthorDTO afficherAuteur(Long id) {
        Author auteur =  authorRepository.findById(id).get();
        return AuthorMapper.toDto(auteur);
    }

    //afficher tout les auteurs
    public List<AuthorDTO> getAllAuthors() {
        List<Author> auteurs =  authorRepository.findAll();
        List<AuthorDTO> auteursDTO = new ArrayList<>();

        for(Author auteur : auteurs) {
            AuthorDTO auteurDto = AuthorMapper.toDto(auteur);
            auteursDTO.add(auteurDto);
        }
        return auteursDTO;
    }

    //suppiimer un auteur
    public void deleteAuteur(Long id) {
        authorRepository.deleteById(id);
    }

    //mofidier un auteur
    public Author updateAuthor(Author newauteur, Long id) {
        Author MonAuteur = authorRepository.findById(id).get();

        MonAuteur.setNom(newauteur.getNom());
        MonAuteur.setPrenom(newauteur.getPrenom());
        MonAuteur.setNationnalite(newauteur.getNationnalite());
        MonAuteur.setAge(newauteur.getAge());
        
        return authorRepository.save(MonAuteur);
    }


    //rechercher un auteur
    public List<Author> searchAuthor(@RequestParam String nom) {
        return authorRepository.findByNomContaining(nom);
    }

}
