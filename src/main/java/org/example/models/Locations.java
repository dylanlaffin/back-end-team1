package org.example.models;

public enum Locations {

    /**
     * Enum of BELFAST supplies "Belfast".
     */
    BELFAST("Belfast"),
    /**
     * Enum of LONDON supplies "London".
     */
    LONDON("London"),
    /**
     * Enum of TORONTO supplies "Toronto".
     */
    TORONTO("Toronto"),
    /**
     * Enum of BIRMINGHAM supplies "Birmingham".
     */
    BIRMINGHAM("Birmingham"),
    /**
     * Enum of GDANSK supplies "Gdnask".
     */
    GDANSK("Gdansk");
    /*
    instantiates the location ENUM
     */
    private final String location;

    Locations(final String location) {
    this.location = location;
    }
    public String getLocation() {
        return this.location; }
}
