package data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Artiste")
@NamedQueries( {
    @NamedQuery(name = "Artiste.findAll", query = "select o from Artiste o"),
    @NamedQuery(name = "Artiste.findByIdArtiste", query = "select o from Artiste o where o.idArtiste = :idArtiste"),
    @NamedQuery(name = "Artiste.findByNom", query = "select o from Artiste o where o.nom = :nom"),
    @NamedQuery(name = "Artiste.findByPrenom", query = "select o from Artiste o where o.prenom = :prenom"),
    @NamedQuery(name = "Artiste.findByPseudo", query = "select o from Artiste o where o.pseudo = :pseudo"),
    @NamedQuery(name = "Artiste.findByVille", query = "select o from Artiste o where o.ville = :ville"),
    @NamedQuery(name = "Artiste.findByAge", query = "select o from Artiste o where o.age = :age")
})
public class Artiste implements Serializable {
    @Id
    @Column(name = "idArtiste")
    private Integer idArtiste;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "ville")
    private String ville;

    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "idConcert")
    private Set<Concert> concertSet;

    public Set<Concert> getConcertSet() {
        return concertSet;
    }

    public void setConcertSet(Set<Concert> concertSet) {
        this.concertSet = concertSet;
    }


    public Integer getIdArtiste() {
        return this.idArtiste;
    }

    public void setIdArtiste(Integer idArtiste) {
        this.idArtiste = idArtiste;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Artiste other = (Artiste) obj;
        if (this.idArtiste != other.idArtiste && (this.idArtiste == null || !this.idArtiste.equals(other.idArtiste))) {
            return false;
        }
        if ((this.nom == null) ? (other.nom != null) : !this.nom.equals(other.nom)) {
            return false;
        }
        if ((this.prenom == null) ? (other.prenom != null) : !this.prenom.equals(other.prenom)) {
            return false;
        }
        if ((this.pseudo == null) ? (other.pseudo != null) : !this.pseudo.equals(other.pseudo)) {
            return false;
        }
        if ((this.ville == null) ? (other.ville != null) : !this.ville.equals(other.ville)) {
            return false;
        }
        if (this.age != other.age && (this.age == null || !this.age.equals(other.age))) {
            return false;
        }
        return true;
    }
}
