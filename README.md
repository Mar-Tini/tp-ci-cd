# TP Refactoring Java

Travaux pratiques — Génie Logiciel Avancé

## Objectif

L'objectif de ce TP était d'améliorer la qualité d'une application Java en appliquant des techniques de refactoring et en mettant en place des outils d'intégration et de déploiement continus.

## Outils utilisés

### Jenkins

Jenkins a été utilisé pour automatiser les différentes étapes du projet, notamment la compilation, l'exécution des tests et l'analyse du code. Cela permet de détecter rapidement les erreurs après chaque modification.

### Docker

Docker a été utilisé pour exécuter l'application et les différents services dans des conteneurs. Cette approche garantit un environnement identique pour tous les développeurs et facilite le déploiement.

### SonarQube

SonarQube a été utilisé pour analyser la qualité du code source. L'outil permet d'identifier les bugs potentiels, les vulnérabilités de sécurité, les duplications de code et les problèmes de maintenabilité.

### Ngrok

Ngrok a été utilisé pour exposer les services locaux sur Internet via une URL publique sécurisée. Cela a permis à Jenkins et aux autres outils de communiquer facilement pendant les démonstrations et les tests.

## Résultat

Grâce à l'utilisation combinée de Jenkins, Docker, SonarQube et Ngrok, nous avons pu mettre en place une chaîne CI/CD simple permettant d'automatiser les tests, de contrôler la qualité du code et de faciliter le déploiement de l'application.
