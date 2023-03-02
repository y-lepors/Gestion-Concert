package mongoPojo;

/**
 * Pojo pour la collection Mongo qui contient une image ou un article
 */
public class ImgOrArticle {

    private String url;

    private String type;

    private String date;

    private String titre;

    private String auteur;

    private Lier lier;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String Auteur) {
        this.auteur = Auteur;
    }

    public Lier getLier() {
        return lier;
    }

    public void setLier(Lier lier) {
        this.lier = lier;
    }

    public ImgOrArticle(String url, String type, String date, String titre, String Auteur, Lier lier) {
        super();
        this.url = url;
        this.type = type;
        this.date = date;
        this.titre = titre;
        this.auteur = Auteur;
        this.lier = lier;
    }

    public ImgOrArticle() {
        super();
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(auteur, date, lier, titre, type, url, lier);
    }

    @Override
    public  boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ImgOrArticle other = (ImgOrArticle) obj;
        return java.util.Objects.equals(auteur, other.auteur) && java.util.Objects.equals(date, other.date)
                && java.util.Objects.equals(lier, other.lier) && java.util.Objects.equals(titre, other.titre)
                && java.util.Objects.equals(type, other.type) && java.util.Objects.equals(url, other.url);
    }


}
