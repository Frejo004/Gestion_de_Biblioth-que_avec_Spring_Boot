package bj.highfiveuniversity.book.mapper;

import bj.highfiveuniversity.book.dto.AuthorDTO;
import bj.highfiveuniversity.book.models.Author;

public class AuthorMapper {

    public static AuthorDTO toDto(Author auteur) {
        
        return new AuthorDTO(auteur.getId(), auteur.getNom(), auteur.getPrenom());
    }

}
