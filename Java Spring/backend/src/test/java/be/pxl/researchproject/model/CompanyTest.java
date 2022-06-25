package be.pxl.researchproject.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyTest {
    private Company company;

    private final Long ID = 10l;
    private final String POSTAL= "8730";
    private final String NAME = "Facebook", STREET = "Saint street 54", CITY = "Chicago", LOCATIONINTERNSHIPSTREET = "Chicago", LOCATIONINTERNSHIPCITY = "Chicago";
    private final int NUMBEROFEMPLOYEES = 5, NUMBEROFEAEMPLOYEES = 3, NUMBEROFITEMPLOYEES = 5;

    @BeforeEach
    public void init() {
        company = new Company();
        company.setId(ID);
        company.setPostal(POSTAL);
        company.setName(NAME);
        company.setStreet(STREET);
        company.setCity(CITY);
        company.setLocationInternshipStreet(LOCATIONINTERNSHIPSTREET);
        company.setLocationInternshipCity(LOCATIONINTERNSHIPCITY);
        company.setNumberOfEmployees(NUMBEROFEMPLOYEES);
        company.setNumberOfEAEmployees(NUMBEROFEAEMPLOYEES);
        company.setNumberOfITEmployees(NUMBEROFITEMPLOYEES);
    }

    @Test
    public void testSetters() {
        assertEquals(company.getId(), ID);
        assertEquals(company.getPostal(), POSTAL);
        assertEquals(company.getName(), NAME);
        assertEquals(company.getStreet(), STREET);
        assertEquals(company.getCity(), CITY);
        assertEquals(company.getLocationInternshipStreet(), LOCATIONINTERNSHIPSTREET);
        assertEquals(company.getLocationInternshipCity(), LOCATIONINTERNSHIPCITY);
        assertEquals(company.getNumberOfEmployees(), NUMBEROFEMPLOYEES);
        assertEquals(company.getNumberOfEAEmployees(), NUMBEROFEAEMPLOYEES);
        assertEquals(company.getNumberOfITEmployees(), NUMBEROFITEMPLOYEES);
    }

    @Test
    public void testEqualsSameCompany() {
        Company company2 = company;
        assertTrue(company.equals(company2));
    }

    @Test
    public void testEqualsNullAndOtherClass() {
        String a = "";
        assertFalse(company.equals(null));
        assertFalse(company.equals(a));
    }

    @Test
    public void testEquals() {
        Company company2 = new Company();
        company2.setId(ID);
        company2.setPostal(POSTAL);
        company2.setName(NAME);
        company2.setStreet(STREET);
        company2.setCity(CITY);
        company2.setLocationInternshipStreet(LOCATIONINTERNSHIPSTREET);
        company2.setLocationInternshipCity(LOCATIONINTERNSHIPCITY);
        company2.setNumberOfEmployees(NUMBEROFEMPLOYEES);
        company2.setNumberOfEAEmployees(NUMBEROFEAEMPLOYEES);
        company2.setNumberOfITEmployees(NUMBEROFITEMPLOYEES);
        assertTrue(company.equals(company2));
        company2.setStreet("Jeffersonstreet 29");
        assertFalse(company.equals(company2));
    }
}
