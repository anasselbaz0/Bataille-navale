package jeu.bataillenavale;

/**
 * Class Grille represente le game space
 * @author Anass ELBAZ
 */

public class Grille {
    /** Nombre de colonnes de la grille */
    public static final int NB_COLONNES = 10;
    /** Nombre de lignes de la grille */
    public static final int NB_LIGNES = 10;

    /** Matrice de cases :: represente la grille en integrite */
    public Case[][] cases;
    /** Joueur proprietaire de la grille */
    public Joueur joueur;

    /** Constructeur */
    public Grille() {
        this.cases = new Case[NB_COLONNES][NB_LIGNES];
        for (int i = 0; i < NB_LIGNES; i++) {
            for (int j = 0; j < NB_COLONNES; j++) {
                this.cases[i][j] = new Case();
                this.cases[i][j].setGrille(this);
            }
        }
    }

    /**
     * @param x abscisse de la case qu'on veut faire un tir sur
     * @param y ordonne de la case qu'on veut faire un tir sur
     */
    public void tir(Integer x, Integer y) {
        if (this.cases[x][y].getEtat()) {
            this.cases[x][y].setEtat(false);
            System.out.println("I got uu!");
        } else {
            System.out.println("Oops!");
        }
    }

    public void afficheTirs() {
        System.out.print(' ');
        System.out.print(' ');
        System.out.print(' ');
        for (int i = 0; i < NB_LIGNES; i++) {
            System.out.print(i + " ");
        }
        System.out.print('\n');
        for (int i = 0; i < NB_LIGNES; i++) {
            System.out.print(" "+i+" ");
            for (int j = 0; j < NB_COLONNES; j++) {
                if (this.cases[i][j].getEtat() == true)
                    System.out.print("O ");
                else
                    System.out.print("  ");
            }
            System.out.print('\n');
        }
    }

    /**
     * Affichage de la grille
     * On affiche les axes et les bateaux
     */
    public void affiche() {
        System.out.print(' ');
        System.out.print(' ');
        System.out.print(' ');
        for (int i = 0; i < NB_LIGNES; i++) {
            System.out.print(i + " ");
        }
        System.out.print('\n');
        for (int i = 0; i < NB_LIGNES; i++) {
            System.out.print(" "+i+" ");
            for (int j = 0; j < NB_COLONNES; j++) {
                if (this.cases[i][j].getEtat() == true)
                    System.out.print("O ");
                else
                    System.out.print("  ");
            }
            System.out.print('\n');
        }
    }

    public void place(Bateau b, Integer x, Integer y) {

    }
}



































