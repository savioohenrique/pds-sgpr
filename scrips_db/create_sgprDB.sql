create database sgpr;
use sgpr;

create table passageiro(
	cpf char(11), 
    nome varchar(200) not null,
    telefone varchar(15),
    email varchar(100),
    
    primary key(cpf)
);

create table motorista(
	cpf char(11), 
    nome varchar(200) not null,
    telefone varchar(15) not null,
    email varchar(100) not null,
    
    primary key(cpf)
);

create table onibus(
	num_placa char(7),
    num_assentos int not null,
    tipo varchar(45),
    
    primary key(num_placa)
);

create table cidades(
	id_cidade int auto_increment,
    nome varchar(100),
    
    primary key(id_cidade)
);

/*As tabelas a partir daqui fazem referencia as que estão acima.*/ 

create table rota(
	id_rota varchar(10),
    nome_rota varchar(45),
    origem int not null,
    destino int not null,
    
    primary key(id_rota),
    
    foreign key(origem)
		references cidades(id_cidade)
	on update cascade
    on delete cascade,
    
    foreign key(destino)
		references cidades(id_cidade)
	on update cascade
    on delete cascade
);

create table rota_cidades(
	id_rota varchar(10),
	id_cidade int,
    num_seq int not null,
    
    primary key(id_rota, id_cidade),
    
    foreign key(id_rota)
		references rota(id_rota)
	on update cascade
    on delete cascade,
    
    foreign key(id_cidade)
		references cidades(id_cidade)
	on update cascade
    on delete cascade
);

create table viagem(
	id_viagem int,
    data_viagem date,
    status_saida varchar(45),
    hora_saida varchar(5),
    rota varchar(10),
    motorista varchar(11),
    onibus varchar(7),
    
    primary key(id_viagem, data_viagem),
    
    foreign key(rota)
		references rota(id_rota)
	on update cascade
    on delete cascade,
    
    foreign key(motorista)
		references motorista(cpf)
	on update cascade
    on delete cascade,
    
    foreign key(onibus)
		references onibus(num_placa)
	on update cascade
    on delete cascade
);

create table passagem(
	cod_validacao varchar(45),
    viagem int not null,
    data_validade date not null,
    num_assento int not null,
    cpf_dono varchar(11) not null,
    
    primary key(cod_validacao),
    
    foreign key(cpf_dono)
		references passageiro(cpf)
	on update cascade
    on delete cascade,
    
    foreign key(viagem, data_validade)
		references viagem(id_viagem, data_viagem)
	on update cascade
    on delete cascade
);

create view viagens as
select c.nome as Origem, c1.nome as Destino, v.data_viagem, v.hora_saida, m.nome as motorista, o.num_placa as onibus
from viagem as v, motorista as m, onibus as o, rota as r, cidades as c, cidades as c1
where 
v.rota = r.id_rota and 
v.motorista = m.cpf and
v.onibus = o.num_placa and
r.origem = c.id_cidade and
r.destino = c1.id_cidade;

drop view viagens;