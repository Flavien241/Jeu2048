package fr.univsavoie.java.jeu2048;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Création d'un nouvel objet Jeu2048 avec une grille de 7x7 et comme objectif 2048
        Jeu2048 jeu = new Jeu2048(3, 3, 2048);

        // Initialisation des objets pour la sauvegarde et la récupération de l'état du jeu
        Sauvegarde sauvegarde = new Sauvegarde(jeu);
        Récupération recup = new Récupération(jeu);

        // Création de l'objet GrilleCanvas pour dessiner la grille du jeu
        GrilleCanvas dessin = new GrilleCanvas(jeu);

        // Création d'un JPanel (non utilisé dans ce code)
        JPanel panel = new JPanel();

        // Initialisation du jeu avec une nouvelle partie
        jeu.nouveauJeu();

        // Création d'un objet Logger pour enregistrer les événements du jeu
        Logger logger = new Logger(jeu);

        // Création de la fenêtre principale du jeu (GrilleFrame)
        GrilleFrame grille1 = new GrilleFrame(jeu, dessin, panel, sauvegarde, recup, logger);

        // Positionnement de la fenêtre au centre de l'écran
        grille1.setLocationRelativeTo(null);

        // Rendre la fenêtre focusable
        grille1.setFocusable(true);

        // Affichage de la fenêtre
        grille1.setVisible(true);
    }
}
