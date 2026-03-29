CREATE TABLE participacao_projeto (
                                      id BIGSERIAL PRIMARY KEY,
                                      projeto_id UUID NOT NULL,
                                      aluno_id UUID NOT NULL,

                                      CONSTRAINT fk_participacao_projeto
                                          FOREIGN KEY (projeto_id)
                                              REFERENCES projeto(id)
                                              ON DELETE CASCADE,

                                      CONSTRAINT fk_participacao_aluno
                                          FOREIGN KEY (aluno_id)
                                              REFERENCES aluno(id)
                                              ON DELETE CASCADE
);