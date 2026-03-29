package com.infra;

import com.core.sk.identifiers.ProjetoId;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.UUID;

@Converter(autoApply = true)
public class ProjetoIdConverter implements AttributeConverter<ProjetoId, UUID> {

    @Override
    public UUID convertToDatabaseColumn(ProjetoId projetoId) {
        return projetoId != null ? projetoId.getValue() : null;
    }

    @Override
    public ProjetoId convertToEntityAttribute(UUID uuid) {
        return uuid != null ? ProjetoId.from(uuid) : null;
    }
}
