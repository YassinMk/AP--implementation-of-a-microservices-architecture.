# Implémentation d'une Architecture Microservices

Ce dépôt contient l'implémentation d'une architecture microservices avec différents composants tels que le Customer Service, Inventory Service, Billing Service, Spring Cloud Gateway et Eureka Registry Service. Vous trouverez ci-dessous une vue d'ensemble de l'architecture ainsi que les instructions pour configurer et exécuter le projet.

## Vue d'ensemble

### Schéma de l'architecture
L'architecture comprend les composants suivants :
- **Customer Service** : Gère les opérations liées aux clients.
- **Inventory Service** : Gère l'inventaire des produits.
- **Billing Service** : Gère la facturation.
- **Spring Cloud Gateway** : Sert de passerelle API pour router les requêtes.
- **Eureka Registry Service** : Fournit la découverte des services pour les microservices.

![image](https://github.com/user-attachments/assets/2320657d-d9b8-4ca1-aa4c-4a8351ec2703)

---

## Structure du projet

### Structure du dépôt
Le dépôt est structuré comme suit :

```
|-- customer-service
|   |-- src
|   |-- pom.xml
|-- inventory-service
|   |-- src
|   |-- pom.xml
|-- billing-service
|   |-- src
|   |-- pom.xml
|-- gateway-service
|   |-- src
|   |-- pom.xml
|-- eureka-server
|   |-- src
|   |-- pom.xml
|-- angular-client
|-- README.md
```

---

## Détails des services

### 1. Inventory Service
Ce service gère l'inventaire des produits.

#### Fonctionnalités clés
- **Entité** : Product
- **Répertoire** : `ProductRepository` basé sur Spring Data.
- **API** : API RESTful implémentée avec Spring Data REST.

#### Chemin du répertoire
[`inventory-service`](https://github.com/YassinMk/AP-Implementation-of-a-microservices-architecture./tree/main/inventory-service/src/main/java/org/yassinmk/inventoryservice/repository)

#### Comment tester
Exécutez la classe `InventoryServiceApplication` et utilisez Postman ou Swagger pour tester les points d'accès de gestion des produits.

---

### 2. Customer Service
Ce service gère les informations relatives aux clients.

#### Fonctionnalités clés
- **Entité** : Customer
- **Répertoire** : `CustomerRepository` basé sur Spring Data.
- **API** : API RESTful implémentée avec Spring Data REST.

---

### 3. Billing Service
Ce service gère la facturation et la communication avec les services Customer et Inventory à l'aide d'OpenFeign.

#### Fonctionnalités clés
- Intégration avec les services Customer et Inventory.
- Calcul et gestion des factures.

---

### 4. Gateway Service
La passerelle API utilise Spring Cloud Gateway pour router les requêtes vers les microservices appropriés.

#### Fonctionnalités clés
- Configuration via `application.yml` (routage statique).
- Configuration dynamique via Java.

---

### 5. Eureka Registry Service
Le serveur Eureka est utilisé pour la découverte des services. Tous les microservices s'enregistrent auprès du serveur Eureka pour le routage dynamique et l'équilibrage de charge.

---

### 6. Angular Client
Application frontend pour interagir avec les services et afficher les factures.

#### Fonctionnalités clés
- Affiche les informations sur les produits, clients et factures.
- Développé avec Angular.

---

## Prérequis
- **Java 17** ou une version supérieure.
- **Maven** pour construire le projet.
- **Node.js** et **Angular CLI** pour le frontend.
- **Docker** (optionnel pour un déploiement conteneurisé).


## Auteur
[YassinMk](https://github.com/YassinMk)
