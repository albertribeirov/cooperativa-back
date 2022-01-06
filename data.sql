INSERT INTO endereco
VALUES (1,'Janga','53110120','Paulista','2021-11-30 21:05:48.000000','Avenida Amazonas, 1020','2021-11-30 21:05:48.000000'),
       (2,'Universitário','53110120','Caruaru','2021-11-30 21:22:15.000000','Avenida Portugal, 102','2021-11-30 21:22:15.000000');

INSERT INTO cliente (ativo, cpf_cnpj, create_time, nome, observacao, telefone_dois, telefone_um, update_time, endereco_id)
VALUES (1, 07590604445, current_timestamp(), 'Albert Ribeiro', 'Teste de API', 84998460000, 11998565656, current_timestamp(), 1);


--						TIPO MATERIAL

INSERT INTO tipo_material (nome, update_time, create_time) VALUES ('Plástico', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO tipo_material (nome, update_time, create_time) VALUES ('Metal', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO tipo_material (nome, update_time, create_time) VALUES ('Vidro', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO tipo_material (nome, update_time, create_time) VALUES ('Papel/Papelão', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO tipo_material (nome, update_time, create_time) VALUES ('Óleo', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- 							MATERIAL
-- 				Plástico
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Plástico tipo A', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Plástico fino (folha)', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('PEAD', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Tampinhas PP', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('PP', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('PEAD (Leitoso)', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('PVC Rígido', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('PLAST. (catemba)', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Grade', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Mineral', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('PP cadeiras', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Plástico duro (outros)', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('PET branca', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('PET incolor tipo C', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('PET verde tipo A', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('PET verde tipo B', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('PET azul tipo B', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- 				Metal
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Sucata de ferro', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Outros ferros', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Cobre com capa/sujo', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Cobre misto', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Cobre queimado', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Metal/Alumisto', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Bateria', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Motor de geladeira', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Reator', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Bloco', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Alumínio latinha', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Alumínio duro', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Alumínio panela', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Alumínio perfil', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Alumínio tubinho', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Inox', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Persiana', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Alumínios variados', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- 				Vidro
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Caco branco', 3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Caco branco', 3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Caco escuro', 3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Vidros diversos', 3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Vodka', 3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('L51', 3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Cerveja', 3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- 				Papel/Papelão
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Papelão', 4, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Papel branco', 4, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Jornal', 4, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Papel revista', 4, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Papel misto', 4, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- 				Óleo
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Óleo detergente/PS', 5, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Óleo sucata limpa', 5, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO material (nome, id_tipo_material, update_time, create_time) VALUES ('Óleo outros', 5, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

