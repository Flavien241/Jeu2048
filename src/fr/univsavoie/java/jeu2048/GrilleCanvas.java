package fr.univsavoie.java.jeu2048;

import javax.swing.*;
import java.awt.*;

import static fr.univsavoie.java.jeu2048.GrilleFrame.HAUTEUR;
import static fr.univsavoie.java.jeu2048.GrilleFrame.LARGEUR;

public class GrilleCanvas extends JPanel {
    private Jeu2048 jeu;

    public GrilleCanvas(Jeu2048 jeu) {
        this.setFocusable(true);
        this.jeu = jeu;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = LARGEUR / jeu.getNbCols() - 3;
        int height = HAUTEUR / jeu.getNbLignes() - 21;
        int x = 0;
        int y = 0;

        for (int i = 0; i < jeu.getNbLignes(); i++) {
            for (int j = 0; j < jeu.getNbCols(); j++) {
                // Déterminer la couleur en fonction de la valeur dans la grille
                Color color;
                if (jeu.getGrilleInt()[i][j] == 2) {
                    color = new Color(245, 245, 220);
                } else if (jeu.getGrilleInt()[i][j] == 4) {
                    color = new Color(221, 204, 170);
                } else if (jeu.getGrilleInt()[i][j] == 8) {
                    color = new Color(255, 204, 102);
                } else if (jeu.getGrilleInt()[i][j] == 16) {
                    color = new Color(255, 165, 0);
                } else if (jeu.getGrilleInt()[i][j] == 32) {
                    color = new Color(255, 140, 0);
                } else if (jeu.getGrilleInt()[i][j] == 64) {
                    color = new Color(204, 85, 0);
                } else if (jeu.getGrilleInt()[i][j] == 128) {
                    color = new Color(255, 230, 128);
                } else if (jeu.getGrilleInt()[i][j] == 256) {
                    color = new Color(255, 204, 0);
                } else if (jeu.getGrilleInt()[i][j] == 512) {
                    color = new Color(255, 187, 0);
                } else if (jeu.getGrilleInt()[i][j] == 1024) {
                    color = new Color(255, 170, 0);
                } else if (jeu.getGrilleInt()[i][j] == 2048) {
                    color = new Color(204, 136, 0);
                } else {
                    // Valeur non spécifiée, couleur par défaut
                    color = Color.WHITE;
                }

                // Appliquer la couleur et dessiner le rectangle
                g.setColor(color);
                g.fillRect(x, y, width, height);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, width, height);

                // Afficher la valeur de la grille
                if (jeu.getGrilleInt()[i][j] != 0) {
                    String value = String.valueOf(jeu.getGrilleInt()[i][j]);
                    g.drawString(value, x + width / 2, y + height / 2);
                }

                // Mettre à jour la position x pour le prochain rectangle
                x = x + width;
            }
            // Réinitialiser la position x et mettre à jour la position y pour la prochaine ligne
            x = 0;
            y = y + height;
        }
    }
}
