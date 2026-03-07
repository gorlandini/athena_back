package com.core.sk.identifiers;


import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Embeddable;

import com.core.sk.context.SimpleValueObject;

import lombok.Getter;

@SuppressWarnings("squid:S2160")

@Getter
@Embeddable
public class CategoriaId extends SimpleValueObject<UUID> implements Serializable {

    public static final CategoriaId NAO_INFORMADO = new CategoriaId();

    @Serial
    private static final long serialVersionUID = -5737382883196354898L;

    public static final String ATTR = "value";

    private final UUID value;

    protected CategoriaId() {
        this.value = null;
    }

    private CategoriaId(UUID value) {
        this.value = requireNonNull(value);
    }

    public static CategoriaId generate() {
        return new CategoriaId(UUID.randomUUID());
    }

    public static CategoriaId from(UUID uuid) {
        return new CategoriaId(uuid);
    }

    @Override
    public UUID getValue() {
        return value;
    }

}