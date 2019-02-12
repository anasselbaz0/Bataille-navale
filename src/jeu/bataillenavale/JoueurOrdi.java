package jeu.bataillenavale;

/**
 * Class JoueurOrdi represente le joueur ordinateur (adversaire)
 * @author Anass ELBAZ
 */
public class JoueurOrdi extends Joueur {

    public JoueurOrdi() {
        super("Ordinateur");
    }

    public JoueurOrdi(String nom) {
        super(nom);
    }

    /**
     * Fonction placant les bateaux dans la grille correspendante
     */
    public void placementBateaux() {
        for (int k = 0; k < NB_CROISEURS; k++) {
            Croiseur croiseur = new Croiseur(3);
            croiseur.setJoueur(this);
            this.getBateaux()[k] = (Bateau) croiseur;
            Boolean h = false;
            if ((int) (Math.random()*2458)%10 >= 5) h = true;
            croiseur.horizontal = h;
            int xc, yc;
            if(croiseur.horizontal != true) {
                do {
                    xc = (int) (Math.random()*54)%10;
                } while (xc+croiseur.getTaille() > 10);
                yc = (int) (Math.random()*65)%10;
                for (int i = xc; i < xc + croiseur.getTaille(); i++) {
                    this.getGrille().cases[i][yc].setBateau(croiseur);
                    croiseur.ajouteCase(this.getGrille().cases[i][yc]);
                }
            } else {
                do {
                    yc = (int) (Math.random()*54)%10;
                } while (yc+croiseur.getTaille() > 10);
                xc = (int) (Math.random()*65)%10;
                for (int i = yc; i < yc + croiseur.getTaille(); i++) {
                    this.getGrille().cases[xc][i].setBateau(croiseur);
                    croiseur.ajouteCase(this.getGrille().cases[xc][i]);
                }
            }
        }
        for (int k = 0; k < NB_DESTROYERS; k++) {
            Destroyer destroyer = new Destroyer(2);
            destroyer.setJoueur(this);
            this.getBateaux()[k + NB_CROISEURS] = (Bateau) destroyer;
            Boolean h = false;
            if ((int) (Math.random()*2458)%10 >= 5) h = true;
            destroyer.horizontal = h;
            int xd, yd;
            if(destroyer.horizontal != true) {
                do {
                    xd = (int) (Math.random()*54)%10;
                } while (xd+destroyer.getTaille() > 10);
                yd = (int) (Math.random()*65)%10;
                for (int i = xd; i < xd + destroyer.getTaille(); i++) {
                    this.getGrille().cases[i][yd].setBateau(destroyer);
                    destroyer.ajouteCase(this.getGrille().cases[i][yd]);
                }
            } else {
                do {
                    yd = (int) (Math.random()*54)%10;
                } while (yd+destroyer.getTaille() > 10);
                xd = (int) (Math.random()*65)%10;
                for (int i = yd; i < yd + destroyer.getTaille(); i++) {
                    this.getGrille().cases[xd][i].setBateau(destroyer);
                    destroyer.ajouteCase(this.getGrille().cases[xd][i]);
                }
            }
        }
        for (int k = 0; k < NB_PORTEAVIONS; k++) {
            PorteAvion porteAvion = new PorteAvion(4);
            porteAvion.setJoueur(this);
            this.getBateaux()[k + NB_CROISEURS + NB_DESTROYERS] = (Bateau) porteAvion;
            Boolean h = false;
            if ((int) (Math.random()*2458)%10 >= 5) h = true;
            porteAvion.horizontal = h;
            int xp, yp;
            if(porteAvion.horizontal != true) {
                do {
                    xp = (int) (Math.random()*54)%10;
                } while (xp + porteAvion.getTaille() > 10);
                yp = (int) (Math.random()*65)%10;
                for (int i = xp; i < xp + porteAvion.getTaille(); i++) {
                    this.getGrille().cases[i][yp].setBateau(porteAvion);
                    porteAvion.ajouteCase(this.getGrille().cases[i][yp]);
                }
            } else {
                do {
                    yp = (int) (Math.random()*54)%10;
                } while (yp+porteAvion.getTaille() > 10);
                xp = (int) (Math.random()*65)%10;
                for (int i = yp; i < yp + porteAvion.getTaille(); i++) {
                    this.getGrille().cases[xp][i].setBateau(porteAvion);
                    porteAvion.ajouteCase(this.getGrille().cases[xp][i]);
                }
            }
        }
    }

    /**
     * @param grilleAdverse la grille du joueur adversaire ou on va tirer
     */
    public void tir(Grille grilleAdverse) {
        System.out.println("-> Preparer le Tir (Joueur "+ this.getNom() +")");
        int x = (int) (Math.random()*98)%10;
        int y = (int) (Math.random()*42)%10;
        System.out.println("X : " + x);
        System.out.println("Y : " + y);
        grilleAdverse.tir(x, y);
    }
}
