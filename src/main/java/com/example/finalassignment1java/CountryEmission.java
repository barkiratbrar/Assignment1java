package com.example.finalassignment1java;
import com.example.finalassignment1java.DatabaseConnector;


/**
 * Represents the emission details of a country.
 * This class stores the id, name, region, and total emissions of a country.
 */
public class CountryEmission {
    private final int id;
    private final String countryName;
    private final String region;
    private final double totalEmissions;

    /**
     * Constructor to initialize the CountryEmission object with its details.
     *
     * @param id The unique identifier for the country.
     * @param countryName The name of the country.
     * @param region The geographic region of the country.
     * @param totalEmissions The total carbon emissions of the country.
     */
    public CountryEmission(int id, String countryName, String region, double totalEmissions) {
        this.id = id;
        this.countryName = countryName;
        this.region = region;
        this.totalEmissions = totalEmissions;
    }

    // Getter methods to access the private fields of the class.
    public int getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getRegion() {
        return region;
    }

    public double getTotalEmissions() {
        return totalEmissions;
    }
}
