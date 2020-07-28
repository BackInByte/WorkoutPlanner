# Workout Planner

## Présentation de l’application :
Workout Planner est une application programmée dans le cadre d’un projet d’étudiant de 4e année. L’application permet de créer des entraînements sportifs à partir de la banque d’exercices proposée. Elle offre également la possibilité de consulter les détails de ces exercices, comme les muscles travaillés. Les entraînements peuvent être « lancés », ce qui permet à l’utilisateur de visualiser un par un les exercices au fur et à mesure qu’il les réalise lors de son entraînement.

## Fonctionnalités
Proposer à l’utilisateur d’entrer son nom au démarrage de l’application

![image001](https://github.com/BackInByte/Images/blob/master/image001.png)

Une fois le nom entré, une page d’accueil pourrait être ajoutée (voir **Points d’amélioration**). Dans la version actuelle de Workout Planner, une page blanche est affichée tant qu’un item du menu n’a pas été sélectionné.

![image002](https://github.com/BackInByte/Images/blob/master/image002.png)

Menu Navigation Drawer

![image003](https://github.com/BackInByte/Images/blob/master/image003.png)

### Visualiser la liste de tous les exercices (All Exercices)

![image004](https://github.com/BackInByte/Images/blob/master/image004.png)

Cliquer sur un exercice pour consulter ses détails (muscles travaillés, illustration de l’exercice)

![image005](https://github.com/BackInByte/Images/blob/master/image005.png)

### Visualiser la liste des entraînements (Workouts)

![image006](https://github.com/BackInByte/Images/blob/master/image006.png)

Cliquer sur un entraînement pour afficher la liste des exercices qu’il contient

![image007](https://github.com/BackInByte/Images/blob/master/image007.png)

Cliquer sur un exercice pour consulter ses détails

![image008](https://github.com/BackInByte/Images/blob/master/image008.png)

Ajout d’un nouvel entraînement (clic sur le bouton « Add a Workout »), sélection multiple des exercices à ajouter.
Recliquer sur un exercice sélectionné le désélectionne, un bouton de confirmation permet de valider la sélection.

![image009](https://github.com/BackInByte/Images/blob/master/image009.png)

Un message « toast » confirme la création d’un nouvel entraînement

![image010](https://github.com/BackInByte/Images/blob/master/image010.png)

Démarrage d’un entraînement (clic sur le bouton « Start a Workout », choix de l’entraînement à démarrer parmi les entraînements de la liste

![image011](https://github.com/BackInByte/Images/blob/master/image011.png)

Affichage des exercices de l’entraînement un par un avec boutons de navigation « previous » et « next » placés en bas de l’écran pour une meilleure prise en main

![image012](https://github.com/BackInByte/Images/blob/master/image012.png)
![image013](https://github.com/BackInByte/Images/blob/master/image013.png)

Lorsqu’un entraînement est terminé, retour à la liste des entraînements.

## Particularités au niveau du code
* Utilisation d’une API qui permet de récupérer les données des exercices. Ces données sont hébergées à l’adresse suivante : https://backinbyte.github.io/Data/db.json
* Utilisation d’une activité principale qui permet la navigation entre les fragments, notamment les fragments « Exercices » et « Workouts », à l’aide d’un Navigation Drawer.
* Utilisation d’une architecture MVC
* Certains fragments sont réutilisés pour des affichages différents : par exemple, ExercicesFragment affiche tous les exercices de la banque si aucun entraînement n’a été sélectionné auparavant. Dans le cas contraire, seuls les exercices appartenant à l’entraînement sélectionné sont affichés.

## Difficultés rencontrées
* Quelques difficultés rencontrées pour afficher autant de boutons qu’il n’y a d’items à afficher (pour afficher la liste des exercices ou des entraînements dont le nombre est susceptible de varier)
* Plusieurs tests effectués pour s’assurer que tous les cas sont pris en compte lors de la réutilisation de fragments pour des affichages différents.
* Erreurs rencontrées lors de la mise en place de l’API
* Problèmes de synchronisation entre threads lors des requêtes par l’API

## Points d’amélioration
* Exploiter le nom entré par l’utilisateur au démarrage de l’application, pour par exemple créer des sessions
* Proposer de choisir le nom du nouvel entraînement créé.
* Permettre de modifier l’ordre dans lequel les exercices vont être effectués dans un entraînement.
* Permettre à l’API d’effectuer également des requêtes POST et ajouter ainsi la persistance des données.
* Ajouter une page d’accueil lors du lancement de l’application (actuellement un écran blanc tant que l’on n’a pas sélectionné un item dans le Navigation Drawer).
* Utiliser l’API afin d'effectuer des requêtes permettant également d'obtenir les images des exercices.
* Ajouter la possibilité de régler les temps de repos entre chaque exercice, en ajoutant un timer chaque fois qu’un exercice est terminé par l’utilisateur.
* Ajouter la possibilité de définir le nombre de répétitions et de séries pour chaque exercice, ainsi que le poids à soulever.
* Permettre de visualiser l’évolution des poids choisis par l’utilisateur pour ses exercices afin de mesurer ses progrès.
