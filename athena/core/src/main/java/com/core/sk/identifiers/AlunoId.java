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
public class AlunoId extends SimpleValueObject<UUID> implements Serializable {

    public static final AlunoId NAO_INFORMADO = new AlunoId();

    @Serial
    private static final long serialVersionUID = -5737382883196354898L;

    public static final String ATTR = "value";

    private final UUID value;

    protected AlunoId() {
        this.value = null;
    }

    private AlunoId(UUID value) {
        this.value = requireNonNull(value);
    }

    public static AlunoId generate() {
        return new AlunoId(UUID.randomUUID());
    }

    public static AlunoId from(UUID uuid) {
        return new AlunoId(uuid);
    }

    @Override
    public UUID getValue() {
        return value;
    }

}