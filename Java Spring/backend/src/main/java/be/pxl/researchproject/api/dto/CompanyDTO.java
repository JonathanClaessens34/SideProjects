package be.pxl.researchproject.api.dto;

import be.pxl.researchproject.model.Company;

public class CompanyDTO {
    private final String name, street, city, locationInternshipStreet, locationInternshipCity, postal;
    private final int numberOfEmployees, numberOfEAEmployees, numberOfITEmployees;

    public CompanyDTO(Company save) {
        this.name = save.getName();
        this.street = save.getStreet();
        this.city = save.getCity();
        this.locationInternshipStreet = save.getLocationInternshipStreet();
        this.locationInternshipCity = save.getLocationInternshipCity();
        this.postal = save.getPostal();
        this.numberOfEmployees = save.getNumberOfEmployees();
        this.numberOfEAEmployees = save.getNumberOfEAEmployees();
        this.numberOfITEmployees = save.getNumberOfITEmployees();
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getLocationInternshipStreet() {
        return locationInternshipStreet;
    }

    public String getLocationInternshipCity() {
        return locationInternshipCity;
    }

    public String getPostal() {
        return postal;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public int getNumberOfEAEmployees() {
        return numberOfEAEmployees;
    }

    public int getNumberOfITEmployees() {
        return numberOfITEmployees;
    }
}
