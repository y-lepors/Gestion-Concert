/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author yanis.lepors
 */
@Entity
@Table(name = "Artiste")
@NamedQueries({
    @NamedQuery(name = "Artiste.findAll", query = "SELECT a FROM Artiste a"),
    @NamedQuery(name = "Artiste.findByIdArtiste", query = "SELECT a FROM Artiste a WHERE a.idArtiste = :idArtiste"),
    @NamedQuery(name = "Artiste.findByNom", query = "SELECT a FROM Artiste a WHERE a.nom = :nom"),
    @NamedQuery(name = "Artiste.findByPrenom", query = "SELECT a FROM Artiste a WHERE a.prenom = :prenom"),
    @NamedQuery(name = "Artiste.findByPseudo", query = "SELECT a FROM Artiste a WHERE a.pseudo = :pseudo"),
    @NamedQuery(name = "Artiste.findByVille", query = "SELECT a FROM Artiste a WHERE a.ville = :ville"),
    @NamedQuery(name = "Artiste.findByAge", query = "SELECT a FROM Artiste a WHERE a.age = :age")})
public class Artiste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
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
    @JoinTable(name = "Groupe_Has_Artiste", joinColumns = {
        @JoinColumn(name = "idArtiste", referencedColumnName = "idArtiste")}, inverseJoinColumns = {
        @JoinColumn(name = "idGroupe", referencedColumnName = "idGroupe")})
    @ManyToMany
    private Set<Groupe> groupeSet;
    @OneToMany(mappedBy = "idArtiste")
    private Set<Concert> concertSet;

    public Artiste() {}

    public Artiste(Integer idArtiste) {
        this.idArtiste = idArtiste;
    }

    public Integer getIdArtiste() {
        return idArtiste;
    }

    public void setIdArtiste(Integer idArtiste) {
        this.idArtiste = idArtiste;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Groupe> getGroupeSet() {
        return groupeSet;
    }

    public void setGroupeSet(Set<Groupe> groupeSet) {
        this.groupeSet = groupeSet;
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
        hash += (idArtiste != null ? idArtiste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artiste)) {
            return false;
        }
        Artiste other = (Artiste) object;
        if ((this.idArtiste == null && other.idArtiste != null) || (this.idArtiste != null && !this.idArtiste.equals(other.idArtiste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Artiste[ idArtiste=" + idArtiste + " ]";
    }
    
}
