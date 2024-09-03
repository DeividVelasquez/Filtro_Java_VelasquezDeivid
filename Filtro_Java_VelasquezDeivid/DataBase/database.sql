-- Active: 1725362810306@@172.16.101.155@3306@Konoha
create database Konoha;

use Konoha;

create table Ninja(
    ninjaID int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(225),
    rango enum('Principiante', 'Intermedio', 'Maestro'),
    aldea varchar(225)
);

create table Mision (
    misionID int AUTO_INCREMENT PRIMARY KEY,
    descripcion varchar(300),
    rango enum('Principiante', 'Intermedio', 'Maestro'),
    recompensa decimal(10,2)
);

create table MisionNinja(
    ninjaID int,
    misionID int,
    fechaInicio date,
    fechaFin date,    
    PRIMARY KEY(ninjaID, misionID),
    Foreign Key (ninjaID) REFERENCES Ninja(ninjaID),
    Foreign Key (misionID) REFERENCES Mision(misionID)
);

create table Habilidad(
    ninjaID int PRIMARY KEY,
    nombre varchar(225),
    descripcion varchar(300),
    Foreign Key (ninjaID) REFERENCES Ninja(ninjaID)
);

show tables;