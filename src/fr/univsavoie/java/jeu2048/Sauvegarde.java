package fr.univsavoie.java.jeu2048;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Sauvegarde {
    private Jeu2048 jeu;

    // Constructeur prenant un objet Jeu2048 en paramètre
    public Sauvegarde(Jeu2048 jeu) {
        this.jeu = jeu; // Initialise la variable jeu avec l'objet passé en paramètre
    }

    // Méthode pour sauvegarder un jeu dans un fichier
    public void sauvegarderJeu(Jeu2048 jeu) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/Users/flavi/saves/a.obj"))) {
            // Initialise un ObjectOutputStream pour écrire des objets dans un fichier
            // Le fichier est situé à l'emplacement spécifié
            oos.writeObject(jeu); // Écrit l'objet jeu dans le fichier

        } catch (IOException e) { // Gère les exceptions liées à l'entrée/sortie
            // En cas d'erreur, affiche un message d'erreur sur la sortie d'erreur standard
            System.err.println("Erreur sur le flux : " + e.getMessage());
        }
    }
}
