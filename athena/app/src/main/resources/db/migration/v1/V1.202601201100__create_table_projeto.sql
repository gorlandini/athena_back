CREATE TABLE IF NOT EXISTS projeto (

                                       id UUID NOT NULL,
                                       nomeProjeto VARCHAR(150) NOT NULL,
    nomeProfessor VARCHAR(150) NOT NULL,

    CONSTRAINT pk_projeto PRIMARY KEY (id)

    );