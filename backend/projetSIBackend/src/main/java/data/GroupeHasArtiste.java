package data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Groupe_Has_Artiste")
@NamedQueries({
    @NamedQuery(name = "GroupeHasArtiste.findAll", query = "select o from GroupeHasArtiste o"),
    @NamedQuery(name = "GroupeHasArtiste.findByIdGroupe", query = "select o from GroupeHasArtiste o where o.idGroupe = :idGroupe"),
    @NamedQuery(name = "GroupeHasArtiste.findByIdArtiste", query = "select o from GroupeHasArtiste o where o.idArtiste = :idArtiste")
})
public class GroupeHasArtiste implements Serializable {
    @Id
    @Column(name = "idGroupe")
    private Integer idGroupe;

    @Id
    @Column(name = "idArtiste")
    private Integer idArtiste;

    public Integer getIdGroupe() {
        return this.idGroupe;
    }

    public void setIdGroupe(Integer idGroupe) {
        this.idGroupe = idGroupe;
    }

    public Integer getIdArtiste() {
        return this.idArtiste;
    }

    public void setIdArtiste(Integer idArtiste) {
        this.idArtiste = idArtiste;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GroupeHasArtiste other = (GroupeHasArtiste) obj;
        if (this.idGroupe != other.idGroupe && (this.idGroupe == null || !this.idGroupe.equals(other.idGroupe))) {
            return false;
        }
        if (this.idArtiste != other.idArtiste && (this.idArtiste == null || !this.idArtiste.equals(other.idArtiste))) {
            return false;
        }
        return true;
    }
}
