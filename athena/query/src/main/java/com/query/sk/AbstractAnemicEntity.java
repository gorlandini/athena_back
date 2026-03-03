package com.query.sk;

import java.util.Objects;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;

@MappedSuperclass
public abstract class AbstractAnemicEntity<K> {

    @Transient
    private int hash = 0;

    public abstract K getId();

    @Override
    public int hashCode() {
        if (hash == 0)
            hash = Objects.hash(getId());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || !getClass().equals(obj.getClass()))
            return false;

        @SuppressWarnings("unchecked")
        AbstractAnemicEntity<K> other = (AbstractAnemicEntity<K>) obj;

        return Objects.equals(getId(), other.getId());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [id=" + getId() + "]";
    }

}
