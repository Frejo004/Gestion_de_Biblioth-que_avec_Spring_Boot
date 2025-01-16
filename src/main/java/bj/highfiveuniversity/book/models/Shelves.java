package bj.highfiveuniversity.book.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table( name = "etageres")
public class Shelves {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String numero;

    @Column ( nullable = true)
    private String emplacemant;



    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmplacemant() {
        return emplacemant;
    }

    public void setEmplacemant(String emplacemant) {
        this.emplacemant = emplacemant;
    }

    
}
