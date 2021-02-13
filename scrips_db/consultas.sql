create user 'springuser'@'%' identified by 'ThePassword';
grant all on sgpr.* to 'springuser'@'%';

select * from viagens;

select * from viagem;

delete from viagem;

select * from empresa;

select v.id_viagem as id, c.nome as Origem, c1.nome as Destino, v.data_viagem, v.hora_saida, v.preco, m.nome as motorista, o.num_placa as onibus, r.id_rota as rota, v.status_saida as estado, e.nome as empresa 
from viagem as v, motorista as m, onibus as o, rota as r, cidades as c, cidades as c1, empresa as e
where 
v.rota = r.id_rota and 
v.motorista = m.cpf and
v.onibus = o.num_placa and
r.origem = c.id_cidade and
r.destino = c1.id_cidade and
v.empresa = e.id_empresa;