# Développement d'une Application Java (Jeu 2048)

## Description
Il s'agit d'une **application Java** reproduisant le célèbre jeu **2048**, avec interface graphique Swing, gestion du clavier, sauvegarde, chargement de partie, et interactions utilisateur.

---

## Prérequis
- Java **21** ou version compatible
- IntelliJ IDEA **ou** VS Code (voir plus bas pour la configuration)
- Le fichier `.jar` fourni dans le dossier `libs/`

---

## Installation

1. **Importez le projet dans votre IDE préféré :**

### 🔹 Pour IntelliJ IDEA :
- Ouvrez le projet avec IntelliJ.
- Allez dans `File > Project Structure` (`Ctrl+Alt+Shift+S`)
- Onglet `Libraries` > `+` > `Java`
- Sélectionnez le fichier `libs/jeu2048.jar`

### 🔹 Pour VS Code :
- Assurez-vous d’avoir installé **Java Extension Pack**.
- Créez (si besoin) un fichier `.vscode/settings.json` avec :
  ```json
  {
    "java.project.referencedLibraries": [
      "libs/**/*.jar"
    ]
  }
  ```
- Redémarrez VS Code. Le `.jar` sera reconnu automatiquement.

---

## Structure du projet

```
Jeu 2048/
├── src/                         # Code source Java
│   └── fr/univsavoie/java/jeu2048/
├── libs/                        # Fichier .jar (jeu2048.jar)
├── .gitignore                   # Fichiers/dossiers ignorés par Git
├── .vscode/                     # Config VS Code
├── tp2.iml                      # Fichier de configuration IntelliJ
└── README.md                    # Ce fichier
```

---

## Utilisation

- Lancez la classe `Main.java` pour démarrer le jeu.
- Jouez à l’aide des flèches du clavier.
- Une sauvegarde automatique est effectuée à la fermeture.
- Un menu permet de relancer une nouvelle partie.

---

## Auteurs

- Flavien Bontemps

---
