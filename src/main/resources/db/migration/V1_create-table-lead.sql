CREATE TABLE dadoslead(
   id BIGINT NOT NULL auto_increment,
   nome VARCHAR(100) NOT NULL,   
   email VARCHAR(100) NOT NULL,
   telefone VARCHAR(100) NOT NULL,   
   PRIMARY KEY(id)
)

CREATE TABLE genero(
   id BIGINT NOT NULL auto_increment PRIMARY KEY,
   nome VARCHAR(100) NOT NULL,   
)

