package data;

import javax.persistence.*;

@Entity
@Table(name = "Salle")
@NamedQueries({
    @NamedQuery(name = "Salle.findAll", query = "select o from Salle o"),
    @NamedQuery(name = "Salle.findByIdSalle", query = "select o from Salle o where o.idSalle = :idSalle"),
    @NamedQuery(name = "Salle.findByNom", query = "select o from Salle o where o.nom = :nom"),
    @NamedQuery(name = "Salle.findByAdresse", query = "select o from Salle o where o.adresse = :adresse")
        })
public class Salle implements java.io.Serializable {
    @Id
    @Column(name = "idSalle")
    private Integer idSalle;

    @Column(name = "nom")
    private String nom;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "capacite")
    private Integer capacite;

    @Column(name = "idGestionnaire")
    private Integer idGestionnaire;

    public Integer getIdSalle() {
        return this.idSalle;
    }

    public void setIdSalle(Integer idSalle) {
        this.idSalle = idSalle;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getCapacite() {
        return this.capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public Integer getIdGestionnaire() {
        return this.idGestionnaire;
    }

    public void setIdGestionnaire(Integer idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof Salle)) {
            return false;
        }
        Salle s = (Salle) o;
        return s.getIdSalle().equals(this.getIdSalle());
    }
}
