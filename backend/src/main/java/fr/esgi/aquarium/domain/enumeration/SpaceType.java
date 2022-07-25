package fr.esgi.aquarium.domain.enumeration;

import java.util.Arrays;

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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
