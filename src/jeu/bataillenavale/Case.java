package jeu.bataillenavale;


/**
 * Class Case represente un element de la grille
 * @author Anass ELBAZ
 */

public class Case {
    /** Etat de la case */
    public Boolean etat;
    /** Le bateau qui occupe la case */
    private Bateau bateau;
    /** Grille mere */
    private Grille grille;

    /** Constructeur */
    public Case() {
        this.etat = false;
        this.bateau = null;
        this.grille = null;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public Bateau getBateau() {
        return bateau;
    }

    public void setBateau(Bateau bateau) {
        this.bateau = bateau;
    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }
}
