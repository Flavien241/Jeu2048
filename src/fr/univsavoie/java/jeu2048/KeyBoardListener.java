package fr.univsavoie.java.jeu2048;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static fr.univsavoie.java.jeu2048.Jeu2048.*;

public class KeyBoardListener implements KeyListener {
    private Jeu2048 jeu;
    private GrilleCanvas dessin;
    private GrilleFrame grilleFrame;
    private Logger logger;

    public KeyBoardListener(Jeu2048 jeu, GrilleCanvas dessin, GrilleFrame grilleFrame, Logger logger) {
        this.jeu = jeu;
        this.dessin = dessin;
        this.grilleFrame = grilleFrame;
        this.logger = logger;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                deplacerJeu(HAUT, "Décalage flèche HAUT\n");
                break;
            case KeyEvent.VK_DOWN:
                deplacerJeu(BAS, "Décalage flèche BAS\n");
                break;
            case KeyEvent.VK_LEFT:
                deplacerJeu(GAUCHE, "Décalage flèche GAUCHE\n");
                break;
            case KeyEvent.VK_RIGHT:
                deplacerJeu(DROITE, "Décalage flèche DROITE\n");
                break;
            default:
        }

        // Affichage des messages si le jeu est gagné ou perdu
        if (jeu.estVainqueur()) {
            JOptionPane.showMessageDialog(null, "Félicitations ! Vous avez gagné !");
            logger.Ecris1("Le joueur a gagné\n");
        } else if (jeu.estTermine()) {
            JOptionPane.showMessageDialog(null, "Vous avez perdu !!!");
            logger.Ecris1("Le joueur a perdu\n");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void deplacerJeu(int direction, String messageLog) {
        jeu.decaler(direction);
        dessin.repaint();
        grilleFrame.updateDessin(dessin);
        logger.Ecris1(messageLog);
    }
}
