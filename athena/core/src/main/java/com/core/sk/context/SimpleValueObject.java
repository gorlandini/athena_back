package com.core.sk.context;

import java.io.Serializable;
import java.util.Objects;

public abstract class SimpleValueObject<T extends Serializable> {
    private transient int hash;

    public abstract T getValue();

    public final int hashCode() {
        if (this.hash == 0) {
            this.hash = Objects.hash(new Object[]{this.getValue()});
        }

        return this.hash;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass().equals(obj.getClass())) {
            SimpleValueObject<T> other = (SimpleValueObject)obj;
            if (this.getValue() instanceof String) {
                String currentValue = (String)this.getValue();
                String otherValue = (String)other.getValue();
                return currentValue.equalsIgnoreCase(otherValue);
            } else {
                return Objects.equals(this.getValue(), other.getValue());
            }
        } else {
            return false;
        }
    }

    public final String toString() {
        String var10000 = this.getClass().getSimpleName();
        return var10000 + " [value=" + String.valueOf(this.getValue()) + "]";
    }

    public String asString() {
        return this.getValue().toString();
    }
}
