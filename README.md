```
    ____                     _    __                                     
   / __ \___  ________  ____| |  / /___ __________ _____  ________  _____
  / /_/ / _ \/ ___/ _ \/ ___/ | / / __ `/ ___/ __ `/ __ \/ ___/ _ \/ ___/
 / _, _/  __(__  )  __/ /   | |/ / /_/ / /__/ /_/ / / / / /__/  __(__  ) 
/_/ |_|\___/____/\___/_/    |___/\__,_/\___/\__,_/_/ /_/\___/\___/____/  
```
## Projet fait par :
- Enzo P
- Richard D
- Brieuc C

### Voiture

- **GET** `/api/voiture`
  - Description: Récupère toutes les voitures.
- **GET** `/api/voiture/available`
  - Description: Récupère toutes les voitures disponibles entre deux dates.
- **GET** `/api/voiture/{id}`
  - Description: Récupère une voiture par son ID.
- **POST** `/api/voiture`
  - Description: Crée une nouvelle voiture.
  - Rôles requis: `ROLE_CAR_MANAGER`
- **PUT** `/api/voiture/{id}`
  - Description: Met à jour une voiture par son ID.
  - Rôles requis: `ROLE_CAR_MANAGER`
- **DELETE** `/api/voiture/{id}`
  - Description: Supprime une voiture par son ID.
  - Rôles requis: `ROLE_CAR_MANAGER`

### Marque

- **GET** `/api/marque`
  - Description: Récupère toutes les marques.
- **GET** `/api/marque/{id}`
  - Description: Récupère une marque par son ID.
- **POST** `/api/marque`
  - Description: Crée une nouvelle marque.
  - Rôles requis: `ROLE_CAR_MANAGER`
- **PUT** `/api/marque/{id}`
  - Description: Met à jour une marque par son ID.
  - Rôles requis: `ROLE_CAR_MANAGER`

### Modèle de Voiture

- **GET** `/api/modele/voiture`
  - Description: Récupère tous les modèles de voiture.
- **GET** `/api/modele/voiture/{id}`
  - Description: Récupère un modèle de voiture par son ID.
- **POST** `/api/modele/voiture`
  - Description: Crée un nouveau modèle de voiture.
  - Rôles requis: `ROLE_CAR_MANAGER`
- **PUT** `/api/modele/voiture/{id}`
  - Description: Met à jour un modèle de voiture par son ID.
  - Rôles requis: `ROLE_CAR_MANAGER`

### Réservation de Voiture

- **GET** `/api/reservation/voiture/all`
  - Description: Récupère toutes les réservations de voiture.
  - Rôles requis: `ROLE_CAR_MANAGER`
- **GET** `/api/reservation/voiture`
  - Description: Récupère toutes les réservations de voiture pour l'utilisateur authentifié.
  - Rôles requis: Authentifié
- **GET** `/api/reservation/voiture/{id}`
  - Description: Récupère une réservation de voiture par son ID.
  - Rôles requis: Authentifié
- **POST** `/api/reservation/voiture`
  - Description: Crée une nouvelle réservation de voiture.
  - Rôles requis: `ROLE_USER`

### Compagnie

- **GET** `/api/vol/compagnie`
  - Description: Récupère toutes les compagnies.
- **GET** `/api/vol/compagnie/{id}`
  - Description: Récupère une compagnie par son ID.
- **POST** `/api/vol/compagnie`
  - Description: Crée une nouvelle compagnie.
  - Rôles requis: `ROLE_VOL_MANAGER`
- **PUT** `/api/vol/compagnie/{id}`
  - Description: Met à jour une compagnie par son ID.
  - Rôles requis: `ROLE_VOL_MANAGER`
- **DELETE** `/api/vol/compagnie/{id}`
  - Description: Supprime une compagnie par son ID.
  - Rôles requis: `ROLE_VOL_MANAGER`

### Aéroport

- **GET** `/api/vol/aeroport`
  - Description: Récupère tous les aéroports.
  - Rôles requis: Authentifié
- **GET** `/api/vol/aeroport/{id}`
  - Description: Récupère un aéroport par son ID.
  - Rôles requis: Authentifié
- **POST** `/api/vol/aeroport`
  - Description: Crée un nouvel aéroport.
  - Rôles requis: `ROLE_VOL_MANAGER`
- **PUT** `/api/vol/aeroport/{id}`
  - Description: Met à jour un aéroport par son ID.
  - Rôles requis: `ROLE_VOL_MANAGER`

### Vol

- **GET** `/api/vol`
  - Description: Récupère tous les vols.
  - Rôles requis: Authentifié
- **GET** `/api/vol/{id}`
  - Description: Récupère un vol par son ID.
  - Rôles requis: Authentifié
- **GET** `/api/vol/search`
  - Description: Recherche des vols entre deux dates.
- **POST** `/api/vol`
  - Description: Crée un nouveau vol.
  - Rôles requis: `ROLE_VOL_MANAGER`
- **PUT** `/api/vol/{id}`
  - Description: Met à jour un vol par son ID.
  - Rôles requis: `ROLE_VOL_MANAGER`
- **DELETE** `/api/vol/{id}`
  - Description: Supprime un vol par son ID.
  - Rôles requis: `ROLE_VOL_MANAGER`

### Réservation de Vol

- **GET** `/api/vol/reservationvol`
  - Description: Récupère toutes les réservations de vol.
  - Rôles requis: Authentifié
- **GET** `/api/vol/reservationvol/{id}`
  - Description: Récupère une réservation de vol par son ID.
  - Rôles requis: Authentifié
- **POST** `/api/vol/reservationvol`
  - Description: Crée une nouvelle réservation de vol.
  - Rôles requis: Authentifié
- **PUT** `/api/vol/reservationvol/{id}`
  - Description: Met à jour une réservation de vol par son ID.
  - Rôles requis: Authentifié
- **DELETE** `/api/vol/reservationvol/{id}`
  - Description: Supprime une réservation de vol par son ID.
  - Rôles requis: Authentifié

### Hôtel

- **GET** `/api/hotel`
  - Description: Récupère tous les hôtels.
- **GET** `/api/hotel/{id}`
  - Description: Récupère un hôtel par son ID.
- **GET** `/api/hotel/ville/{villeId}`
  - Description: Récupère tous les hôtels dans une ville.
- **POST** `/api/hotel`
  - Description: Crée un nouvel hôtel.
  - Rôles requis: `ROLE_HOTEL_MANAGER`
- **PUT** `/api/hotel/{id}`
  - Description: Met à jour un hôtel par son ID.
  - Rôles requis: `ROLE_HOTEL_MANAGER`
- **DELETE** `/api/hotel/{id}`
  - Description: Supprime un hôtel par son ID.
  - Rôles requis: `ROLE_HOTEL_MANAGER`

### Chambre

- **GET** `/api/chambre`
  - Description: Récupère toutes les chambres.
- **GET** `/api/chambre/{id}`
  - Description: Récupère une chambre par son ID.
- **GET** `/api/chambre/hotel/{hotelId}`
  - Description: Récupère toutes les chambres d'un hôtel.
- **POST** `/api/chambre`
  - Description: Crée une nouvelle chambre.
  - Rôles requis: `ROLE_HOTEL_MANAGER`
- **PUT** `/api/chambre/{id}`
  - Description: Met à jour une chambre par son ID.
  - Rôles requis: `ROLE_HOTEL_MANAGER`
- **DELETE** `/api/chambre/{id}`
  - Description: Supprime une chambre par son ID.
  - Rôles requis: `ROLE_HOTEL_MANAGER`

### Réservation d'Hôtel

- **GET** `/api/reservation-hotel`
  - Description: Récupère toutes les réservations d'hôtel.
- **GET** `/api/reservation-hotel/{id}`
  - Description: Récupère une réservation d'hôtel par son ID.
- **POST** `/api/reservation-hotel`
  - Description: Crée une nouvelle réservation d'hôtel.
  - Rôles requis: Authentifié
- **PUT** `/api/reservation-hotel/{id}`
  - Description: Met à jour une réservation d'hôtel par son ID.
  - Rôles requis: Authentifié
- **DELETE** `/api/reservation-hotel/{id}`
  - Description: Supprime une réservation d'hôtel par son ID.
  - Rôles requis: Authentifié

### Utilisateur

- **POST** `/api/utilisateur/auth`
  - Description: Authentifie un utilisateur.
- **POST** `/api/utilisateur/create`
  - Description: Crée un nouvel utilisateur.
- **GET** `/api/utilisateur/get`
  - Description: Récupère les informations de l'utilisateur authentifié.
  - Rôles requis: Authentifié
- **PUT** `/api/utilisateur/update`
  - Description: Met à jour les informations de l'utilisateur authentifié.
  - Rôles requis: Authentifié
- **DELETE** `/api/utilisateur/delete`
  - Description: Supprime un utilisateur par son ID.
  - Rôles requis: `ROLE_ADMIN`
- **POST** `/api/utilisateur/logout`
  - Description: Déconnecte l'utilisateur authentifié.
  - Rôles requis: Authentifié

### Rôle

- **POST** `/api/role`
  - Description: Crée un nouveau rôle.
- **PUT** `/api/role/{id}`
  - Description: Met à jour un rôle par son ID.
  - Rôles requis: `ROLE_ADMIN`

### Pays

- **GET** `/api/pays`
  - Description: Récupère tous les pays.
- **GET** `/api/pays/{id}`
  - Description: Récupère un pays par son ID.
- **POST** `/api/pays`
  - Description: Crée un nouveau pays.
  - Rôles requis: `ROLE_ADMIN`
- **PUT** `/api/pays/{id}`
  - Description: Met à jour un pays par son ID.
  - Rôles requis: `ROLE_ADMIN`

### Ville

- **GET** `/api/ville`
  - Description: Récupère toutes les villes.
- **GET** `/api/ville/{id}`
  - Description: Récupère une ville par son ID.
- **POST** `/api/ville`
  - Description: Crée une nouvelle ville.
  - Rôles requis: `ROLE_ADMIN`
- **PUT** `/api/ville/{id}`
  - Description: Met à jour une ville par son ID.
  - Rôles requis: `ROLE_ADMIN`