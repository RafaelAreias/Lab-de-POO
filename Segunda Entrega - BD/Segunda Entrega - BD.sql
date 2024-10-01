DROP DATABASE IF EXISTS integracao;
CREATE DATABASE integracao;
USE integracao;

#COMANDO PARA DESATIVAR O SAFE MODE
SET SQL_SAFE_UPDATES = 0;

CREATE TABLE IF NOT EXISTS cinema (
    id_cinema INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS sala (
    id_sala INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    numero INT NOT NULL,
    capacidade INT NOT NULL
);