
-- V1__create_cursos_table.sql

CREATE TABLE cursos (
    id SERIAL PRIMARY KEY,
    curso VARCHAR(255) NOT NULL
);

INSERT INTO cursos (curso) VALUES
    ('Administração'),
    ('Agronomia'),
    ('Arquitetura e Urbanismo'),
    ('Ciências Biológicas'),
    ('Biomedicina'),
    ('Ciências Contábeis'),
    ('Direito'),
    ('Engenharia Civil'),
    ('Engenharia de Produção'),
    ('Engenharia de Software'),
    ('Enfermagem'),
    ('Farmácia'),
    ('Fisioterapia'),
    ('Geografia'),
    ('Gestão Financeira'),
    ('História'),
    ('Marketing'),
    ('Nutrição'),
    ('Odontologia'),
    ('Pedagogia'),
    ('Processos Gerenciais'),
    ('Psicologia'),
    ('Recursos Humanos'),
    ('Sistemas de Informação'),
    ('Terapia Ocupacional');
