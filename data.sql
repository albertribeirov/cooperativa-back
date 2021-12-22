INSERT INTO endereco
VALUES (1,'Janga','53110120','Paulista','2021-11-30 21:05:48.000000','Avenida Amazonas, 1020','2021-11-30 21:05:48.000000'),
       (2,'Universitário','53110120','Caruaru','2021-11-30 21:22:15.000000','Avenida Portugal, 102','2021-11-30 21:22:15.000000');

INSERT INTO cliente (ativo, cpf_cnpj, create_time, nome, observacao, telefone_dois, telefone_um, update_time, endereco_id)
VALUES (1, 07590604445, current_timestamp(), 'Albert Ribeiro', 'Teste de API', 84998460000, 11998565656, current_timestamp(), 1);