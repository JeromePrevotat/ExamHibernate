# ExamHibernate

## Architecture DB: Mysql

## Entities CRUD

Managed by the Abstract Class GenericDaoImp which implements the GeneriDao Interface

## Specific Entities Methods

Managed by the Entity Dao

## How to Run

docker compose up --build app

## DB Access

docker run exec -it db bash
mysql -p
password : root

(totally secure !)

## Tests

# Run Main

# Expected results

3 Utilisateurs créés (Admin, Bob, Alice)
3 Lieux créés (HB, Jaude, Gaillard)
4 Bornes créées (2 à HB, 1 Jaude, 1 Gaillard)
3 Reservations créées (toutes par Alice)

Affichage de Bob, HB, 1ère borne HB, 1ère Reservation

Mise à jour de l'Email de Bob + verif
Mise à jour de l'Adresse du lieu HB + verif
Mise à jour de l'Etat de la Borne + verif
Mise à jour du Statut de la Reservation + verif

Suppression de Bob, Gaillard, Borne Gaillard et d'une Reservation

Affichage de toutes les entrées restantes en DB

BONUS : WIP

Clean up DB
