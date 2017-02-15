#drop database mygym;
create database mygym;
use mygym;

create table Login (
	login varchar(15) not null,
    senha varchar(30) not null,
    constraint login_pk primary key(login)
);

create table Pessoa (
	nome varchar(100) not null,
    cpf varchar(12) not null,
    login_pessoa varchar(15) not null,
    constraint pessoa_pk primary key(cpf),
    constraint pessoa_login_fk foreign key(login_pessoa) references Login(login) 
);

create table Administrador (
	cpf_administrador varchar(12) not null,
    constraint cpf_admin_pk primary key(cpf_administrador),
    constraint cpf_admin_fk foreign key(cpf_administrador) references Pessoa(cpf)
);

create table Treinador (
	cpf_treinador varchar(12) not null,
    constraint cpf_treinador_pk primary key(cpf_treinador),
    constraint cpf_treinador_fk foreign key(cpf_treinador) references Pessoa(cpf)
);

create table Avaliacao (
	id_avaliacao int not null AUTO_INCREMENT,
	#Anamnese
	objetivo varchar(500) not null,
    praticaExercicio char(4) not null,  #tratar no codigo java
    medicamento varchar(250) not null,
    estadoCirurgia char(4) not null,  #tratar no codigo java
    doencaFamiliar varchar(500) not null,
    observacoes varchar(500) not null,
    #Coronariano
	idade int not null,
    sexo char(10) not null, #tratar no codigo java
    peso float(3,2) not null,
    exercicioFisico char(4) not null,  #tratar no codigo java
    historicoFamiliar varchar(500) not null,
    tabagismo char(4) not null,  #tratar no codigo java
    observacoes2 varchar(500) not null,
    constraint id_avaliacao_pk primary key(id_avaliacao)
) AUTO_INCREMENT = 1;

create table Cliente (
	cpf_cliente varchar(12) not null,
	endereco varchar(100) not null,
    idade int not null,
    telefone varchar(12) not null,
    email varchar(20) not null,
    id_avaliacao_cli int not null,
    cpf_treinador_cli varchar(12) not null,
    constraint cpf_cliente_pk primary key(cpf_cliente),
    constraint cpf_cliente_fk foreign key(cpf_cliente) references Pessoa(cpf),
    constraint id_avaliacao_cli_fk foreign key(id_avaliacao_cli) references Avaliacao(id_avaliacao),
    constraint cpf_treinador_cli_fk foreign key(cpf_treinador_cli) references Treinador(cpf_treinador)
);

create table Aula (
	nomeAula varchar(100) not null,
    diaDaSemana varchar(20) not null,
    horaDaAula varchar(20) not null,
    constraint nomeAula_pk primary key(nomeAula)
);

create table Treino (
	nomeDoTreino varchar(100) not null,
    nomeExercicio varchar(100) not null,
    repeticoes int not null,
    cpf_cliente_treino varchar(12) not null,
    constraint nomeDoTreino_pk primary key(nomeDoTreino),
    constraint cpf_cliente_treino_fk foreign key(cpf_cliente_treino) references Cliente(cpf_cliente)
);