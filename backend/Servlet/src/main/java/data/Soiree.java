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
@Table(name = "Soiree")
@NamedQueries({
    @NamedQuery(name = "Soiree.findAll", query = "SELECT s FROM Soiree s"),
    @NamedQuery(name = "Soiree.findByIdSoiree", query = "SELECT s FROM Soiree s WHERE s.idSoiree = :idSoiree"),
    @NamedQuery(name = "Soiree.findByNom", query = "SELECT s FROM Soiree s WHERE s.nom = :nom")
    })
public class Soiree implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSoiree")
    private Integer idSoiree;
    @Column(name = "nom")
    private String nom;
    @JoinColumn(name = "idSalle", referencedColumnName = "idSalle")
    @ManyToOne(optional = false)
    private Salle idSalle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoiree")
    private Set<Concert> concertSet;

    public Soiree() {
    }

    public Soiree(Integer idSoiree) {
        this.idSoiree = idSoiree;
    }

    public Integer getIdSoiree() {
        return idSoiree;
    }

    public void setIdSoiree(Integer idSoiree) {
        this.idSoiree = idSoiree;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Salle getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(Salle idSalle) {
        this.idSalle = idSalle;
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
        hash += (idSoiree != null ? idSoiree.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soiree)) {
            return false;
        }
        Soiree other = (Soiree) object;
        if ((this.idSoiree == null && other.idSoiree != null) || (this.idSoiree != null && !this.idSoiree.equals(other.idSoiree))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Soiree[ idSoiree=" + idSoiree + " ]";
    }
    
}
