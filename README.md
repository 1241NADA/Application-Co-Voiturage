# 🚗 Application de Co-Voiturage

## 📌 Description

**Application de Co-Voiturage** est une application permettant de gérer des trajets de covoiturage et de mettre en relation des conducteurs et des passagers souhaitant partager leurs déplacements.

L'application permet aux conducteurs de proposer des trajets en renseignant notamment le point de départ, la destination, la date, l'heure et le nombre de places disponibles.

Les passagers peuvent rechercher des trajets selon différents critères et effectuer des réservations.

Le projet intègre également la gestion des paiements, des véhicules, des évaluations ainsi que l'historique des trajets.

> Projet réalisé dans le cadre de la formation d'ingénieur à l'École Nationale des Études d'Ingénieurs de Carthage (ENICarthage).

---

## 🎯 Objectifs du projet

Les principaux objectifs de l'application sont :

- 👤 Gérer les utilisateurs
- 🚘 Gérer les conducteurs
- 🧑‍🤝‍🧑 Gérer les passagers
- 🛣️ Proposer et gérer des trajets
- 🔎 Rechercher des trajets
- 📅 Rechercher des trajets selon la destination et la date
- 📊 Trier les trajets selon le nombre de places disponibles
- 🎫 Gérer les réservations
- 💳 Gérer les paiements
- 🚙 Gérer les véhicules
- ⭐ Permettre l'évaluation des utilisateurs
- 📜 Gérer l'historique des trajets
- ⚠️ Gérer les erreurs grâce à des exceptions personnalisées

Le cahier des charges prévoit également le calcul du partage des frais ainsi que l'envoi de notifications pour les confirmations ou annulations. :contentReference[oaicite:1]{index=1}

---

## ✨ Fonctionnalités

### 👤 Gestion des utilisateurs

L'application distingue deux types principaux d'utilisateurs :

- **Conducteur**
- **Passager**

La classe `Utilisateurs` constitue une classe abstraite scellée dont héritent `Conducteur` et `Passager`.

Chaque utilisateur possède notamment :

- Nom
- Prénom
- Email
- Adresse

La gestion des utilisateurs est accessible depuis l'interface principale. :contentReference[oaicite:2]{index=2}

---

### 🚘 Gestion des conducteurs

Un conducteur peut :

- Ajouter ses informations
- Consulter ses informations
- Proposer des trajets
- Annuler un trajet
- Consulter les trajets proposés

Les trajets proposés sont stockés dans une liste associée au conducteur. :contentReference[oaicite:3]{index=3}

---

### 🧑‍🤝‍🧑 Gestion des passagers

Un passager peut :

- Ajouter ses informations
- Rechercher un trajet
- Réserver un trajet
- Annuler une réservation
- Consulter ses trajets réservés

La recherche d'un trajet peut être effectuée selon :

- Destination
- Date

:contentReference[oaicite:4]{index=4}

---

### 🛣️ Gestion des trajets

La classe abstraite `Trajet` contient les informations principales d'un déplacement :

- Point de départ
- Destination
- Date
- Heure
- Nombre de places disponibles
- Conducteur

Deux types de trajets sont proposés :

#### Trajet court

`TrajetCourt` ajoute notamment le type de voiture.

#### Trajet long

`TrajetLong` ajoute la distance du trajet en kilomètres.

:contentReference[oaicite:5]{index=5}

---

### 🔎 Recherche et tri

La classe `GestionTrajet` permet de :

- Ajouter des trajets
- Rechercher des trajets
- Rechercher selon la destination et la date
- Trier les trajets selon le nombre de places disponibles
- Afficher les trajets disponibles

La recherche et le tri utilisent les fonctionnalités Java **Streams** et les expressions **Lambda**. :contentReference[oaicite:6]{index=6}

---

### 🎫 Gestion des réservations

Les réservations permettent de gérer :

- Le trajet
- Le passager
- La date de réservation
- Le statut de la réservation

Les principaux statuts utilisés sont notamment :

- `en attente`
- `confirmée`
- `annulée`

L'application permet de confirmer ou d'annuler une réservation. :contentReference[oaicite:7]{index=7}

---

### 💳 Gestion des paiements

La classe `Paiement` permet de gérer :

- Le montant
- Le mode de paiement
- La date du paiement

Une validation est effectuée avant de considérer le paiement comme valide.

Un paiement est considéré comme valide lorsque :

- Le montant est positif
- Le mode de paiement est renseigné

Une exception personnalisée `PaiementInvalidException` est utilisée pour gérer les paiements invalides. :contentReference[oaicite:8]{index=8}

---

### 🚙 Gestion des véhicules

L'application permet d'enregistrer les informations d'un véhicule :

- Marque
- Modèle
- Immatriculation
- Capacité

Elle permet également de vérifier si un véhicule peut accueillir un nombre donné de passagers.

Un `VehiculeRecord` est également utilisé pour représenter les informations d'un véhicule sous forme de record Java. :contentReference[oaicite:9]{index=9}

---

### ⭐ Évaluation

L'application intègre une fonctionnalité d'évaluation permettant à un utilisateur de laisser un commentaire.

Une évaluation contient notamment :

- L'utilisateur ayant effectué l'évaluation
- Le commentaire

L'interface utilise également un `Slider` et un `ProgressIndicator` pour gérer l'évaluation. :contentReference[oaicite:10]{index=10}

---

### 📜 Historique des trajets

La classe `HistoriqueTrajet` permet :

- D'ajouter un trajet à l'historique
- D'afficher les trajets enregistrés

Un `HistoriqueTrajetRecord` est également utilisé pour représenter l'historique sous forme de record. :contentReference[oaicite:11]{index=11}

---

## 🏗️ Architecture du projet

Le projet est organisé en plusieurs packages.

```text
Application-Co-Voiturage
│
├── model
│   │
│   ├── pck1
│   │   ├── Utilisateurs
│   │   ├── Conducteur
│   │   ├── Passager
│   │   ├── HistoriqueTrajet
│   │   ├── Evaluation
│   │   ├── Date
│   │   └── Adresse
│   │
│   ├── pck2
│   │   ├── GestionTrajet
│   │   ├── Trajet
│   │   ├── TrajetCourt
│   │   ├── TrajetLong
│   │   ├── Paiement
│   │   ├── Reservation
│   │   └── Vehicule
│   │
│   ├── Exception
│   │   ├── AdresseInvalideException
│   │   ├── DateInvalideException
│   │   └── PaiementInvalidException
│   │
│   └── Record
│       ├── HistoriqueTrajetRecord
│       └── VehiculeRecord
│
├── controller
│   ├── CovAccueilFXMLController
│   ├── AjouterUtilisateurController
│   ├── AjouterConducteurController
│   ├── AjouterPassagerController
│   ├── AjouterTrajetController
│   ├── AjouterTrajetLongController
│   ├── AjouterTrajetCourtController
│   ├── PaiementTrajetController
│   ├── ReserverTrajetController
│   ├── EvaluationController
│   └── AjouterVehiculeController
│
└── view
    ├── CovAccueilFXML
    ├── AjouterUtilisateur
    ├── AjouterConducteur
    ├── AjouterPassager
    ├── AjouterTrajet
    ├── AjouterTrajetLong
    ├── AjouterTrajetCourt
    ├── PaiementTrajet
    ├── ReserverTrajet
    ├── Evaluation
    └── AjouterVehicule
```

Cette organisation Model / Controller / View est celle présentée dans le rapport, avec des packages dédiés aux modèles, exceptions, records, contrôleurs et vues. :contentReference[oaicite:12]{index=12}

---

## 🖥️ Interface utilisateur

L'interface graphique est basée sur **JavaFX** et utilise des fichiers **FXML** pour les différentes vues.

La fenêtre d'accueil permet notamment d'accéder aux fonctionnalités :

- Ajouter un trajet
- Réserver un trajet
- Gérer le profil utilisateur
- Évaluer un utilisateur
- Ajouter un véhicule
- Effectuer un paiement

Les contrôleurs utilisent `FXMLLoader` pour charger les différentes vues FXML. :contentReference[oaicite:13]{index=13}

---

## 🧩 Technologies et concepts utilisés

### Langage

- ☕ Java

### Interface graphique

- JavaFX
- FXML
- TableView
- TextField
- Slider
- ProgressIndicator
- Alert

### Concepts Java

Le projet met en œuvre plusieurs concepts de programmation orientée objet :

- Classes abstraites
- Classes `sealed`
- Héritage
- Encapsulation
- Polymorphisme
- Constructeurs
- Getters / Setters
- Exceptions personnalisées
- Records
- Collections
- `ObservableList`
- Streams
- Lambda expressions

---

## 🛡️ Gestion des erreurs

Plusieurs exceptions personnalisées sont définies afin de gérer les erreurs :

### `AdresseInvalideException`

Utilisée pour contrôler les informations relatives à une adresse.

### `DateInvalideException`

Utilisée pour gérer les dates invalides.

La classe `Date` vérifie notamment :

- Le mois
- L'année
- Le nombre de jours du mois
- Les années bissextiles

### `PaiementInvalidException`

Utilisée lorsqu'un paiement ne respecte pas les règles de validation.

:contentReference[oaicite:14]{index=14}

---

## 📊 Gestion des données dans l'interface

Les différentes interfaces utilisent des `TableView` afin d'afficher les données.

Par exemple, la gestion des trajets courts affiche :

- Point de départ
- Destination
- Date
- Heure
- Places disponibles
- Conducteur
- Type de voiture

Les données sont manipulées avec des `ObservableList` afin de mettre à jour les tableaux de l'interface graphique. :contentReference[oaicite:15]{index=15}

---

## 📋 Modules de l'application

| Module | Fonction |
|---|---|
| 👤 Utilisateurs | Gestion des utilisateurs |
| 🚘 Conducteurs | Gestion des conducteurs et trajets proposés |
| 🧑‍🤝‍🧑 Passagers | Gestion des passagers et trajets réservés |
| 🛣️ Trajets | Création et gestion des trajets |
| 🔎 Recherche | Recherche par destination et date |
| 🎫 Réservations | Création, confirmation et annulation |
| 💳 Paiements | Gestion et validation des paiements |
| 🚙 Véhicules | Gestion des véhicules |
| ⭐ Évaluations | Commentaires et évaluations |
| 📜 Historique | Gestion de l'historique des trajets |

---

## 🚀 Installation et exécution

### 1. Cloner le projet

```bash
git clone https://github.com/1241NADA/Application-Co-Voiturage.git
```

### 2. Accéder au projet

```bash
cd Application-Co-Voiturage
```

### 3. Ouvrir le projet

Ouvrir le projet avec un environnement de développement Java compatible avec JavaFX.

### 4. Configurer JavaFX

Vérifier que JavaFX est correctement configuré dans l'environnement de développement.

### 5. Exécuter l'application

Lancer la classe principale de l'application.

---

## 📸 Fonctionnalités principales

L'application propose plusieurs interfaces graphiques correspondant aux différents modules :

- Page d'accueil
- Gestion des utilisateurs
- Ajout d'un conducteur
- Ajout d'un passager
- Ajout d'un trajet court
- Ajout d'un trajet long
- Réservation d'un trajet
- Paiement d'un trajet
- Évaluation
- Gestion des véhicules

Les contrôleurs correspondants sont définis dans le projet et chargent les vues FXML associées. :contentReference[oaicite:16]{index=16}

---

## 🎓 Contexte académique

**Projet :** Gestion d'une Application de Co-Voiturage

**Établissement :** École Nationale des Études d'Ingénieurs de Carthage (ENICarthage)

**Encadrante :** Mme Nouira Sana

**Réalisé par :**
- Ati Nour
- Ajel Nada

**Année universitaire :** 2024/2025

:contentReference[oaicite:17]{index=17}

---

## 🔮 Perspectives d'amélioration

Le projet peut être enrichi par plusieurs fonctionnalités :

- Authentification des utilisateurs
- Base de données persistante
- Système de paiement réel
- Notifications en temps réel
- Géolocalisation des trajets
- Carte interactive
- Système de notation plus avancé
- Recherche multicritère avancée
- Gestion des disponibilités en temps réel
- API backend
- Déploiement de l'application

---

## 👩‍💻 Auteur
### Ajel Nada
Étudiante ingénieure — ENICarthage

---

## 📄 Licence

Ce projet a été réalisé dans un cadre académique.
