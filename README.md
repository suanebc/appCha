# appCha 


# O Projeto Integrador é uma aplicação que articula as capacidades adquiridas no Curso Informática para Web do SENAI que visa o aprimoramento das competências profissionais em desenvolvimento.

# Para integrar corretamente a aplicação com o banco de dados é necessário criar um  banco de dados da seguinte forma :
# CREATE DATABASE chas;
# USE chas;
# CREATE TABLE produto(
idproduto int NOT NULL AUTO_INCREMENT,
nome varchar(20) NOT NULL,
preco varchar(50),
idtipo int,
img longblob NOT NULL,
descricao char(250),
primary key (idproduto)
);
# CREATE TABLE tipo(
idtipo int NOT NULL AUTO_INCREMENT,
nome varchar(150) NOT NULL,
primary key (idtipo),
);
ALTER TABLE produto;
ADD CONSTRAINT idtipo FOREIGN KEY (idproduto) REFERENCES produto (idproduto);

# As imagnes referentes ao produto estão no diretório static.imagens
