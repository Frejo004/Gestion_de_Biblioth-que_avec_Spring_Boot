package bj.highfiveuniversity.book.dto;

import java.util.Set;

import jakarta.validation.constraints.NotNull;

public class CreateAuthorDTO {

    private Long id;

    @NotNull(message = "Merci de bien vouloir renseigner le nom de l'auteur")
    private String nom;

    @NotNull(message = "Merci de bien vouloir renseigner le prenom de l'auteur")
    private String prenom;

    @NotNull(message = "Merci de bien vouloir renseigner la nationnalité de l'auteur")
    private String nationnalite;

    private Set<Long> livreId;


    public CreateAuthorDTO(Long id ,String nom, String prenom, String nationnalite) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.nationnalite = nationnalite;
    }


    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNationnalite() {
        return nationnalite;
    }
    public void setNationnalite(String nationnalite) {
        this.nationnalite = nationnalite;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Long> getLivreId() {
        return livreId;
    }


    public void setLivreId(Set<Long> livreId) {
        this.livreId = livreId;
    } 


    
}
