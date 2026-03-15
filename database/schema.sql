-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS ifachados;

USE ifachados;

-- ===============================
-- Tabela de usuários
-- ===============================

CREATE TABLE usuario (
   matricula VARCHAR(45) NOT NULL,
   nome VARCHAR(100) NOT NULL,
   email VARCHAR(45) NOT NULL,
   senha VARCHAR(45) NOT NULL,
   tipo ENUM('Admin','Usuario') NOT NULL,
   PRIMARY KEY (matricula)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ===============================
-- Tabela de objetos
-- ===============================

CREATE TABLE objetos (
   id_objeto INT UNSIGNED NOT NULL AUTO_INCREMENT,
   tipo_registro ENUM('Perdido','Encontrado') NOT NULL,
   nome_objeto VARCHAR(45) NOT NULL,
   descricao VARCHAR(255) NOT NULL,
   categoria VARCHAR(45) NOT NULL,
   data_ocorrencia VARCHAR(45) NOT NULL,
   local VARCHAR(45) NOT NULL,
   status ENUM('Perdido','Encontrado','Em Validação','Devolvido') NOT NULL,
   matricula_usuario VARCHAR(45) NOT NULL,

   PRIMARY KEY (id_objeto),

   CONSTRAINT fk_objeto_usuario
   FOREIGN KEY (matricula_usuario)
   REFERENCES usuario(matricula)
);

-- ===============================
-- Tabela de correspondência
-- ===============================

CREATE TABLE match_objeto (
   id_match INT NOT NULL AUTO_INCREMENT,
   id_objeto_perdido INT UNSIGNED NOT NULL,
   id_objeto_encontrado INT UNSIGNED NOT NULL,
   score DOUBLE NOT NULL,
   status_match ENUM('Sugerido','Confirmado','Recusado','Devolvido'),

   PRIMARY KEY (id_match),

   CONSTRAINT fk_match_perdido
   FOREIGN KEY (id_objeto_perdido)
   REFERENCES objetos(id_objeto)
   ON DELETE CASCADE,

   CONSTRAINT fk_match_encontrado
   FOREIGN KEY (id_objeto_encontrado)
   REFERENCES objetos(id_objeto)
   ON DELETE CASCADE
);

-- ===============================
-- Tabela de devolução
-- ===============================

CREATE TABLE devolucao (
   id_devolucao INT UNSIGNED NOT NULL AUTO_INCREMENT,
   id_match INT NOT NULL,
   data_devolucao VARCHAR(10) NOT NULL,
   observacao VARCHAR(255),

   PRIMARY KEY (id_devolucao),

   CONSTRAINT fk_devolucao_match
   FOREIGN KEY (id_match)
   REFERENCES match_objeto(id_match)
   ON DELETE CASCADE
);








