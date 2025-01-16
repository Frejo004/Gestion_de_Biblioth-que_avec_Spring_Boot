package bj.highfiveuniversity.book.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="Auteurs")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nom;
    private String prenom;
    private String nationnalite;

    @Transient
    private int age;

    @ManyToMany(mappedBy = "auteurs")
    private Set<Book> Livres;
    
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    //Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNationnalite() {
        return nationnalite;
    }
    public void setNationnalite(String nationnalite) {
        this.nationnalite = nationnalite;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



}
