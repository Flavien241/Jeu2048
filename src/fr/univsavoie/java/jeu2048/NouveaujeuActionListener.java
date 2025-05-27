package fr.univsavoie.java.jeu2048;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NouveaujeuActionListener implements ActionListener {
    private Jeu2048 jeu;
    private GrilleCanvas dessin;
    private GrilleFrame grilleFrame;
    private Logger logger;




    // Constructeur prenant en paramètres les éléments nécessaires à l'action de création d'une nouvelle partie
    public NouveaujeuActionListener(Jeu2048 jeu, GrilleCanvas dessin, GrilleFrame grilleFrame, Logger logger) {
        this.jeu = jeu;
        this.dessin = dessin;
        this.grilleFrame = grilleFrame;
        this.logger = logger;
    }

    // Méthode appelée lorsque l'événement associé à cet ActionListener est déclenché
    @Override
    public void actionPerformed(ActionEvent e) {
        // Appelle la méthode de création d'une nouvelle partie du jeu
        jeu.nouveauJeu();
        // Redessine la grille du jeu
        dessin.repaint();
        // Met à jour la grille affichée dans la fenêtre du jeu
        grilleFrame.updateDessin(dessin);
        // Enregistre dans le journal que le joueur a créé une nouvelle partie
        logger.Ecris1("Le joueur a créé une nouvelle partie\n");
    }
}


