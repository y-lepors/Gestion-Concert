package data;

import javax.persistence.*;

@Entity
@Table(name = "Soiree")
@NamedQueries( {
    @NamedQuery(name = "Soiree.findAll", query = "select o from Soiree o"),
    @NamedQuery(name = "Soiree.findByIdSoiree", query = "select o from Soiree o where o.idSoiree = :idSoiree"),
    @NamedQuery(name = "Soiree.findByNom", query = "select o from Soiree o where o.nom = :nom"),
    @NamedQuery(name = "Soiree.findByIdSalle", query = "select o from Soiree o where o.idSalle = :idSalle")
})
public class Soiree implements java.io.Serializable {

    @Id
    @Column(name = "idSoiree")
    private Integer idSoiree;

    @Column(name = "nom")
    private String nom;

    @Column(name = "idSalle")
    private Integer idSalle;

    public Integer getIdSoiree() {
        return this.idSoiree;
    }

    public void setIdSoiree(Integer idSoiree) {
        this.idSoiree = idSoiree;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getIdSalle() {
        return this.idSalle;
    }

    public void setIdSalle(Integer idSalle) {
        this.idSalle = idSalle;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof Soiree)) {
            return false;
        }
        Soiree s = (Soiree) o;
        return s.getIdSoiree().equals(this.getIdSoiree());
    }
}
