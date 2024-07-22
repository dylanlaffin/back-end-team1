package org.example.models;

public enum Capability {

    /**
     * Enum of capabilities available for jobRoles
     */
    HR("HR"),
    DELIVERY("Delivery"),
    MARKETING("Marketing"),
    SALES("Sales");

    private final String capability;

    Capability(String capability) {
    this.capability = capability;
    }
    public String getCapability() {return this.capability;};
}



