# Digital Banking Application - Spring Boot

Bienvenue dans le projet **Digital Banking**, une application de gestion de comptes bancaires réalisée avec **Spring
Boot**. Ce projet illustre les concepts essentiels du développement backend moderne, comme les DTOs, la sécurité, les
services REST, la gestion d'exceptions, et bien plus.

---

## ✨ Sommaire

1. [Aperçu du projet](#aperçu-du-projet)
2. [Structure du projet](#structure-du-projet)
3. [Annotations Spring essentielles](#annotations-spring-essentielles)
4. [Fonctionnalités](#fonctionnalités)
5. [Exécution du projet](#exécution-du-projet)
6. [Captures d'écran](#captures-décran)
7. [Auteur](#auteur)

---

## 🔍 Aperçu du projet

Ce projet simule un système bancaire avec la gestion des comptes courants et d'épargne. Il inclut la gestion des
clients, des opérations bancaires (versements, retraits), l'historique de compte, et une sécurisation par JWT (JSON Web
Token).

---

## 📂 Structure du projet

### 1. `dtos`

Contient les objets de transfert de données (évite l'exposition directe des entités):

* `CustomerDTO`, `BankAccountDTO`, `AccountHistoryDTO`, etc.

### 2. `entities`

Contient les entités JPA mappées aux tables de la base de données :

* `Customer`, `BankAccount`, `SavingAccount`, `CurrentAccount`, `AccountOperation`

### 3. `enums`

Contient les énumérations :

* `AccountStatus` : ACTIVATED, SUSPENDED, etc.
* `OperationType` : DEBIT, CREDIT

### 4. `exceptions`

Gère les exceptions personnalisées :

* `CustomerNotFoundException`, `BalanceNotSufficientException`, etc.

### 5. `mappers`

Mappe les entités vers les DTOs :

* `BankAccountMapperImpl`

### 6. `repositories`

Interfaces qui communiquent avec la base de données :

* `CustomerRepository`, `BankAccountRepository`, `AccountOperationRepository`

### 7. `security`

Configuration de la sécurité JWT :

* `SecurityConfig`

---

## 📊 Annotations Spring essentielles

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

## 🌟 Fonctionnalités

* Gestion des clients (CRUD)
* Création de comptes courants / épargne
* Versement / retrait / transfert
* Historique des opérations
* DTO pour séparer couche métier et présentation
* Exception handling personnalisé
* Authentification JWT (via `SecurityConfig`)

---

## ⚡ Exécution du projet

1. **Configurer la base de données** (H2/MySQL) dans `application.properties`
2. **Lancer l'application** :

```bash
./mvnw spring-boot:run
```

3. **Tester l'API** via Postman ou Swagger (si intégré)

---

## 📸 Captures d'écran

### Arborescence principale

![Architecture](8cde38d1-0a5f-4ee3-8c50-4688ba9ff7bb.png)

> **Astuce** : d'autres captures (Postman, interface Angular, console) peuvent être ajoutées pour enrichir le README.

---

## 👤 Auteur

**Sara EL AMRANI**

* Étudiante en 2eme année Génie Logiciel
* Projet réalisé dans le cadre du
* Technologies utilisées : Spring Boot, Angular, HTML/CSS, JWT

---

