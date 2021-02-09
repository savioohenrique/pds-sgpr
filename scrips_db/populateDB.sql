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

insert into rota values('a-n', 'Assu-Natal', 'Assu', 'Natal'),
('m-n', 'Mossoro-Natal', 'Mossoro', 'Natal'),
('mc-n', 'Macau-Natal', 'Macau', 'Natal'),
('s-a', 'Serra do Mel-Apodi', 'Serra do mel', 'Apodi')
;

insert into rota_cidades values('a-n', 'Assu'),
('a-n', 'Itaja'),
('a-n', 'Fernando Pedroza'),
('a-n', 'Lajes'),
('a-n', 'Riachuelo'),
('a-n', 'Macaiba'),
('a-n', 'Natal'),
('m-n', 'Mosorro'),
('m-n', 'Assu'),
('m-n', 'Itaja'),
('m-n', 'Fernando Pedroza'),
('m-n', 'Lajes'),
('m-n', 'Riachuelo'),
('m-n', 'Macaiba'),
('m-n', 'Natal'),
('mc-n', 'Macau'),
('mc-n', 'Jandaíra'),
('mc-n', 'João Câmara'),
('mc-n', 'Taipu'),
('mc-n', 'Ceará-Mirim'),
('mc-n', 'Natal'),
('s-a', 'Serra do Mel'),
('s-a', 'Mossoro'),
('s-a', 'Apodi')
;

/*select * from rota as r, rota_cidades as rc where r.id_rota = rc.id_rota; */