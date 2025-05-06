DROP DATABASE IF EXISTS cine_MarcosPerezRamirez;
CREATE DATABASE IF NOT EXISTS cine_MarcosPerezRamirez;
USE cine_MarcosPerezRamirez;

CREATE TABLE generos (
    id_genero INT PRIMARY KEY,
    nombre_genero VARCHAR(50) NOT NULL
);

CREATE TABLE peliculas (
    id_pelicula INT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    duracion INT NOT NULL,  -- Duración en minutos
    director VARCHAR(100),
    puntuacion INT,
    id_genero INT,
    FOREIGN KEY (id_genero) REFERENCES generos(id_genero)
);

INSERT INTO generos (id_genero, nombre_genero) VALUES (1, 'Acción');
INSERT INTO generos (id_genero, nombre_genero) VALUES (2, 'Comedia');
INSERT INTO generos (id_genero, nombre_genero) VALUES (3, 'Drama');

INSERT INTO peliculas (id_pelicula, titulo, duracion, director, puntuacion, id_genero) 
VALUES (1, 'Los Vengadores', 143, 'Joss Whedon', 8, 1);

INSERT INTO peliculas (id_pelicula, titulo, duracion, director, puntuacion, id_genero) 
VALUES (2, 'El Lobo de Wall Street', 180, 'Martin Scorsese', 9, 2);

INSERT INTO peliculas (id_pelicula, titulo, duracion, director, puntuacion, id_genero) 
VALUES (3, 'Gladiator', 155, 'Ridley Scott', 10, 3);

