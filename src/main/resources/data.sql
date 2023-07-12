-- Inserindo dados para a tabela tb_papel
INSERT INTO tb_papel (descricao_papel, status_papel, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Descrição do Papel', TRUE, 'admin', '2023-07-01', 'admin', '2023-07-01');

-- Inserindo dados para a tabela tb_enderecos
INSERT INTO tb_enderecos (rua_endereco, numero_endereco, bairro_endereco, cidade_endereco, cep_endereco, estado_endereco, pais_endereco, complemento_endereco, status_endereco, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Rua Exemplo', 123, 'Bairro Exemplo', 'Cidade Exemplo', '12345-000', 'Estado Exemplo', 'País Exemplo', 'Complemento Exemplo', TRUE, 'admin', '2023-07-01', 'admin', '2023-07-01');

-- Inserindo dados para a tabela tb_pessoa
INSERT INTO tb_pessoa (nome_completo, data_de_nascimento, cpf, telefone, possui_deficiencia, id_endereco, status_pessoa, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Fulano de Tal', '1990-07-11', '12345678901', '1234567890', FALSE, 1, TRUE, 'admin', '2023-07-01', 'admin', '2023-07-01');

-- Inserindo dados para a tabela tb_area_atuacao
INSERT INTO tb_area_atuacao (descricao_area_atuacao, status_area_atuacao, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Descrição da Área de Atuação', TRUE, 'admin', '2023-07-09', 'admin', '2023-07-09');

-- Inserindo dados para a tabela tb_nucleos
INSERT INTO tb_nucleos (descricao_nucleo, id_endereco, status_nucleo, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Descrição do Núcleo', 1, TRUE, 'admin', '2023-07-09', 'admin', '2023-07-09');

INSERT INTO tb_nucleos (descricao_nucleo, id_endereco, status_nucleo, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Outra descrição do Núcleo', 1, TRUE, 'admin', '2023-07-10', 'admin', '2023-07-10');


-- Inserindo dados para a tabela tb_funcao
INSERT INTO tb_funcao (descricao_funcao, status_funcao, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Descrição da Função', TRUE, 'admin', '2023-07-09', 'admin', '2023-07-09');

-- Inserindo dados para a tabela tb_pessoa_funcao
INSERT INTO tb_pessoa_funcao (id_pessoa, matricula_pessoa_funcao, oab_pessoa_funcao, id_nucleo, id_area_atuacao, id_funcao, status_pessoa_funcao, criado_por, criado_data, modificado_por, modificado_data)
VALUES (1, 'Matricula 123', 'OAB 456', 1, 1, 1, TRUE, 'admin', '2023-07-09', 'admin', '2023-07-09');

-- Inserindo dados para a tabela tb_usuarios
INSERT INTO tb_usuarios (email_usuario, login_usuario, senha_usuario, id_papel, status_usuario, criado_por, criado_data, modificado_por, modificado_data, id_pessoa_funcao)
VALUES ('usuario1@example.com', 'usuario1', 'senha123', 1, TRUE, 'admin', '2023-07-01', 'admin', '2023-07-01', 1);

-- Inserindo dados para a tabela tb_subcategoria
INSERT INTO tb_subcategoria (descricao_subcategoria, status_categoria, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Descrição da Subcategoria', TRUE, 'admin', '2023-07-09', 'admin', '2023-07-09');

-- Inserindo dados para a tabela tb_categoria
INSERT INTO tb_categoria (descricao_categoria, id_subcategoria, status_categoria, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Descrição da Categoria', 1, TRUE, 'admin', '2023-07-09', 'admin', '2023-07-09');

-- Inserindo dados para a tabela tb_anexos
INSERT INTO tb_anexos (titulo_anexo, nome_anexo, pasta_anexo, id_categoria, status_anexo, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Título do Anexo', 'Nome do Anexo', 'Pasta do Anexo', 1, TRUE, 'admin', '2023-07-09', 'admin', '2023-07-09');

-- Inserindo outro dado na tabela tb_papel
INSERT INTO tb_papel (descricao_papel, status_papel, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Outra descrição do Papel', FALSE, 'admin', '2023-07-02', 'admin', '2023-07-02');

-- Inserindo outro dado na tabela tb_enderecos
INSERT INTO tb_enderecos (rua_endereco, numero_endereco, bairro_endereco, cidade_endereco, cep_endereco, estado_endereco, pais_endereco, complemento_endereco, status_endereco, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Rua Outro Exemplo', 456, 'Bairro Outro Exemplo', 'Cidade Outro Exemplo', '12345-111', 'Estado Outro Exemplo', 'País Outro Exemplo', 'Complemento Outro Exemplo', TRUE, 'admin', '2023-07-02', 'admin', '2023-07-02');

-- Inserindo outro dado na tabela tb_pessoa
INSERT INTO tb_pessoa (nome_completo, data_de_nascimento, cpf, telefone, possui_deficiencia, id_endereco, status_pessoa, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Ciclano de Tal', '1995-11-07', '98765432109', '9876543210', TRUE, 2, TRUE, 'admin', '2023-07-02', 'admin', '2023-07-02');

-- Inserindo outro dado na tabela tb_area_atuacao
INSERT INTO tb_area_atuacao (descricao_area_atuacao, status_area_atuacao, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Outra descrição da Área de Atuação', FALSE, 'admin', '2023-07-10', 'admin', '2023-07-10');

-- Inserindo outro dado na tabela tb_nucleos
INSERT INTO tb_nucleos (descricao_nucleo, id_endereco, status_nucleo, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Outra descrição do Núcleo', 2, FALSE, 'admin', '2023-07-10', 'admin', '2023-07-10');

-- Inserindo outro dado na tabela tb_funcao
INSERT INTO tb_funcao (descricao_funcao, status_funcao, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Outra descrição da Função', FALSE, 'admin', '2023-07-10', 'admin', '2023-07-10');

-- Inserindo outro dado na tabela tb_pessoa_funcao
INSERT INTO tb_pessoa_funcao (id_pessoa, matricula_pessoa_funcao, oab_pessoa_funcao, id_nucleo, id_area_atuacao, id_funcao, status_pessoa_funcao, criado_por, criado_data, modificado_por, modificado_data)
VALUES (2, 'Matricula 789', 'OAB 012', 2, 2, 2, FALSE, 'admin', '2023-07-10', 'admin', '2023-07-10');

-- Inserindo outro dado na tabela tb_usuarios
INSERT INTO tb_usuarios (email_usuario, login_usuario, senha_usuario, id_papel, status_usuario, criado_por, criado_data, modificado_por, modificado_data, id_pessoa_funcao)
VALUES ('usuario2@example.com', 'usuario2', 'senha456', 2, FALSE, 'admin', '2023-07-02', 'admin', '2023-07-02', 2);

-- Inserindo outro dado na tabela tb_subcategoria
INSERT INTO tb_subcategoria (descricao_subcategoria, status_categoria, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Outra descrição da Subcategoria', FALSE, 'admin', '2023-07-10', 'admin', '2023-07-10');

-- Inserindo outro dado na tabela tb_categoria
INSERT INTO tb_categoria (descricao_categoria, id_subcategoria, status_categoria, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Outra descrição da Categoria', 2, FALSE, 'admin', '2023-07-10', 'admin', '2023-07-10');

-- Inserindo outro dado na tabela tb_anexos
INSERT INTO tb_anexos (titulo_anexo, nome_anexo, pasta_anexo, id_categoria, status_anexo, criado_por, criado_data, modificado_por, modificado_data)
VALUES ('Outro Título do Anexo', 'Outro Nome do Anexo', 'Outra Pasta do Anexo', 2, FALSE, 'admin', '2023-07-10', 'admin', '2023-07-10');
