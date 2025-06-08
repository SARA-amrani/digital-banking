# Digital Banking Application - Backend -Spring Boot

Le projet **Digital Banking**, est une application de gestion de comptes bancaires réalisée avec **Spring
Boot**. Ce projet illustre les concepts essentiels du développement backend moderne, comme les DTOs, la sécurité, les
services REST, la gestion d'exceptions, et bien plus.

---

## Sommaire

1. [Technologies utilisées](#technologies-utilisées)
2. [Aperçu du projet](#aperçu-du-projet)
3. [Structure du projet](#structure-du-projet)
4. [Annotations Spring essentielles](#annotations-spring-essentielles)
5. [Fonctionnalités](#fonctionnalités)
6. [Exécution du projet](#exécution-du-projet)
7. [Auteur](#auteur)

---

## Technologies utilisées

|                                                      Icône                                                      | Technologie     | Rôle                                                        |
|:---------------------------------------------------------------------------------------------------------------:|-----------------|-------------------------------------------------------------|
|       ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=spring-boot\&logoColor=white)       | Spring Boot     | Framework principal pour créer et déployer l’API rapidement |
| ![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?logo=spring-security\&logoColor=white) | Spring Security | Gère l’authentification et l’autorisation via JWT           |
|   ![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-007396?logo=hibernate\&logoColor=white)   | Spring Data JPA | Abstraction pour manipuler la base de données relationnelle |
|                    ![JWT](https://img.shields.io/badge/JWT-black?logo=JWT\&logoColor=white)                     | JWT Token       | Authentification sans état (stateless)                      |
|                 ![Lombok](https://img.shields.io/badge/Lombok-red?logo=lombok\&logoColor=white)                 | Lombok          | Réduit le code répétitif (getters/setters, constructeurs)   |
|                 ![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql\&logoColor=white)                 | MySQL           | Base de données relationnelle                               |
|             ![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apache-maven\&logoColor=white)              | Maven           | Gestion des dépendances et du cycle de vie du projet        |
|                    ![Git](https://img.shields.io/badge/Git-F05032?logo=git\&logoColor=white)                    | Git             | Contrôle de version                                         |
|               ![GitHub](https://img.shields.io/badge/GitHub-181717?logo=github\&logoColor=white)                | GitHub          | Hébergement et gestion du code                              |
|    ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-000000?logo=intellij-idea\&logoColor=white)    | IntelliJ IDEA   | Environnement de développement Java                         |

## Aperçu du projet

Ce projet simule un système bancaire avec la gestion des comptes courants et d'épargne. Il inclut la gestion des
clients, des opérations bancaires (versements, retraits), l'historique de compte, et une sécurisation par JWT (JSON Web
Token).

---

## Structure du projet

![architecture_du_projet](src/captures/img.png)
![architecture_du_projet](src/captures/img_1.png)

Le projet **digital-banking** suit une architecture multi-couches (ou architecture en couches), couramment utilisée dans
les applications Java avec Spring Boot. Cette architecture sépare les responsabilités en plusieurs packages bien
distincts, ce qui améliore la maintenabilité, la scalabilité et la testabilité de l’application.

```
    digital-banking-backend/
    ├── src/main/java/ma/enset/digitalbanking/
    │   ├── dtos/
    │   ├── entities/
    │   ├── enums/
    │   ├── exceptions/
    │   ├── mappers/
    │   ├── repositories/
    │   ├── security/
    │   ├── services/
    │   │   ├── BankAccountService.java
    │   │   └── BankAccountServiceImpl.java
    │   ├── web/
    │   │   ├── BankAccountRestController.java
    │   │   └── CustomerRestController.java
    │   └── DigitalBankingApplication.java
    └── src/main/resources/
    └── application.properties
```
### 1. `dtos`

![architecture_du_projet](src/captures/img_2.png)

Regroupe les Data Transfer Objects, utilisés pour transporter les données entre les différentes couches sans exposer
directement les entités.

* `CustomerDTO`

![architecture_du_projet](src/captures/img_6.png)

* `BankAccountDTO`

![architecture_du_projet](src/captures/img_3.png)

* `CreditDTO`

![architecture_du_projet](src/captures/img_4.png)

* `DebitDTO`

![architecture_du_projet](src/captures/img_7.png)

* etc.

### 2. `entities`

![architecture_du_projet](src/captures/img_5.png)

Contient les entités JPA (Java Persistence API) qui représentent les tables de la base de données.

* `Customer`

![architecture_du_projet](src/captures/img_11.png)

* `BankAccount`

![architecture_du_projet](src/captures/img_9.png)

* `SavingAccount`

![architecture_du_projet](src/captures/img_12.png)

* `CurrentAccount`

![architecture_du_projet](src/captures/img_10.png)

* `AccountOperation`

![architecture_du_projet](src/captures/img_8.png)

### 3. `enums`

![architecture_du_projet](src/captures/img_13.png)

Contient les énumérations (comme les types de compte ou les statuts de transactions).

* `AccountStatus` : ACTIVATED, SUSPENDED,SUSPENDED

![architecture_du_projet](src/captures/img_14.png)

* `OperationType` : DEBIT, CREDIT

![architecture_du_projet](src/captures/img_15.png)

### 4. `exceptions`

![architecture_du_projet](src/captures/img_16.png)

Gère les exceptions personnalisées, avec une structure propre pour le traitement des erreurs.

* `CustomerNotFoundException`

![architecture_du_projet](src/captures/img_19.png)

* `BalanceNotSufficientException`

![architecture_du_projet](src/captures/img_17.png)

* `BankAccountNotFoundException`

![architecture_du_projet](src/captures/img_18.png)

### 5. `mappers`

![architecture_du_projet](src/captures/img_20.png)

Fournit des classes (souvent à l’aide de MapStruct) permettant de convertir entre entités et
DTOs[Mappe les entités vers les DTOs].

* `BankAccountMapperImpl`

![architecture_du_projet](src/captures/img_21.png)
![architecture_du_projet](src/captures/img_22.png)

### 6. `repositories`

![architecture_du_projet](src/captures/img_23.png)

Contient les interfaces qui étendent JpaRepository, pour accéder aux données de manière abstraite et
propre[Interfaces qui communiquent avec la base de données].

* `CustomerRepository`

![architecture_du_projet](src/captures/img_26.png)

* `BankAccountRepository`

![architecture_du_projet](src/captures/img_25.png)

* `AccountOperationRepository`

![architecture_du_projet](src/captures/img_24.png)

### 7. `security`

Contient la **configuration de sécurité** et le **contrôleur JWT** :

* `SecurityConfig` : configure JWT, filtres, gestion des rôles.
* `SecurityController` : endpoints pour `login`, `refreshToken`…

## 🔐 Sécurité et JWT

* **Spring Security** protège les routes REST.
* **JWT Stateless** : pas de sessions côté serveur.
* Les filtres injectent le token dans les headers :

```http
Authorization: Bearer <JWT_TOKEN>
```

### 8. `services`

![architecture_du_projet](src/captures/img_27.png)

Contient la **logique métier** :

* `BankAccountService` (interface) : méthodes telles que `createAccount`, `credit`, `debit`, `transfer`,
  `getAccountHistory`.
* `BankAccountServiceImpl` : implémentation de ces méthodes, gestion des exceptions, interaction avec les repositories.

### 9. `web`

![architecture_du_projet](src/captures/img_28.png)

Contient les **contrôleurs REST exposant l’API** :

* `CustomerRestController` : endpoints CRUD sur les clients.
* `BankAccountRestController` : endpoints pour créer compte, faire un crédit/débit, virement, consulter l’historique.

### 10. `application.properties`

![architecture_du_projet](src/captures/img_29.png)

Le fichier application.properties dans src/main/resources/ contient la configuration principale de l'application (
connexion à la base de données, port du serveur, paramètres de sécurité, etc.).

---

## Annotations Spring essentielles

| Annotation                  | Rôle                               |
|-----------------------------|------------------------------------|
| `@SpringBootApplication`    | Point d'entrée de l'application    |
| `@RestController`           | Définit un contrôleur REST         |
| `@Service`                  | Définit une couche métier          |
| `@Repository`               | Accès aux données (DAO)            |
| `@Entity`                   | Définit une entité JPA             |
| `@Id`                       | Clé primaire                       |
| `@GeneratedValue`           | Génération auto de la clé          |
| `@OneToMany` / `@ManyToOne` | Relations entre entités            |
| `@Autowired`                | Injection de dépendance            |
| `@PreAuthorize`             | Sécurisation des méthodes par rôle |

---

## Fonctionnalités

* Gestion des clients (CRUD)
* Création de comptes courants / épargne
* Versement / retrait / transfert
* Historique des opérations
* DTO pour séparer couche métier et présentation
* Exception handling personnalisé
* Authentification JWT (via `SecurityConfig`)

---

## Exécution du projet

![architecture_du_projet](src/captures/img_30.png)

## Points d’accès REST (API)

### BankAccountRestController

| URL                                                  | Méthode | Description                                                              |
|------------------------------------------------------|---------|--------------------------------------------------------------------------|
| `/accounts/{accountId}`                              | `GET`   | **Consulter les détails d’un compte bancaire** à partir de son ID.       |
| `/accounts`                                          | `GET`   | **Lister tous les comptes bancaires**.                                   |
| `/accounts/{accountId}/operations`                   | `GET`   | **Afficher l’historique complet des opérations** d’un compte.            |
| `/accounts/{accountId}/pageOperations?page=0&size=5` | `GET`   | **Afficher l’historique paginé** d’un compte (utile pour la pagination). |
| `/accounts/debit`                                    | `POST`  | **Débiter un compte** avec un montant et une description.                |
| `/accounts/credit`                                   | `POST`  | **Créditer un compte** avec un montant et une description.               |
| `/accounts/transfer`                                 | `POST`  | **Transférer de l’argent entre deux comptes**.                           |

`/accounts`

> ![architecture_du_projet](src/captures/img_31.png)

`/accounts/{accountId}`

> ![architecture_du_projet](src/captures/img_32.png)

`/accounts/{accountId}/operations`

> ![architecture_du_projet](src/captures/img_33.png)

---

### CustomerRestController

| URL                               | Méthode  | Description                                                 |
|-----------------------------------|----------|-------------------------------------------------------------|
| `/customers`                      | `GET`    | **Lister tous les clients** de la banque.                   |
| `/customers/search?keyword=Imane` | `GET`    | **Rechercher un client** par mot-clé (nom, prénom, etc.).   |
| `/customers/{id}`                 | `GET`    | **Afficher les détails d’un client** à partir de son ID.    |
| `/customers`                      | `POST`   | **Créer un nouveau client** avec les données JSON fournies. |
| `/customers/{customerId}`         | `PUT`    | **Modifier les informations** d’un client existant.         |
| `/customers/{id}`                 | `DELETE` | **Supprimer un client** de la base de données.              |

`/customers`

> ![architecture_du_projet](src/captures/img_34.png)

`/customers/search?keyword=Imane`

> ![architecture_du_projet](src/captures/img_35.png)

`/customers/{id}`

> ![architecture_du_projet](src/captures/img_36.png)

---

3. **Tester l'API** via Swagger

Ajouter la dépendance Swagger (OpenAPI) pour tester :

```xml

<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.1.0</version>
</dependency>
```

## Accès à Swagger UI

Swagger UI est accessible via l’URL suivante (en local) :
`http://localhost:8085/swagger-ui/index.html`

![architecture_du_projet](src/captures/img_38.png)

## OpenAPI Definition

L’API utilise la spécification OpenAPI 3.0 (OAS3) pour décrire tous les endpoints, les schémas de données, et les
opérations disponibles. Le fichier JSON décrivant cette API est accessible à :
`http://localhost:8085/v3/api-docs`

![architecture_du_projet](src/captures/img_44.png)

## Serveurs

Dans Swagger UI, la liste des serveurs montre l’URL sur laquelle l’API est disponible :

* `http://localhost:8085` (serveur généré automatiquement)

![architecture_du_projet](src/captures/img_45.png)

## Contrôleurs et Endpoints

L’API est divisée en plusieurs contrôleurs. Voici les principaux et les opérations associées que tu peux tester
directement dans Swagger UI :

### 1. `customer-rest-controller`

> 1. La liste des endpoints de `customer-rest-controller`.

![architecture_du_projet](src/captures/img_39.png)

> 2. `GET /customers` : l’exemple de réponse JSON.

![architecture_du_projet](src/captures/img_46.png)

> 3. `POST /customers` : le formulaire de requête avec les champs à remplir (par ex. `name`, `email`).

![architecture_du_projet](src/captures/img_47.png)

### 2. `bank-account-rest-controller`

> 1. Liste des endpoints de `bank-account-rest-controller`.

![architecture_du_projet](src/captures/img_40.png)

## Schémas (Models)

Swagger UI affiche aussi les modèles de données utilisés dans l’API. Voici les plus importants :

| Modèle                  | Description                     | Champs principaux                                              |
|-------------------------|---------------------------------|----------------------------------------------------------------|
| **CustomerDTO**         | Données d’un client             | `id` (integer), `name` (string), `email` (string)              |
| **TransferRequestDTO**  | Requête pour un virement        | `accountSource`, `accountDestination`, `amount`, `description` |
| **DebitDTO**            | Requête pour un débit           | (champs liés au débit)                                         |
| **CreditDTO**           | Requête pour un crédit          | (champs liés au crédit)                                        |
| **BankAccountDTO**      | Données d’un compte bancaire    | (détails du compte)                                            |
| **AccountHistoryDTO**   | Historique des opérations       | (liste paginée d’opérations)                                   |
| **AccountOperationDTO** | Détail d’une opération bancaire | (type, date, montant, etc.)                                    |

![architecture_du_projet](src/captures/img_41.png)

![architecture_du_projet](src/captures/img_42.png)

![architecture_du_projet](src/captures/img_43.png)

## Utilisation pratique

* Swagger UI permet de tester toutes les opérations REST directement depuis le navigateur.
* Pour chaque requête, on peut visualiser la structure attendue des données, saisir des exemples, et voir les réponses
  JSON retournées par l’API.
* Très utile pour comprendre le fonctionnement des endpoints et pour le développement frontend ou les tests.

---

## Auteur

**Sara EL AMRANI**

* Étudiante en 2eme année Génie Logiciel et Systéme Informatiques Distribuées(GLSID)

---