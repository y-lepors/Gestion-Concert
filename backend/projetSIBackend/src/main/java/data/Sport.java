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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ercar
 */
@Entity
@Table(name = "sport")
@NamedQueries({
    @NamedQuery(name = "Sport.findAll", query = "SELECT s FROM Sport s"),
    @NamedQuery(name = "Sport.findByCodeSport", query = "SELECT s FROM Sport s WHERE s.codeSport = :codeSport"),
    @NamedQuery(name = "Sport.findByIntitule", query = "SELECT s FROM Sport s WHERE s.intitule = :intitule")})
public class Sport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code_sport")
    private Short codeSport;
    @Column(name = "intitule")
    private String intitule;
    @OneToMany(mappedBy = "codeSport")
    private Set<Discipline> disciplineSet;

    public Sport() {
    }

    public Sport(Short codeSport) {
        this.codeSport = codeSport;
    }

    public Short getCodeSport() {
        return codeSport;
    }

    public void setCodeSport(Short codeSport) {
        this.codeSport = codeSport;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Set<Discipline> getDisciplineSet() {
        return disciplineSet;
    }

    public void setDisciplineSet(Set<Discipline> disciplineSet) {
        this.disciplineSet = disciplineSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeSport != null ? codeSport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sport)) {
            return false;
        }
        Sport other = (Sport) object;
        if ((this.codeSport == null && other.codeSport != null) || (this.codeSport != null && !this.codeSport.equals(other.codeSport))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Sport[ codeSport=" + codeSport + " ]";
    }
    
}
