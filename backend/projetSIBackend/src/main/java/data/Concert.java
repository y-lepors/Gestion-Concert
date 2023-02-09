package data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Concert")
@NamedQueries( {
    @NamedQuery(name = "Concert.findAll", query = "select o from Concert o"),
    @NamedQuery(name = "Concert.findByIdConcert", query = "select o from Concert o where o.idConcert = :idConcert"),
    @NamedQuery(name = "Concert.findByIdArtiste", query = "select o from Concert o where o.idArtiste = :idArtiste"),
    @NamedQuery(name = "Concert.findByIdGroupe", query = "select o from Concert o where o.idGroupe = :idGroupe"),
    @NamedQuery(name = "Concert.findByIdSalle", query = "select o from Concert o where o.idSalle = :idSalle"),
    @NamedQuery(name = "Concert.findByIdSoiree", query = "select o from Concert o where o.idSoiree = :idSoiree")
})
public class Concert implements Serializable {
    @Id
    @Column(name = "idConcert")
    private Integer idConcert;

    @Column(name = "dateConcert")
    private java.sql.Timestamp dateConcert;

    @Column(name = "duree")
    private Integer duree;

    @Column(name = "idArtiste")
    private Integer idArtiste;

    @Column(name = "idGroupe")
    private Integer idGroupe;

    @Column(name = "idSalle")
    private Integer idSalle;

    @Column(name = "idSoiree")
    private Integer idSoiree;

    @OneToMany(mappedBy = "idConcert")
    private Set<Artiste> artisteSet;

    public Set<Artiste> getArtisteSet() {
        return artisteSet;
    }

    public void setArtisteSet(Set<Artiste> artisteSet) {
        this.artisteSet = artisteSet;
    }

    public Integer getIdConcert() {
        return this.idConcert;
    }

    public void setIdConcert(Integer idConcert) {
        this.idConcert = idConcert;
    }

    public java.sql.Timestamp getDateConcert() {
        return this.dateConcert;
    }

    public void setDateConcert(java.sql.Timestamp dateConcert) {
        this.dateConcert = dateConcert;
    }

    public Integer getDuree() {
        return this.duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Integer getIdArtiste() {
        return this.idArtiste;
    }

    public void setIdArtiste(Integer idArtiste) {
        this.idArtiste = idArtiste;
    }

    public Integer getIdGroupe() {
        return this.idGroupe;
    }

    public void setIdGroupe(Integer idGroupe) {
        this.idGroupe = idGroupe;
    }

    public Integer getIdSalle() {
        return this.idSalle;
    }

    public void setIdSalle(Integer idSalle) {
        this.idSalle = idSalle;
    }

    public Integer getIdSoiree() {
        return this.idSoiree;
    }

    public void setIdSoiree(Integer idSoiree) {
        this.idSoiree = idSoiree;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Concert other = (Concert) obj;
        if (this.idConcert != other.idConcert && (this.idConcert == null || !this.idConcert.equals(other.idConcert))) {
            return false;
        }
        if (this.dateConcert != other.dateConcert && (this.dateConcert == null || !this.dateConcert.equals(other.dateConcert))) {
            return false;
        }
        if (this.duree != other.duree && (this.duree == null || !this.duree.equals(other.duree))) {
            return false;
        }
        if (this.idArtiste != other.idArtiste && (this.idArtiste == null || !this.idArtiste.equals(other.idArtiste))) {
            return false;
        }
        if (this.idGroupe != other.idGroupe && (this.idGroupe == null || !this.idGroupe.equals(other.idGroupe))) {
            return false;
        }
        if (this.idSalle != other.idSalle && (this.idSalle == null || !this.idSalle.equals(other.idSalle))) {
            return false;
        }
        if (this.idSoiree != other.idSoiree && (this.idSoiree == null || !this.idSoiree.equals(other.idSoiree))) {
            return false;
        }
        return true;
    }
}
