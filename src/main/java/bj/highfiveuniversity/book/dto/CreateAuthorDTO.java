package bj.highfiveuniversity.book.dto;

public class CreateAuthorDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String nationnalite;


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


}
