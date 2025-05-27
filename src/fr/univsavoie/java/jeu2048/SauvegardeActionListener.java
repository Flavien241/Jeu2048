package fr.univsavoie.java.jeu2048;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SauvegardeActionListener implements ActionListener {
    private Jeu2048 jeu; // Référence vers l'instance de Jeu2048
    private Sauvegarde sauvegarde; // Référence vers l'instance de Sauvegarde
    private Logger logger; // Référence vers l'instance de Logger

    // Constructeur prenant des références vers un jeu, une sauvegarde et un logger
    public SauvegardeActionListener(Jeu2048 jeu, Sauvegarde sauvegarde, Logger logger) {
        this.jeu = jeu; // Initialise la référence vers le jeu
        this.sauvegarde = sauvegarde; // Initialise la référence vers la sauvegarde
        this.logger = logger; // Initialise la référence vers le logger
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sauvegarde.sauvegarderJeu(jeu); // Appelle la méthode de sauvegarde avec l'instance de jeu
        logger.Ecris1("Le joueur a sauvegardé sa partie\n"); // Enregistre un message dans le logger
    }
}
