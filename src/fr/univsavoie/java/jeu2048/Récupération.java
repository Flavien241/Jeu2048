package fr.univsavoie.java.jeu2048;

import java.io.*;

public class Récupération {
    private Jeu2048 jeu;
    private GrilleCanvas dessin;
    private GrilleFrame grilleFrame;

    // Constructeur prenant en paramètre l'objet Jeu2048 associé
    public Récupération(Jeu2048 jeu) {
        this.jeu = jeu;
    }

    // Méthode permettant de récupérer les données de la partie sauvegardée
    public void récupérer() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/Users/flavi/saves/a.obj"))) {
            // Lecture de l'objet Jeu2048 sauvegardé depuis le fichier
            Jeu2048 jeuSauvegardé = (Jeu2048) ois.readObject();
            // Mettre à jour les données du jeu actuel avec les données sauvegardées
            jeu.setScore(jeuSauvegardé.getScore());
            jeu.setBestScore(jeuSauvegardé.getBestScore());
            jeu.setGrilleInt(jeuSauvegardé.getGrilleInt());
        } catch (IOException | ClassNotFoundException e) {
            // Gérer les exceptions d'entrée/sortie ou de classe non trouvée
            e.printStackTrace();
        }
    }
}
