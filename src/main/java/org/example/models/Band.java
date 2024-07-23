package org.example.models;

public enum Band {

    /**
     * Enum of Band1 £20,000-£30,000 available for jobRoles.
     */
    BAND1("20,000-30,000"),
    /**
     * Enum of Band2 £30,001-£36,000 available for jobRoles.
     */
    BAND2("30,001-36,000"),
    /**
     * Enum of Band3 £36,001-£42,000 available for jobRoles.
     */
    BAND3("36,001-42,000"),
    /**
     * Enum of Band4 £42,001-£60,000 available for jobRoles.
     */
    BAND4("42,001-60,000");
    /*
    instantiates the band Enum
     */
    private final String band;

    Band(final String bandName) {
    this.band = bandName;
    }
    public String getBand() {
        return this.band; }
}



