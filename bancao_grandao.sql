CREATE DATABASE sistema_chamados;

USE sistema_chamados;

CREATE TABLE empresa (
idEmpresa INT NOT NULL AUTO_INCREMENT,
nomeEmpresa VARCHAR(200),
enderecoEmpresa VARCHAR (200),
cnpjEmpresa VARCHAR (200),
PRIMARY KEY (idEmpresa)
);

CREATE TABLE filial (
idFilial INT NOT NULL AUTO_INCREMENT,
nomeFilial VARCHAR (200),
enderecoFilial VARCHAR (200),
cnpjFilial VARCHAR (30),
idEmpresa INT,
PRIMARY KEY (idFilial),
FOREIGN KEY (idEmpresa) REFERENCES empresa (idEmpresa)
ON DELETE CASCADE
);

CREATE TABLE setor (
idSetor INT NOT NULL AUTO_INCREMENT,
nomeSetor VARCHAR (50),
PRIMARY KEY (idSetor)
);

CREATE TABLE funcao (
idFuncao INT NOT NULL AUTO_INCREMENT,
descFuncao VARCHAR (200),
idSetor INT,
PRIMARY KEY (idFuncao),
FOREIGN KEY (idSetor) REFERENCES setor (idSetor)
ON DELETE CASCADE
);

CREATE TABLE categoria_chamado (
idCategoriaChamado INT NOT NULL AUTO_INCREMENT,
descCategoria VARCHAR (200),
PRIMARY KEY (idCategoriaChamado)
);

CREATE TABLE subcategoria_chamado (
idSubcategoriaChamado  INT NOT NULL AUTO_INCREMENT,
descSubcategoriaChamado VARCHAR (200),
idCategoriaChamado INT,
PRIMARY KEY (idSubcategoriaChamado),
FOREIGN KEY (idCategoriaChamado) REFERENCES categoria_chamado (idCategoriaChamado)
ON DELETE CASCADE
);

CREATE TABLE nivel_urgencia (
idNivelUrgencia INT NOT NULL AUTO_INCREMENT,
descNivelUrgencia VARCHAR (200),
PRIMARY KEY (idNivelUrgencia)
);

CREATE TABLE status_chamado (
idStatusChamado INT NOT NULL AUTO_INCREMENT,
descStatusChamado VARCHAR (200),
PRIMARY KEY (idStatusChamado)
);

CREATE TABLE usuario (
idUsuario INT NOT NULL AUTO_INCREMENT,
login VARCHAR (200),
PRIMARY KEY (idUsuario)
);

CREATE TABLE funcionario (
idFuncionario INT NOT NULL AUTO_INCREMENT,
nomeFuncionario VARCHAR (200),
emailFuncionario VARCHAR (200),
telefoneFuncionario VARCHAR (15),
ramalFuncionario VARCHAR (15),
idSetor INT,
idFuncao INT,
idUsuario INT,
idFilial INT,
PRIMARY KEY (idFuncionario),
FOREIGN KEY (idSetor) REFERENCES setor (idSetor),
FOREIGN KEY (idFuncao) REFERENCES funcao (idFuncao),
FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario),
FOREIGN KEY (idFilial) REFERENCES filial (idFilial)
ON DELETE CASCADE
);

CREATE TABLE chamado (
idChamado INT NOT NULL AUTO_INCREMENT,
tituloChamado VARCHAR (200),
descChamado VARCHAR (1000),
dataHora DATETIME,
idCategoriaChamado INT,
idSubcategoriaChamado INT,
idNivelUrgencia INT,
idUsuario INT,
idStatusChamado INT,
PRIMARY KEY (idChamado),
FOREIGN KEY (idCategoriaChamado) REFERENCES categoria_chamado (idCategoriaChamado),
FOREIGN KEY (idSubcategoriaChamado) REFERENCES subcategoria_chamado (idSubcategoriaChamado),
FOREIGN KEY (idNivelUrgencia) REFERENCES nivel_urgencia (idNivelUrgencia),
FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario),
FOREIGN KEY (idStatusChamado) REFERENCES status_chamado (idStatusChamado)
ON DELETE CASCADE
);


/************* INSERT *****************/

/* insert empresa */
INSERT INTO empresa VALUES
(NULL, " Empresa Legal", "Rua da Empresa Legal", "09.671.776/0001-08"),
(NULL, " Empresa Mais Legal", "Rua da Empresa Mais Legal", "47.506.226/0001-22"),
(NULL, " Empresa Daora", "Rua da Empresa Daora", "34.226.297/0001-20"),
(NULL, " Empresa Mais Daora", "Rua da Empresa Mais Daora", "00.841.570/0001-04"),
(NULL, " Empresa Super Legal", "Rua da Empresa Super Legal", "84.528.025/0001-52"),
(NULL, " Empresa Hiper Massa", "Rua da Empresa Hiper Massa", "34.941.109/0001-45"),
(NULL, " Empresa Massa", "Rua da Empresa Massa", "88.995.883/0001-68"),
(NULL, " Empresa Legal Demais", "Rua da Empresa Legal Demais", "45.602.742/0001-25"),
(NULL, " Empresa Hiper", "Rua da Empresa Hiper", "51.615.488/0001-00"),
(NULL, " Empresa Topzera", "Rua da Empresa Topzera", "84.488.361/0001-19");

select * from empresa;

/* insert filial */
INSERT INTO filial VALUES
(NULL, " Empresa Legal Stark ", "Rua da Empresa Legal Stark", "09.671.776/0001-07", 1),
(NULL, " Empresa Mais Legal Rogers", "Rua da Empresa Mais Legal Rogers", "47.506.226/0001-27", 2),
(NULL, " Empresa Daora Parker", "Rua da Empresa Daora Parker", "34.226.297/0001-27", 3),
(NULL, " Empresa Mais Daora Banner", "Rua da Empresa Mais Daora Banner", "00.841.570/0001-07", 4),
(NULL, " Empresa Super Legal Barton ", "Rua da Empresa Super Legal Barton", "84.528.025/0001-57", 5),
(NULL, " Empresa Hiper Massa Romanoff ", "Rua da Empresa Hiper Massa Romanoff", "34.941.109/0001-47", 6),
(NULL, " Empresa Massa Fury", "Rua da Empresa Massa Fury", "88.995.883/0001-67", 7),
(NULL, " Empresa Legal Demais Potts", "Rua da Empresa Legal Demais Potts", "45.602.742/0001-27", 8),
(NULL, " Empresa Hiper Lang ", "Rua da Empresa Hiper Lang", "51.615.488/0001-07", 9),
(NULL, " Empresa Topzera T'challa", "Rua da Empresa Topzera T'challa", "84.488.361/0001-17", 10);

select * from filial;

/* insert setor */
INSERT INTO setor VALUES
(NULL,"Setor Administrativo"),
(NULL,"Setor Financeiro"),
(NULL,"Setor T.I."),
(NULL,"Setor Comercial"),
(NULL,"Setor RH"),
(NULL,"Setor Operacional");

select * from setor;

/* insert função */
INSERT INTO funcao VALUES
(NULL, "Assitente Admistrativo", 1),
(NULL, "Contador (a)", 2),
(NULL, "Técnico em Informática", 3),
(NULL, "Vendedor (a)", 4),
(NULL, "Psicólogo (a)", 5),
(NULL, "Operador (a) de ", 6);

select * from funcao;

/* insert  categoria_chamado */
INSERT INTO categoria_chamado VALUES
(1, "Hardware"),
(2, "Software");

select * from categoria_chamado;

/* insert subcategoria chamado */
INSERT INTO subcategoria_chamado VALUES
(NULL, " Teclado", 1 ),
(NULL, " Mouse", 1 ),
(NULL, " Monitor", 1 ),
(NULL, " Estabilizador", 1 ),
(NULL, " Gabinete", 1 ),
(NULL, " Roteador", 1 ),
(NULL, " Cabo de Rede", 1 ),
(NULL, "Impressora", 1),
(NULL, " Instalação/Atualização de drivers da Impressora", 2 ),
(NULL, " Instalação/Atualização de Drivers de Áudio ", 2 ),
(NULL, " Instalação/Atualização Sistema Operacional", 2 ),
(NULL, " Formatação", 2 ),
(NULL, " Instalação/Atualização Driver de Rede", 2 ),
(NULL, " Criação de Usuário", 2 ),
(NULL, " Suporte Remoto", 2 ); 

select * from subcategoria_chamado;

/* insert nivel_urgencia */
INSERT INTO nivel_urgencia VALUES 
(1, "Urgente"),
(2, "Alto"), 
(3, "Médio"),
(4, "Razoável"),
(5, "Baixo");

select* from nivel_urgencia;

/* insert status_chamado */
INSERT INTO status_chamado VALUES
(1, "Concluído"),
(2, "Aguardando Retorno do Usuário"),
(3, "Em espera");

select * from status_chamado;

/* insert usuario */
INSERT INTO usuario VALUES 
(NULL, "Admin"),
(NULL, "Usuário");

select * from usuario;

/* insert funcionario */
INSERT INTO funcionario VALUES
(NULL, "Steve Rogers", "steve@rogers.com", "3521-0101", "150", 1, 1, 1, 1),
(NULL, "Anthony Stark", "tony@stark.com", "3521-0102", "151", 2, 2, 1, 2),
(NULL, "Peter Parker", "peter@parker.com", "3521-0103", "152", 3, 3, 2, 3),
(NULL, "Bucky Barnes", "bucky@barnes.com", "3521-0104", "153", 4, 4, 2, 4),
(NULL, "Bruce Banner", "bruce@banner.com", "3521-0105", "154", 5, 5, 1, 5),
(NULL, "Natasha Romanoff", "nat@romanoff.com", "3521-0106", "155", 6, 6, 1, 6),
(NULL, "Clint Barton", "clint@barton.com", "3521-0107", "156", 1, 1, 2, 7),
(NULL, "Stephen Strange", "stephen@strange.com", "3521-0108", "157", 2, 2, 2, 8),
(NULL, "Peter Quill", "peter@quill.com", "3521-0109", "158", 3, 3, 1, 9),
(NULL, "Carol Danvers", "carol@danvers.com", "3521-0110", "159", 4, 4, 1, 10);

select * from funcionario;

/* insert chamado */
INSERT INTO chamado VALUES
(NULL,"Teclado", "Problema com o teclado", '2020-10-01 13:00:00', 1, 1, 1, 1, 3),
(NULL,"Mouse", "Problema com o mouse", '2020-10-01 13:05:00', 1, 1, 2, 1, 3),
(NULL,"Monitor", "Problema com o monitor", '2020-10-01 13:10:00', 1, 1, 3, 1, 3),
(NULL,"Estabilizador", "Problema com o estabilizador", '2020-10-01 13:15:00', 1, 1, 4, 1, 3),
(NULL,"Gabinete", "Problema com o gabinete", '2020-10-01 13:20:00', 1, 1, 5, 1, 3),
(NULL,"Roteador", "Problema com o roteador", '2020-10-01 13:25:00', 1, 1, 1, 1, 3),
(NULL,"Cabo de Rede", "Problema com o cabo de rede", '2020-10-01 13:30:00', 1, 1, 2, 1, 3),
(NULL,"Impressora", "Problema com a impressora", '2020-10-01 13:35:00', 2, 1, 3, 1, 3),
(NULL,"Instalação", "Drivers Impressora", '2020-10-01 13:40:00', 2, 1, 4, 1, 3),
(NULL,"Atualização", "Drivers de Áudio", '2020-10-01 13:45:00', 2, 1, 5, 1, 3),
(NULL,"Instalação", "Sistema Operacional", '2020-10-01 13:50:00', 2, 1, 1, 1, 3),
(NULL,"Formatação", "Formatar o pc", '2020-10-01 13:55:00', 2, 1, 1, 1, 3),
(NULL,"Instalação", "Driver de Rede", '2020-10-01 14:00:00', 2, 1, 1, 1, 3),
(NULL,"Crição de Usuário", "Criar user", '2020-10-01 14:05:00', 2, 1, 1, 1, 3),
(NULL,"Suporte Remoto", "Suporte", '2020-10-01 14:10:00', 2, 1, 1, 1, 3);

select * from chamado;

update chamado set tituloChamado = "TESTE NO BANCO" where idChamado = 15;

select idChamado, login from chamado inner join usuario on chamado.idUsuario = idUsuario where idUsuario = 2;