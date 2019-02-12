package jeu.bataillenavale;

import java.util.Arrays;

/**
 * Class Bateau represente les targets dans le jeu
 * Il est abstrait
 * Il existe 3 types de bateaux: Croiseur, Destroyer et Porte avions
 * @author Anass ELBAZ
 */
abstract class Bateau {
    /** Parametres du bateau */
    public Boolean horizontal;
    /** Taille du bateau */
    protected Integer taille;
    /** Proprietaire */
    protected Joueur joueur;
    /** Tableau de type Case, contient les cases que le bateau occupe */
    protected Case[] cases;

    /**
     * Constructeur du class
     * @param taille taille du bateau
     */
    public Bateau(Integer taille) { this.taille = taille; }

    public void setJoueur(Joueur joueur) { this.joueur = joueur; }

    public Case[] getCases() { return cases; }

    public void setCases(Case[] cases) { this.cases = cases; }

    public Integer getTaille() { return taille; }

    /**
     * @return Une valeur boolean,
     * true si le bateau est coule (toutes les cases du bateau sont a l'etat false),
     * false sinon
     */
    public Boolean estCoule() {
        for (Case c:this.getCases()) {
            if (c.getEtat().equals(true)){
                return Boolean.valueOf(false);
            }
        }
        return Boolean.valueOf(true);
    }

    /**
     * @param c Case qu'on veut ajouter a notre bateau
     */
    public void ajouteCase(Case c) {
        c.setEtat(true);
        if (this.getCases() == null) {
            this.setCases(new Case[1]);
            this.getCases()[0] = c;
        } else {
            Case[] m = Arrays.copyOf(this.getCases(), this.getCases().length + 1);
            m[this.getCases().length] = c;
            this.setCases(m);
        }
    }

    abstract public String getSymbole();
}
