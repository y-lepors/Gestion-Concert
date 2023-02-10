package data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Gestionnaire")
@NamedQueries( {
    @NamedQuery(name = "Gestionnaire.findAll", query = "select o from Gestionnaire o"),
    @NamedQuery(name = "Gestionnaire.findByIdGestionnaire", query = "select o from Gestionnaire o where o.idGestionnaire = :idGestionnaire"),
    @NamedQuery(name = "Gestionnaire.findByNom", query = "select o from Gestionnaire o where o.nom = :nom"),
    @NamedQuery(name = "Gestionnaire.findByPresident", query = "select o from Gestionnaire o where o.president = :president"),
    @NamedQuery(name = "Gestionnaire.findByTypeGestionnaire", query = "select o from Gestionnaire o where o.typeGestionnaire = :typeGestionnaire")
})
public class Gestionnaire implements Serializable {
    @Id
    @Column(name = "idGestionnaire")
    private Integer idGestionnaire;

    @Column(name = "nom")
    private String nom;

    @Column(name = "president")
    private String president;

    @Column(name = "typeGestionnaire")
    private String typeGestionnaire;

    public Integer getIdGestionnaire() {
        return this.idGestionnaire;
    }

    public void setIdGestionnaire(Integer idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPresident() {
        return this.president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getTypeGestionnaire() {
        return this.typeGestionnaire;
    }

    public void setTypeGestionnaire(String typeGestionnaire) {
        this.typeGestionnaire = typeGestionnaire;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gestionnaire other = (Gestionnaire) obj;
        if (this.idGestionnaire != other.idGestionnaire && (this.idGestionnaire == null || !this.idGestionnaire.equals(other.idGestionnaire))) {
            return false;
        }
        if ((this.nom == null) ? (other.nom != null) : !this.nom.equals(other.nom)) {
            return false;
        }
        if ((this.president == null) ? (other.president != null) : !this.president.equals(other.president)) {
            return false;
        }
        if ((this.typeGestionnaire == null) ? (other.typeGestionnaire != null) : !this.typeGestionnaire.equals(other.typeGestionnaire)) {
            return false;
        }
        return true;
    }
}
