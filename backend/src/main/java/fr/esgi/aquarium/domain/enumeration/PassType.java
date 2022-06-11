package fr.esgi.aquarium.domain.enumeration;

import java.util.Arrays;

public enum PassType {

    DAILY(1L, "daily", 10d),
    WEEKLY(2L, "weekly", 15d),
    MONTHLY(3L, "monthly", 30d),
    ANNUALLY(4L, "annually", 60d);

    private final Long id;
    private final String name;
    private final Double price;

    PassType(final Long id, final String name, final Double price) {
        this.id = id;
        this.name = name;
        this.price = price;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return name;
    }

    /**
     * @return the Enum representation for the given string.
     * @throws IllegalArgumentException if unknown string.
     */
    public static PassType fromName(String s) throws IllegalArgumentException {
        return Arrays.stream(PassType.values())
                .filter(v -> v.name.equals(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown value: " + s));
    }

}
