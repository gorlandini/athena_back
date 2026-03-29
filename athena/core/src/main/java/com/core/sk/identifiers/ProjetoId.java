package com.core.sk.identifiers;


import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Embeddable;

import com.core.sk.context.SimpleValueObject;

import lombok.Getter;

@SuppressWarnings("squid:S2160")

@Getter
@Embeddable
public class ProjetoId extends SimpleValueObject<UUID> implements Serializable {

    public static final ProjetoId NAO_INFORMADO = new ProjetoId();

    @Serial
    private static final long serialVersionUID = -5737382883196354898L;

    public static final String ATTR = "value";

    private final UUID value;

    protected ProjetoId() {
        this.value = null;
    }

    private ProjetoId(UUID value) {
        this.value = requireNonNull(value);
    }

    public static ProjetoId generate() {
        return new ProjetoId(UUID.randomUUID());
    }

    public static ProjetoId from(UUID uuid) {
        return new ProjetoId(uuid);
    }

    @Override
    public UUID getValue() {
        return value;
    }

    @JsonCreator
    public ProjetoId(String value) {
        this.value = UUID.fromString(value);
    }


}