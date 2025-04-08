create table webdyn_login(
    id int auto_increment primary key,
    nom varchar(255),
    motDePasse varchar(255)
);

create table webdyn_credit(
    id int auto_increment primary key,
    libelle varchar(255),
    montant varchar(255)
);

create table webdyn_depense(
    id int auto_increment primary key,
    id_credit  int references credit(id),
    date_ajout date,
    montant int
);

insert into webdyn_login(nom, motDePasse) values ("admin","admin");