L'objectf de ce TP est de modéliser une flotte de drones à laquelle nous pouvons assigner des missions de photographies en fonction de la disponibilité des drones


## Avant de commencer

**Créer un répertoire src/main/drones/gr<VOTRE-NUMERO-DE-GROUPE> et src/test/drones/gr<VOTRE-NUMERO-DE-GROUPE>**

Pour le rendu, lancer la commande `./gradlew rendu --group <VOTRE-NUMERO-DE-GROUPE>` et fournir l'archive ZIP générée (nommée `rendu-gr-<VOTRE-NUMERO-DE-GROUPE>.zip`)

Faire au moins un commit après chaque exercice

### Exercice 1 : Un drone

Une drone est défini par :
- un nom
- une altitude max (en mètres)
- une vitesse (en m/s)
- Une position de départ

On peut demander à un drone de rejoindre une position donnée. Une position est exprimée en {X;Y;Z} le tout en mètres.

1.1. Créer une classe Position
- Ajouter une méthode `distanceTo` qui retourne la distance en mètre entre cette position et celle passeé en paramètre
- Pour calculer la distance entre deux points dans un repère 3D : `sqrt[(Xa-Xb)²+(Ya-Yb)²+(Za-Zb)²]`

1.2 Créer une classe `Drone`
1.3 Créer une classe abstraite `MoveResult` et deux classes enfants `Rejected` et `Moving`
1.4 Ajouter une méthode `Drone.goTo` qui retourne :
- `Rejected` si le drone ne peut pas atteindre la position en paramètre
- `Moving` si le drone peut l'atteindre
  1.5 Ajouter deux attributs `destination` et `arriveAt` à la classe `Moving`

### Exercice 2 : une mission

Un parcours est constitué d'une suite de positions. Un parcours ne peut être vide

Une mission est constituée d'un nom, d'un parcours et d'un drone

2.1 Créer une classe `Path` qui représente un parcours.
2.2. Ajouter une méthode `nextPosition()` qui retourne la prochaine position dans le parcours. Lorsque le drone a atteint la dernière position, la méthode `next` doit lever une exception
2.3. Créer une classe `Mission` qui moédélise une mission
2.4. Ajouter une méthode `next()` qui déplace le drone à la prochaine position et qui retourne `OK` quand le drone se déplace et `KO` quand il ne peut pas

### Exercice 3 : Source de Données

Les objets doivent provenir d'une source de données comme une base de données ou d'un système externe (API, par exemple)

Dans cet exercice, les données seront stockées uniquement en mémoire

3.1. Créer une interface `AllDrones` et une classe `InMemoryAllDrones` qui modélise la liste de tous les drones
3.2. Ajouter une méthode `add()` qui permet d'ajouter un drone
3.3. Ajouter une méthode `remove()` qui retire un drone à partir de son nom
3.4. Ajouter une méthode `all()` qui retourne la liste de tous les drones
3.5. Ajouter une méthode `findBy()` qui recherche un drone par son nom. Retourne un objet `Found` si le drone axiste et `NotFound`, sinon
3.6. Créer une interface `AllMissions` et une classe `InMemoryAllMissions` qui modélise la liste de toutes les missions
3.7. Ajouter une méthode `add()` qui ajoute une nouvelle mission
3.8. Ajouter une méthode `remove()` qui retire une mission à partir de son nom


### Exercice 4 : Flotte de drones

Une flotte de drone se compose d'une liste de drones disponibles et d'une liste de mission

On peut ajouter un drone à la flotte ou en retirer un à condition qu'il ne soit pas associé à une mission
On peut ajouter une nouvelle mission à condition qu'un drone soit disponible (i.e. qu'il ne soit pas sur une autre mission et qu'il puisse atteindre toutes les positions en vérifiant les altitudes)


4.1. Créer une classe `Fleet` qui possède deux attributs `allDrones` et `allMissions`
4.2. Ajouter une méthode `add()` pour ajouter un drone
4.3. Ajouter une méthode `remove()` pour retirer un drone à partir de son nom. Retourner un objet `Removed` si le drone a été retiré. Un objet `CannotRemove`, sinon.
4.4. Ajouter une méthode `plan()` qui permet de créer une mission à partir d'un parcours. Retourner soit un objet `OK` si la mission a été créée. objet `KO` si la mission ne peut être créée. (parce qu'aucun drone disponible). Si plusieurs drones sont disponibles, alors c'est celui dont la position de départ est la plus proche du premier point du parcours qui est sélectionné
4.5. Ajouter une méthode `move()` qui demande à une mission (d'après son nom) d'avancer. Retourne un objet `MissionInProgress` quand le drone se déplace à la prochaine position, un objet `CannotProceed` en cas de problème, un objet `MissionAccomplished` quand le drone a atteint le dernier point du parcours.
4.7. Ajouter une méthode `reportMission()` qui affiche toutes les missions en cours avec leur statuts (non commencée, en cours, terminée)
4.8. Ajouter une méthode `reportDrones()` qui affiche tous les drones avec leur statut (disponible ou occupé)


### Exercice 5: Vérifications

5.1. Un drone ne peut pas se déplacer vers une nouvelle position tant qu'il est en mouvement
5.2. S'assurer qu'un drone ne puisse pas être créé avec une position qu'il ne peut atteindre (altitude supérieure à son altitude max)
5.3. S'assurer qu'on ne peut créer un parcours avec moins de deux positions

### Exercice 6: Planification

6.1. Un drone peut rejoindre sa position de départ à tout moment. Même s'il est en déplacement vers une destination.
6.2 Ajouter un attribut `autonomie` qui représente une durée maximale pendant laquelle un drone peut se déplacer. Une fois l'autonomie atteinte, le drone ne peut plus se déplacer hormis pour revenir à sa position de départ
6.3. Si plus aucun drone n'est disponible, on peut planifier la mission avec un drone mais elle devra être effectuée uniquement après que la première mission soit terminée. Le drone devra néanmoins retourner à sa position de départ entre deux missions
