package fr.univsavoie.java.jeu2048;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeSupport;

public class GrilleFrame extends JFrame {
    private PropertyChangeSupport pcs; // Pour gérer les événements de changement de propriété
    public static final int HAUTEUR = 500; // Hauteur de la fenêtre
    public static final int LARGEUR = 600; // Largeur de la fenêtre
    private Jeu2048 jeu; // Instance du jeu
    private Sauvegarde sauvegarde; // Gestionnaire de sauvegarde
    private Récupération récupérer; // Gestionnaire de récupération
    private JLabel label1; // Label pour afficher le score
    private JLabel label2; // Label pour afficher le meilleur score
    private GrilleCanvas dessin; // Composant pour dessiner la grille
    private JPanel panel; // Conteneur pour les boutons
    private Logger logger;


    // Constructeur de la classe GrilleFrame
    public GrilleFrame(Jeu2048 jeu, GrilleCanvas dessin, JPanel panel, Sauvegarde sauvegarde, Récupération récupérer,Logger logger) {
        super();
        this.jeu = jeu; // Initialisation du jeu
        this.dessin = dessin; // Initialisation du composant de dessin de la grille
        this.panel = panel; // Initialisation du conteneur de boutons
        this.sauvegarde = sauvegarde; // Initialisation du gestionnaire de sauvegarde
        this.récupérer = récupérer; // Initialisation du gestionnaire de récupération
        this.setSize(LARGEUR, HAUTEUR); // Définition de la taille de la fenêtre
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Définition du comportement à la fermeture
        this.logger=logger;
        // Création des boutons
        JButton bouton_nouveau_jeu = new JButton("Nouveau Jeu");
        JButton bouton_sauvegarde = new JButton("Sauvegarder");
        JButton bouton_recover = new JButton("Récupérer");

        // Initialisation des labels de score
        label1 = new JLabel("Score : " + jeu.getScore());
        label2 = new JLabel("BestScore : " + jeu.getBestScore());

        // Définition du layout pour le panel
        panel.setLayout(new FlowLayout());

        // Ajout des boutons et des labels au panel
        panel.add(bouton_nouveau_jeu);
        panel.add(bouton_sauvegarde);
        panel.add(bouton_recover);
        bouton_nouveau_jeu.setFocusable(false);
        bouton_sauvegarde.setFocusable(false);
        bouton_recover.setFocusable(false);
        panel.add(label1);
        panel.add(label2);

        // Ajout des écouteurs aux boutons
        bouton_nouveau_jeu.addActionListener(new NouveaujeuActionListener(jeu, dessin, this,logger));
        bouton_sauvegarde.addActionListener(new SauvegardeActionListener(jeu, sauvegarde,logger));
        bouton_recover.addActionListener(new RécupérationActionListener(jeu, récupérer, dessin, this,logger));

        // Création d'un écouteur pour le clavier
        KeyBoardListener keyboardListener = new KeyBoardListener(jeu, dessin, this,logger);

        // Rend le composant focusable pour qu'il puisse recevoir les événements du clavier
        this.setFocusable(true);
        this.requestFocusInWindow();

        // Ajout de l'écouteur de clavier
        this.addKeyListener(keyboardListener);

        // Ajout du composant de dessin de la grille à la fenêtre
        this.getContentPane().add(dessin, BorderLayout.CENTER);

        // Ajout du panel contenant les boutons et les labels en bas de la fenêtre
        this.getContentPane().add(panel, BorderLayout.SOUTH);

        // Ajout d'écouteurs pour mettre à jour les scores
        jeu.addPropertyChangeListener("score", evt -> {
            label1.setText("Score : " + evt.getNewValue());
        });
        jeu.addPropertyChangeListener("bestScore", evt -> {
            label2.setText("BestScore : " + evt.getNewValue());
        });

    }

    // Méthode pour mettre à jour le dessin de la grille
    public void updateDessin(GrilleCanvas newDessin) {
        this.dessin = newDessin;
        this.repaint(); // Redessine la fenêtre
    }
}

