package be.pxl.researchproject.api.request;

public class CompanyRequest {
    private long Id;
    private String name, street, city, locationInternshipStreet, locationInternshipCity, postal;
    private int numberOfEmployees, numberOfEAEmployees, numberOfITEmployees;

    public String getLocationInternshipStreet() {
        return locationInternshipStreet;
    }

    public void setLocationInternshipStreet(String locationInternshipStreet) {
        this.locationInternshipStreet = locationInternshipStreet;
    }

    public String getLocationInternshipCity() {
        return locationInternshipCity;
    }

    public void setLocationInternshipCity(String locationInternshipCity) {
        this.locationInternshipCity = locationInternshipCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEAEmployees() {
        return numberOfEAEmployees;
    }

    public void setNumberOfEAEmployees(int numberOfEAEmployees) {
        this.numberOfEAEmployees = numberOfEAEmployees;
    }

    public int getNumberOfITEmployees() {
        return numberOfITEmployees;
    }

    public void setNumberOfITEmployees(int numberOfITEmployees) {
        this.numberOfITEmployees = numberOfITEmployees;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }
}
