CREATE SCHEMA IF NOT EXISTS Integracao DEFAULT CHARACTER SET utf8;
USE Integracao;

-- drop database integracao;

CREATE TABLE IF NOT EXISTS Filme (
  idFilme INT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(45) NOT NULL,
  duracao INT NOT NULL,
  classificacao INT NULL,
  PRIMARY KEY (idFilme)
);

CREATE TABLE IF NOT EXISTS Shopping (
  idShopping INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  endereco VARCHAR(45) NOT NULL,
  horario_funcionamento VARCHAR(45) NOT NULL,
  PRIMARY KEY (idShopping),
  UNIQUE (nome),
  UNIQUE (endereco)
);

CREATE TABLE IF NOT EXISTS Cinema (
  idCinema INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  shopping_id INT NOT NULL,
  PRIMARY KEY (idCinema),
  UNIQUE (nome),
  CONSTRAINT fk_Cinema_Shopping
    FOREIGN KEY (shopping_id)
    REFERENCES Shopping (idShopping)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Sala (
  idSala INT NOT NULL AUTO_INCREMENT,
  numero INT UNSIGNED NOT NULL,
  capacidade INT UNSIGNED NOT NULL,
  cinema_id INT NOT NULL,
  PRIMARY KEY (idSala),
  CONSTRAINT fk_Sala_Cinema
    FOREIGN KEY (cinema_id)
    REFERENCES Cinema (idCinema)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Sessao (
  idSessao INT NOT NULL AUTO_INCREMENT,
  data_horario varchar(45) NOT NULL,
  sala_id INT NOT NULL,
  filme_id INT NOT NULL,
  PRIMARY KEY (idSessao),
  CONSTRAINT fk_Sessao_Sala
    FOREIGN KEY (sala_id)
    REFERENCES Sala (idSala)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_Sessao_Filme
    FOREIGN KEY (filme_id)
    REFERENCES Filme (idFilme)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Cliente (
  idCliente INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  idade INT NOT NULL,
  PRIMARY KEY (idCliente)
);

CREATE TABLE IF NOT EXISTS Ingresso (
  idIngresso INT NOT NULL AUTO_INCREMENT,
  preco FLOAT NOT NULL,
  poltrona VARCHAR(45) NOT NULL,
  sessao_id INT NOT NULL,
  cliente_id INT NOT NULL,
  PRIMARY KEY (idIngresso),
  CONSTRAINT fk_Ingresso_Sessao
    FOREIGN KEY (sessao_id)
    REFERENCES Sessao (idSessao)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_Ingresso_Cliente
    FOREIGN KEY (cliente_id)
    REFERENCES Cliente (idCliente)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

select * from shopping;
select * from cinema;
select * from sala;
