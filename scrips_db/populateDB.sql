use sgpr;
/*Insere dados no banco*/

insert into passageiro values('95819702409', 'Julio Cauã Cardoso', '131231231', 'Julio@gmail.com'), 
('40811470784', 'Kaique Cauã Tomás Rodrigues', '(82) 3836-2691', 'kaiquecauatomasrodrigues_@zf.com'), 
('94376558478', 'Daniela Isis Rezende', '(68) 2608-2312', 'danielasisrezende@mail.com'), 
('73692279108', 'Heloisa Jennifer Silvana Almada', '(48) 3503-8468', 'heloisajennifermada@yaooll.com'),
('94425112385', 'Vera Cristiane Lopes', '(31) 2974-3184', 'veracristianelopess@pmi.com');

insert into motorista values('29306192100', 'Isabella Rayssa Carvalho', '(92) 2874-7585', 'isabellara-98@seraobenedito.com.br'),
('12223087973', 'Natália Mirella Nogueira', '(79) 3728-8815', 'nataliamirellanogueira@avantii.com.br'),
('33647934097','Iago Luan Assis','(61) 3748-6077','iagoluanassis@tvglobo.com.br'),
('67727154970','Rodrigo Anderson Aragão','(86) 2809-9636','rodrigoanderson_@mourafiorito.com'),
('92782758080','Luan Igor Moura','(66) 3873-9715','luanigormoura_@royalplas.com.br'),
('91937516482','Carlos Eduardo Renato Lorenzo de Paula','(21) 2647-6188','ccarloseduardorenatolorenzodepaula@fundasa.com.br')
;

insert into onibus values('IDB2528', 30, 'medio porte'),
('HZV8911', 20, 'luxo'),
('GON9192', 59, 'normal'),
('LWE6032', 59, 'normal'),
('JCP5031', 59, 'normal'),
('MWP4981', 59, 'normal'),
('IAA7858', 59, 'normal'),
('JTT1442', 999, 'circular')
;

insert into cidades (nome) values('Natal'),
('Assu'),
('Mossoro'),
('Macau'),
('Serra do Mel'),
('Apodi'),
('Itaja'),
('Fernando Pedroza'),
('Lajes'),
('Riachuelo'),
('Macaiba'),
('Jandaíra'),
('João Câmara'),
('Taipu'),
('Ceará-Mirim')
;

insert into rota values('a-n', 'Assu-Natal', 2, 1),
('m-n', 'Mossoro-Natal', 3, 1),
('mc-n', 'Macau-Natal', 4, 1),
('s-a', 'Serra do Mel-Apodi', 5, 6)
;

insert into rota_cidades values('a-n', 2, 1),
('a-n', 7, 2),
('a-n', 8, 3),
('a-n', 9, 4),
('a-n', 10, 5),
('a-n', 11, 6),
('a-n', 1, 7),
('m-n', 3, 1),
('m-n', 2, 2),
('m-n', 7, 3),
('m-n', 8, 4),
('m-n', 9, 5),
('m-n', 10, 6),
('m-n', 11, 7),
('m-n', 1, 8),
('mc-n', 4, 1),
('mc-n', 12, 2),
('mc-n', 13, 3),
('mc-n', 14, 4),
('mc-n', 15, 5),
('mc-n', 1, 6),
('s-a', '5', 1),
('s-a', '3', 2),
('s-a', 6, 3)
;

/*select * from rota as r, rota_cidades as rc where r.id_rota = rc.id_rota; */