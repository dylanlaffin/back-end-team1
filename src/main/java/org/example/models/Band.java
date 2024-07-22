package org.example.models;

public enum Band {

    /**
     * Enum of Bands available for jobRoles
     */
    BAND1("20,000-30,000"),
    BAND2("30,001-36,000"),
    BAND3("36,001-42,000"),
    BAND4("42,001-60,000");

    private final String band;

    Band(String band) {
    this.band = band;
    }
    public String getBand() {return this.band;};
}



