package com.core.domain.participacao_projeto;

import com.core.domain.projeto.model.Projeto;
import com.core.sk.identifiers.AlunoId;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "participacao_projeto")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParticipacaoProjeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔥 DONO da relação (ESSENCIAL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id", nullable = false)
    private Projeto projeto;

    // 🔥 Value Object corretamente mapeado
    @Embedded
    @AttributeOverride(
            name = "value",
            column = @Column(name = "aluno_id", nullable = false)
    )
    private AlunoId alunoId;

    // 🔥 construtor correto
    public ParticipacaoProjeto(AlunoId alunoId, Projeto projeto) {
        this.alunoId = alunoId;
        this.projeto = projeto;
    }
}