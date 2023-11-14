package tn.esprit.kaddemproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer idEtudiant;
    private String nomE;
    private String prenomE;
    @Enumerated(EnumType.STRING)
    private Option optionE;
    
    public Etudiant(String nomE, String prenomE, Option optionE) {
        super();
        this.nomE = nomE;
        this.prenomE = prenomE;
        this.optionE = optionE;
    }
    
    // public void setIdEtudiant(Integer idEtudiant) {
    //     this.idEtudiant = idEtudiant;
    // }
    @OneToMany(mappedBy="etudiant")
    @JsonIgnore
    private List<Contrat> contrats;

    @ManyToOne
    @JsonIgnore
    private Departement departement;

    @ManyToMany
    private List<Equipe> equipes;


}
