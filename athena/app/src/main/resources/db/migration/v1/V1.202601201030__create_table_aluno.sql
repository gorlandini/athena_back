CREATE TABLE IF NOT EXISTS aluno (
   id UUID NOT NULL,
   nome VARCHAR(150) NOT NULL,
   matricula VARCHAR(50) NOT NULL,

   CONSTRAINT pk_aluno PRIMARY KEY (id),
   CONSTRAINT uk_aluno_matricula UNIQUE (matricula)
);