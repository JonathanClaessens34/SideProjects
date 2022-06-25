package be.pxl.researchproject.model;

import javax.persistence.*;
import java.util.Objects;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="bedrijf")
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(length = 1000)
    private String postal;
    private String name, street, city, locationInternshipStreet, locationInternshipCity;
    @Column(nullable = true)
    private int numberOfEmployees, numberOfEAEmployees, numberOfITEmployees;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String straat) {
        this.street = straat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String gemeente) {
        this.city = gemeente;
    }

    public String getLocationInternshipStreet() {
        return locationInternshipStreet;
    }

    public void setLocationInternshipStreet(String locatieStageStraat) {
        this.locationInternshipStreet = locatieStageStraat;
    }

    public String getLocationInternshipCity() {
        return locationInternshipCity;
    }

    public void setLocationInternshipCity(String locatieStageGemeente) {
        this.locationInternshipCity = locatieStageGemeente;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postcode) {
        this.postal = postcode;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int aantalMedewerkers) {
        this.numberOfEmployees = aantalMedewerkers;
    }

    public int getNumberOfEAEmployees() {
        return numberOfEAEmployees;
    }

    public void setNumberOfEAEmployees(int aantalEAMdewerkers) {
        this.numberOfEAEmployees = aantalEAMdewerkers;
    }

    public int getNumberOfITEmployees() {
        return numberOfITEmployees;
    }

    public void setNumberOfITEmployees(int aantalITMedewerkers) {
        this.numberOfITEmployees = aantalITMedewerkers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return numberOfEmployees == company.numberOfEmployees && numberOfEAEmployees == company.numberOfEAEmployees && numberOfITEmployees == company.numberOfITEmployees && Objects.equals(postal, company.postal) && Objects.equals(name, company.name) && Objects.equals(street, company.street) && Objects.equals(city, company.city) && Objects.equals(locationInternshipStreet, company.locationInternshipStreet) && Objects.equals(locationInternshipCity, company.locationInternshipCity);
    }
}
