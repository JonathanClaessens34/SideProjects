package be.pxl.researchproject.builder;

import be.pxl.researchproject.model.Company;

public final class CompanyBuilder {
    private static Long ID = 10L;
    private static String POSTAL = "5450";
    private static String NAME = "Nike", STREET = "Dublinstreet 51", CITY = "Houston", LOCATIONINTERNSHIPSTREET = "Beveragestreet 54", LOCATIONINTERNSHIPCITY = "Houston";
    private static int NUMBEROFEMPLOYEES = 5, NUMBEROFEAEMPLOYEES = 2, NUMBEROFITEMPLOYEES = 3;
    private Long id = ID;
    private String postal = POSTAL;
    private String name = NAME, street = STREET, city = CITY, locationInternshipStreet = LOCATIONINTERNSHIPSTREET, locationInternshipCity = LOCATIONINTERNSHIPCITY;
    private int numberOfEmployees = NUMBEROFEMPLOYEES, numberOfEAEmployees = NUMBEROFEAEMPLOYEES, numberOfITEmployees = NUMBEROFITEMPLOYEES;

    private CompanyBuilder() {}

    public static CompanyBuilder aCompany() {return new CompanyBuilder();}

    public CompanyBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CompanyBuilder withPostal(String postal) {
        this.postal = postal;
        return this;
    }

    public CompanyBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CompanyBuilder withStreet(String street) {
        this.street = street;
        return this;
    }

    public CompanyBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public CompanyBuilder withIntershipCity(String locationInternshipCity) {
        this.locationInternshipCity = locationInternshipCity;
        return this;
    }

    public CompanyBuilder withLocationInternshipStreet(String locationInternshipStreet) {
        this.locationInternshipStreet = locationInternshipStreet;
        return this;
    }

    public CompanyBuilder withNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
        return this;
    }

    public CompanyBuilder withNumberOfEAEmployees(int numberOfEAEmployees) {
        this.numberOfEAEmployees = numberOfEAEmployees;
        return this;
    }

    public CompanyBuilder withNumberOfITEmployees(int numberOfITEmployees) {
        this.numberOfITEmployees = numberOfITEmployees;
        return this;
    }

    public Company build() {
        Company company = new Company();
        company.setId(id);
        company.setStreet(street);
        company.setPostal(postal);
        company.setName(name);
        company.setCity(city);
        company.setNumberOfEmployees(numberOfEmployees);
        company.setNumberOfITEmployees(numberOfITEmployees);
        company.setNumberOfEAEmployees(numberOfEAEmployees);
        company.setLocationInternshipCity(locationInternshipCity);
        company.setLocationInternshipStreet(locationInternshipStreet);
        return company;
    }
}
