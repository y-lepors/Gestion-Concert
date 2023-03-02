package mongoPojo;

import java.util.List;
import java.util.Objects;

public class Lier {

    private List<String> concert;

    private List<String> artiste;

    private List<String> groupe;

    private List<String> soiree;

    private List<String> salle;

    public List<String> getConcert() {
        return concert;
    }

    public void setConcert(List<String> Concert) {
        this.concert = Concert;
    }

    public List<String> getArtiste() {
        return artiste;
    }

    public void setArtiste(List<String> Artiste) {
        this.artiste = Artiste;
    }

    public List<String> getGroupe() {
        return groupe;
    }

    public void setGroupe(List<String> Groupe) {
        this.groupe = Groupe;
    }

    public List<String> getSoiree() {
        return soiree;
    }

    public void setSoiree(List<String> Soiree) {
        this.soiree = Soiree;
    }

    public List<String> getSalle() {
        return salle;
    }

    public void setSalle(List<String> Salle) {
        this.salle = Salle;
    }

    public Lier(List<String> Concert, List<String> Artiste, List<String> Groupe, List<String> Soiree, List<String> Salle) {
        super();
        this.concert = Concert;
        this.artiste = Artiste;
        this.groupe = Groupe;
        this.soiree = Soiree;
        this.salle = Salle;
    }

    public Lier() {
        super();
    }

    @Override
    public int hashCode() {
        return Objects.hash(concert, artiste, groupe, salle, soiree);
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
        return Objects.equals(artiste, other.artiste) && Objects.equals(concert, other.concert) && Objects.equals(groupe, other.groupe) && Objects.equals(salle, other.salle) && Objects.equals(soiree, other.soiree);
    }
}
