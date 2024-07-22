package org.example.models;

public enum Location {

    /**
     * Enum of locations available for jobRoles
     */
    BELFAST("Belfast"),
    LONDON("London"),
    TORONTO("Toronto"),
    BIRMINGHAM("Birmingham"),
    GDANSK("Gdansk");

    private final String location;

    Location(String location) {
    this.location = location;
    }
    public String getLocation() {return this.location;};
}



