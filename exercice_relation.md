### **Exercice : Ajout des Tables `Editeurs`, `Categories` et `Etagères`**

L'objectif de cet exercice est de mettre en pratique les notions liées aux relations entre les entités : `Editeurs`, `Categories` et `Etagères`. Ces nouvelles tables introduiront des relations supplémentaires avec la table existante `Livres`.

#### **Contexte :**
Nous souhaitons permettre une gestion plus complète des livres dans notre bibliothèque. Chaque livre peut appartenir à une **catégorie**, avoir un **éditeur**, et être stocké sur une **étagère** dans la bibliothèque.

---

#### **1. Création des Tables**

**Table `Editeurs` :**
Cette table stocke les informations sur les éditeurs de livres.

- **Champs** :
  - `id` (clé primaire)
  - `nom` (obligatoire, nom de l'éditeur)
  - `email` (obligatoire, email de contact)
  - `adresse` (facultatif, adresse de l'éditeur)

**Table `Categories` :**
Cette table stocke les catégories auxquelles un livre peut appartenir.

- **Champs** :
  - `id` (clé primaire)
  - `nom` (obligatoire, nom de la catégorie)

**Table `Etagères` :**
Cette table stocke les informations sur les étagères dans la bibliothèque où les livres sont physiquement rangés.

- **Champs** :
  - `id` (clé primaire)
  - `numero` (obligatoire, numéro ou code de l'étagère)
  - `emplacement` (facultatif, emplacement de l'étagère dans la bibliothèque)

---

#### **2. Relations entre les Tables**

**Relation `Livre - Editeur` (Many-to-One)** :
- Un livre est publié par un seul **éditeur**, mais un éditeur peut publier plusieurs livres.
  - Clé étrangère dans la table `Livres` : `editeur_id`

**Relation `Livre - Categorie` (Many-to-One)** :
- Un livre appartient à une seule **catégorie**, mais une catégorie peut contenir plusieurs livres.
  - Clé étrangère dans la table `Livres` : `categorie_id`

**Relation `Livre - Etagère` (Many-to-One)** :
- Un livre est placé sur une seule **étagère**, mais une étagère peut contenir plusieurs livres.
  - Clé étrangère dans la table `Livres` : `etagere_id`

---