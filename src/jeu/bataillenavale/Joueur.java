package jeu.bataillenavale;

/**
 * Class Joueur represente les joueurs dans le jeu
 * @author Anass ELBAZ
 */
public class Joueur {

    /** Nombre de Croiseurs que le joueur possede */
    public static final int NB_CROISEURS = 2;
    /** Nombre de Destroyers que le joueur possede */
    public static final int NB_DESTROYERS = 1;
    /** Nombre de Portes avions que le joueur possede */
    public static final int NB_PORTEAVIONS = 1;

    public String nom;
    /** Jeu mere */
    private Jeu jeu;
    /** Grille du joueur */
    private Grille grille;
    /** Tableau de bateaux que le joueur possede */
    private Bateau[] bateaux;

    /** Constructeur
     * @param nom nom du joueur*/
    public Joueur(String nom) {
        this.nom = nom;
        this.grille = new Grille();
        this.grille.joueur = this;
        this.setBateaux(new Bateau[NB_CROISEURS + NB_DESTROYERS + NB_PORTEAVIONS]);
    }

    public Bateau[] getBateaux() { return bateaux; }

    public void setBateaux(Bateau[] bateaux) { this.bateaux = bateaux; }

    public void setJeu(Jeu jeu) { this.jeu = jeu; }

    public String getNom() { return nom; }

    public Grille getGrille() { return grille; }

    /**
     * Fonction placant les bateaux dans la grille correspendante
     */
    public void placementBateaux() {
        System.out.println("-----------------------------------------------");
        System.out.println("**** Placer "+ NB_CROISEURS +" Croiseur(s) ****");
        for (int k = 0; k < NB_CROISEURS; k++) {
            Croiseur croiseur = new Croiseur(3);
            System.out.println((k+1)+". Croiseur (taille = "+croiseur.getTaille()+")");
            croiseur.setJoueur(this);
            this.getBateaux()[k] = (Bateau) croiseur;
            System.out.println("Orientation : (h/v)");
            croiseur.horizontal = Jeu.saisieOrientation();
            System.out.println("Position : ");
            int xc, yc;
            if(croiseur.horizontal != true) {
                do {
                    System.out.println("Entrer X : (ligne)");
                    xc = Jeu.saisiePosition();
                } while (xc + croiseur.getTaille() > 10);
                System.out.println("x = " + xc);
                System.out.println("Entrer y : (colonne)");
                yc = Jeu.saisiePosition();
                System.out.println("y = " + yc);
                for (int i = xc; i < xc + croiseur.getTaille(); i++) {
                    this.getGrille().cases[i][yc].setBateau(croiseur);
                    croiseur.ajouteCase(this.getGrille().cases[i][yc]);
                }
            } else {
                System.out.println("Entrer X : (ligne)");
                xc = Jeu.saisiePosition();
                System.out.println("x = " + xc);
                System.out.println("Entrer y : (colonne)");
                do {
                    yc = Jeu.saisiePosition();
                } while (yc + croiseur.getTaille() > 10);
                System.out.println("y = " + yc);
                for (int i = yc; i < yc + croiseur.getTaille(); i++) {
                    this.getGrille().cases[xc][i].setBateau(croiseur);
                    croiseur.ajouteCase(this.getGrille().cases[xc][i]);
                }
            }
            //this.grille.affiche();
        }
        System.out.println("-----------------------------------------------");
        System.out.println("**** Placer "+ NB_DESTROYERS +" Destroyer(s) ****");
        for (int k = 0; k < NB_DESTROYERS; k++) {
            Destroyer destroyer = new Destroyer(2);
            System.out.println("2. Destroyer (taille="+destroyer.getTaille()+")");
            destroyer.setJoueur(this);
            this.getBateaux()[k + NB_CROISEURS] = (Bateau) destroyer;
            System.out.println("Orientation : (h/v)");
            destroyer.horizontal = Jeu.saisieOrientation();
            System.out.println("Position : ");
            int xd, yd;
            if(destroyer.horizontal != true) {
                do {
                    System.out.println("Entrer X : (ligne)");
                    xd = Jeu.saisiePosition();
                } while (xd + destroyer.getTaille() > 10);
                System.out.println("x = " + xd);
                System.out.println("Entrer y : (colonne)");
                yd = Jeu.saisiePosition();
                System.out.println("y = " + yd);
                for (int i = xd; i < xd + destroyer.getTaille(); i++) {
                    this.getGrille().cases[i][yd].setBateau(destroyer);
                    destroyer.ajouteCase(this.getGrille().cases[i][yd]);
                }
            } else {
                System.out.println("Entrer X : (ligne)");
                xd = Jeu.saisiePosition();
                System.out.println("x = " + xd);
                System.out.println("Entrer y : (colonne)");
                do {
                    yd = Jeu.saisiePosition();
                } while (yd + destroyer.getTaille() > 10);
                System.out.println("y = " + yd);
                for (int i = yd; i < yd + destroyer.getTaille(); i++) {
                    this.getGrille().cases[xd][i].setBateau(destroyer);
                    destroyer.ajouteCase(this.getGrille().cases[xd][i]);
                }
            }
            //this.grille.affiche();
        }
        System.out.println("-----------------------------------------------");
        System.out.println("**** Placer "+ NB_PORTEAVIONS +" Porte(s) Avions ****");
        for (int k = 0; k < NB_PORTEAVIONS; k++) {
            PorteAvion porteAvion = new PorteAvion(4);
            System.out.println("3. Porte Avion (taille="+porteAvion.getTaille()+")");
            porteAvion.setJoueur(this);
            this.getBateaux()[k + NB_CROISEURS + NB_DESTROYERS] = (Bateau) porteAvion;
            System.out.println("Orientation : (h/v)");
            porteAvion.horizontal = Jeu.saisieOrientation();
            System.out.println("Position : ");
            int xp, yp;
            if(porteAvion.horizontal != true) {
                do {
                    System.out.println("Entrer X : (ligne)");
                    xp = Jeu.saisiePosition();
                } while (xp + porteAvion.getTaille() > 10);
                System.out.println("x = " + xp);
                System.out.println("Entrer y : (colonne)");
                yp = Jeu.saisiePosition();
                System.out.println("y = " + yp);
                for (int i = xp; i < xp + porteAvion.getTaille(); i++) {
                    this.getGrille().cases[i][yp].setBateau(porteAvion);
                    porteAvion.ajouteCase(this.getGrille().cases[i][yp]);
                }
            } else {
                System.out.println("Entrer X : (ligne)");
                xp = Jeu.saisiePosition();
                System.out.println("x = " + xp);
                System.out.println("Entrer y : (colonne)");
                do {
                    yp = Jeu.saisiePosition();
                } while (yp + porteAvion.getTaille() > 10);
                System.out.println("y = " + yp);
                for (int i = yp; i < yp + porteAvion.getTaille(); i++) {
                    this.getGrille().cases[xp][i].setBateau(porteAvion);
                    porteAvion.ajouteCase(this.getGrille().cases[xp][i]);
                }
            }
            //this.grille.affiche();
        }
        System.out.println("-----------------------------------------------");
    }

    /**
     * @return true si le joueur a perdu (tout les bateaux ont coules), false sinon
     */
    public Boolean aPerdu() {
        int rep = 1;
        Bateau[] tb = this.getBateaux();
        for (int i = 0; i < tb.length; i++) {
            Bateau b = tb[i];
            if ( !(b.estCoule()) )
                rep = 0;
        }
        if (rep == 0)
            return false;
        else
            return true;
    }

    /**
     * @param grilleAdverse la grille du joueur adversaire ou on va tirer
     */
    public void tir(Grille grilleAdverse) {
        System.out.println("-> Preparer le Tir");
        System.out.println("X : ");
        int x = Jeu.saisiePosition();
        System.out.println("Y : ");
        int y = Jeu.saisiePosition();
        grilleAdverse.tir(x, y);
    }
}
