package mongoPojo;

import java.util.List;
import java.util.Objects;

public class Lier {

    private List<String> Concert;

    private List<String> Artiste;

    private List<String> Groupe;

    private List<String> Soiree;

    private List<String> Salle;

    public List<String> getConcert() {
        return Concert;
    }

    public void setConcert(List<String> Concert) {
        this.Concert = Concert;
    }

    public List<String> getArtiste() {
        return Artiste;
    }

    public void setArtiste(List<String> Artiste) {
        this.Artiste = Artiste;
    }

    public List<String> getGroupe() {
        return Groupe;
    }

    public void setGroupe(List<String> Groupe) {
        this.Groupe = Groupe;
    }

    public List<String> getSoiree() {
        return Soiree;
    }

    public void setSoiree(List<String> Soiree) {
        this.Soiree = Soiree;
    }

    public List<String> getSalle() {
        return Salle;
    }

    public void setSalle(List<String> Salle) {
        this.Salle = Salle;
    }

    public Lier(List<String> Concert, List<String> Artiste, List<String> Groupe, List<String> Soiree, List<String> Salle) {
        super();
        this.Concert = Concert;
        this.Artiste = Artiste;
        this.Groupe = Groupe;
        this.Soiree = Soiree;
        this.Salle = Salle;
    }

    public Lier() {
        super();
    }

    @Override
    public int hashCode() {
        return Objects.hash(Artiste, Concert, Groupe, Salle, Soiree);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Lier other = (Lier) obj;
        return Objects.equals(Artiste, other.Artiste) && Objects.equals(Concert, other.Concert) && Objects.equals(Groupe, other.Groupe) && Objects.equals(Salle, other.Salle) && Objects.equals(Soiree, other.Soiree);
    }
}
