package fr.esgi.aquarium.domain.enumeration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public enum SpaceType {

    CLIENT(1L, "client"),
    AGENCE(2L, "agence"),
    MIXTE(3L, "mixte");

    private final Long id;
    private final String name;

    SpaceType(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * @return the Enum representation for the given string.
     * @throws IllegalArgumentException if unknown string.
     */
    public static SpaceType fromName(String s) throws IllegalArgumentException {
        return Arrays.stream(SpaceType.values())
                .filter(v -> v.name.equals(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown value: " + s));
    }

}
