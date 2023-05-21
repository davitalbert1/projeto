drop database projeto;
create database projeto;
use projeto;

create table if not exists sala(
id int primary key not null,
bloco varchar(30) not null,
numero int not null,
curso varchar(50),
tipo varchar(20)
);

create table if not exists pessoa(
id int primary key not null,
nome varchar(30)not null,
cpf char(15) not null,
data_nascimeto date
);

create table if not exists curso(
id int primary key not null,
nome varchar(30) not null,
tipo varchar(20)
);

create table if not exists disciplina(
id int primary key not null,
numero_pessoas int not null,
curso varchar(50),
cursoID int,
salaID int,
FOREIGN KEY (cursoID) REFERENCES curso(id),
FOREIGN KEY (salaID) REFERENCES sala(id)
);

create table if not exists turma(
id int primary key not null,
numero_aluno int not null,
curso varchar(50),
cursoID int,
disciplinaID int,
salaID int,
FOREIGN KEY (disciplinaID) REFERENCES disciplina(id),
FOREIGN KEY (salaID) REFERENCES sala(id),
FOREIGN KEY (cursoID) REFERENCES curso(id)
);

create table if not exists professor(
id int primary key not null,
nome varchar(30)not null,
cpf char(15) not null,
salario float not null,
data_contratado date not null,
demitido BOOLEAN,
data_demitido date ,
disciplina varchar(40),
disciplinaID int,
pessoaID int,
FOREIGN KEY (pessoaID) REFERENCES pessoa(id),
FOREIGN KEY (disciplinaID) REFERENCES disciplina(id)
);

create table if not exists aluno(
id int primary key not null,
nome varchar(30)not null,
cpf char(15) not null,
curso varchar(50),
disciplina varchar(30),
turma varchar(30),
sala varchar(15),
disciplinaID int,
turmaID int,
pessoaID int,
FOREIGN KEY (pessoaID) REFERENCES pessoa(id),
FOREIGN KEY (disciplinaID) REFERENCES disciplina(id),
FOREIGN KEY (turmaID) REFERENCES turma(id)
);