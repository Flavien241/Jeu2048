package fr.univsavoie.java.jeu2048;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RécupérationActionListener implements ActionListener {
    private Jeu2048 jeu;
    private Récupération récupérer;
    private GrilleCanvas dessin;
    private GrilleFrame grilleFrame;
    private Logger logger;

    // Constructeur prenant en paramètres les objets nécessaires
    public RécupérationActionListener(Jeu2048 jeu, Récupération récupérer, GrilleCanvas dessin, GrilleFrame grilleFrame, Logger logger) {
        this.jeu = jeu;
        this.récupérer = récupérer;
        this.dessin = dessin;
        this.grilleFrame = grilleFrame;
        this.logger = logger;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        récupérer.récupérer(); // Appel de la méthode récupérer() de l'objet Récupération
        dessin.repaint(); // Redessine la grille
        logger.Ecris1("Le joueur récupérer sa sauvegarde\n"); // Enregistre un message dans le log
    }
}
