package data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Groupe")
@NamedQueries( {
    @NamedQuery(name = "Groupe.findAll", query = "select o from Groupe o"),
    @NamedQuery(name = "Groupe.findByIdGroupe", query = "select o from Groupe o where o.idGroupe = :idGroupe"),
    @NamedQuery(name = "Groupe.findByNom", query = "select o from Groupe o where o.nom = :nom")
})
public class Groupe implements Serializable {
    @Id
    @Column(name = "idGroupe")
    private Integer idGroupe;

    @Column(name = "nom")
    private String nom;

    public Integer getIdGroupe() {
        return this.idGroupe;
    }

    public void setIdGroupe(Integer idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Groupe other = (Groupe) obj;
        if (this.idGroupe != other.idGroupe && (this.idGroupe == null || !this.idGroupe.equals(other.idGroupe))) {
            return false;
        }
        if ((this.nom == null) ? (other.nom != null) : !this.nom.equals(other.nom)) {
            return false;
        }
        return true;
    }
}
