/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author yanis.lepors
 */
@Entity
@Table(name = "Salle")
@NamedQueries({
    @NamedQuery(name = "Salle.findAll", query = "SELECT s FROM Salle s"),
    @NamedQuery(name = "Salle.findByIdSalle", query = "SELECT s FROM Salle s WHERE s.idSalle = :idSalle"),
    @NamedQuery(name = "Salle.findByNom", query = "SELECT s FROM Salle s WHERE s.nom = :nom"),
    @NamedQuery(name = "Salle.findByAdresse", query = "SELECT s FROM Salle s WHERE s.adresse = :adresse"),
    @NamedQuery(name = "Salle.findByCapacite", query = "SELECT s FROM Salle s WHERE s.capacite = :capacite")})
public class Salle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSalle")
    private Integer idSalle;
    @Column(name = "nom")
    private String nom;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "capacite")
    private Integer capacite;
    @JoinColumn(name = "idGestionnaire", referencedColumnName = "idGestionnaire")
    @ManyToOne(optional = false)
    private Gestionnaire idGestionnaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSalle")
    private Set<Soiree> soireeSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSalle")
    private Set<Concert> concertSet;

    public Salle() {
    }

    public Salle(Integer idSalle) {
        this.idSalle = idSalle;
    }

    public Integer getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(Integer idSalle) {
        this.idSalle = idSalle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public Gestionnaire getIdGestionnaire() {
        return idGestionnaire;
    }

    public void setIdGestionnaire(Gestionnaire idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    public Set<Soiree> getSoireeSet() {
        return soireeSet;
    }

    public void setSoireeSet(Set<Soiree> soireeSet) {
        this.soireeSet = soireeSet;
    }

    public Set<Concert> getConcertSet() {
        return concertSet;
    }

    public void setConcertSet(Set<Concert> concertSet) {
        this.concertSet = concertSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalle != null ? idSalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salle)) {
            return false;
        }
        Salle other = (Salle) object;
        if ((this.idSalle == null && other.idSalle != null) || (this.idSalle != null && !this.idSalle.equals(other.idSalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Salle[ idSalle=" + idSalle + " ]";
    }
    
}
