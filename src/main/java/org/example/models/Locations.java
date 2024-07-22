package org.example.models;

public enum Locations {

    /**
     * Enum of locations available for jobRoles
     */
    BELFAST("Belfast"),
    LONDON("London"),
    TORONTO("Toronto"),
    BIRMINGHAM("Birmingham"),
    GDANSK("Gdansk");

    private final String location;

    Locations(String location) {
    this.location = location;
    }
    public String getLocation() {return this.location;};
}



