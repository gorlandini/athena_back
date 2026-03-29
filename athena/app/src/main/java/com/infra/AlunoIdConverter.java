package com.infra;

import com.core.sk.identifiers.AlunoId;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.UUID;

@Converter(autoApply = true)
public class AlunoIdConverter implements AttributeConverter<AlunoId, UUID> {

    @Override
    public UUID convertToDatabaseColumn(AlunoId alunoId) {
        return alunoId != null ? alunoId.getValue() : null;
    }

    @Override
    public AlunoId convertToEntityAttribute(UUID uuid) {
        return uuid != null ? AlunoId.from(uuid) : null;
    }
}
