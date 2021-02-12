create user 'springuser'@'%' identified by 'ThePassword';
grant all on sgpr.* to 'springuser'@'%';

select * from viagens;

select * from viagem;

delete from viagem;