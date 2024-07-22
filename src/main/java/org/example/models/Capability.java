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

    Capability(String capability) {
        this.capability = capability;
    }
    public String getCapability() {
        return this.capability; };
}



