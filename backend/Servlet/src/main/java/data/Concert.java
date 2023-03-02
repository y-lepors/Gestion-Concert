/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author yanis.lepors
 */
@Entity
@Table(name = "concert")
@NamedQueries({
    @NamedQuery(name = "Concert.findAll", query = "SELECT c FROM Concert c"),
    @NamedQuery(name = "Concert.findByIdConcert", query = "SELECT c FROM Concert c WHERE c.idConcert = :idConcert"),
    @NamedQuery(name = "Concert.findByDateConcert", query = "SELECT c FROM Concert c WHERE c.dateConcert = :dateConcert"),
    @NamedQuery(name = "Concert.findByDuree", query = "SELECT c FROM Concert c WHERE c.duree = :duree")})
public class Concert implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_concert")
    private Integer idConcert;
    @Column(name = "date_concert")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateConcert;
    @Column(name = "duree")
    private Integer duree;
    @JoinColumn(name = "id_artiste", referencedColumnName = "id_artiste")
    @ManyToOne
    private Artiste idArtiste;
    @JoinColumn(name = "id_groupe", referencedColumnName = "id_groupe")
    @ManyToOne
    private Groupe idGroupe;
    @JoinColumn(name = "id_salle", referencedColumnName = "id_salle")
    @ManyToOne(optional = false)
    private Salle idSalle;
    @JoinColumn(name = "id_soiree", referencedColumnName = "id_soiree")
    @ManyToOne(optional = false)
    private Soiree idSoiree;

    public Concert() {
    }

    public Concert(Integer idConcert) {
        this.idConcert = idConcert;
    }

    public Integer getIdConcert() {
        return idConcert;
    }

    public void setIdConcert(Integer idConcert) {
        this.idConcert = idConcert;
    }

    public Date getDateConcert() {
        return dateConcert;
    }

    public void setDateConcert(Date dateConcert) {
        this.dateConcert = dateConcert;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Artiste getIdArtiste() {
        return idArtiste;
    }

    public void setIdArtiste(Artiste idArtiste) {
        this.idArtiste = idArtiste;
    }

    public Groupe getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(Groupe idGroupe) {
        this.idGroupe = idGroupe;
    }

    public Salle getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(Salle idSalle) {
        this.idSalle = idSalle;
    }

    public Soiree getIdSoiree() {
        return idSoiree;
    }

    public void setIdSoiree(Soiree idSoiree) {
        this.idSoiree = idSoiree;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConcert != null ? idConcert.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concert)) {
            return false;
        }
        Concert other = (Concert) object;
        if ((this.idConcert == null && other.idConcert != null) || (this.idConcert != null && !this.idConcert.equals(other.idConcert))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Concert[ idConcert=" + idConcert + " ]";
    }
    
}
