package fr.univsavoie.java.jeu2048;
import java.io.*;

public class Logger {
    private Jeu2048 jeu;

    // Constructeur prenant un objet Jeu2048 en paramètre
    public Logger(Jeu2048 jeu) {
        this.jeu = jeu;
    }


    // Méthode pour écrire dans le fichier journal
    public void Ecris1(String text) {
        // Utilisation de try-with-resources pour ouvrir le fichier et garantir sa fermeture automatique
        try (FileWriter log = new FileWriter("C:/Users/flavi/saves/log.txt", true)) {
            // Écriture du texte dans le fichier
            log.write(text);
        } catch (IOException e) { // Gestion des exceptions liées à l'entrée/sortie (IO)
            // Affichage de l'erreur dans la console en cas de problème avec le flux
            System.err.println("Erreur sur le flux : " + e.getMessage());
        }
    }
}
