package org.example.models;

public enum Capability {

    /**
     * Enum of capabilities available for jobRoles.
     */
    HR("HR"),
    /**
     * enum for the DELIVERY capability as "DeliVery".
     */
    DELIVERY("Delivery"),
    /**
     * enum for the MARKETING capability as "Marketing".
     */
    MARKETING("Marketing"),
    /**
     * enum for the SALES capability as "Sales".
     */
    SALES("Sales");

    private final String capability;

    Capability(final String capabilityName) {
        this.capability = capabilityName;
    }
    /*
    the getCapability returns the Capability enum string
     */
    public String getCapability() {
        return this.capability; };
}



