/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author yanis.lepors
 */
@Entity
@Table(name = "Gestionnaire")
@NamedQueries({
    @NamedQuery(name = "Gestionnaire.findAll", query = "SELECT g FROM Gestionnaire g"),
    @NamedQuery(name = "Gestionnaire.findByIdGestionnaire", query = "SELECT g FROM Gestionnaire g WHERE g.idGestionnaire = :idGestionnaire"),
    @NamedQuery(name = "Gestionnaire.findByNom", query = "SELECT g FROM Gestionnaire g WHERE g.nom = :nom"),
    @NamedQuery(name = "Gestionnaire.findByPresident", query = "SELECT g FROM Gestionnaire g WHERE g.president = :president"),
    @NamedQuery(name = "Gestionnaire.findByTypeGestionnaire", query = "SELECT g FROM Gestionnaire g WHERE g.typeGestionnaire = :typeGestionnaire")})
public class Gestionnaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGestionnaire")
    private Integer idGestionnaire;
    @Column(name = "nom")
    private String nom;
    @Column(name = "president")
    private String president;
    @Column(name = "typeGestionnaire")
    private String typeGestionnaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGestionnaire")
    private Set<Salle> salleSet;

    public Gestionnaire() {
    }

    public Gestionnaire(Integer idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    public Integer getIdGestionnaire() {
        return idGestionnaire;
    }

    public void setIdGestionnaire(Integer idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getTypeGestionnaire() {
        return typeGestionnaire;
    }

    public void setTypeGestionnaire(String typeGestionnaire) {
        this.typeGestionnaire = typeGestionnaire;
    }

    public Set<Salle> getSalleSet() {
        return salleSet;
    }

    public void setSalleSet(Set<Salle> salleSet) {
        this.salleSet = salleSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGestionnaire != null ? idGestionnaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gestionnaire)) {
            return false;
        }
        Gestionnaire other = (Gestionnaire) object;
        if ((this.idGestionnaire == null && other.idGestionnaire != null) || (this.idGestionnaire != null && !this.idGestionnaire.equals(other.idGestionnaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Gestionnaire[ idGestionnaire=" + idGestionnaire + " ]";
    }
    
}
