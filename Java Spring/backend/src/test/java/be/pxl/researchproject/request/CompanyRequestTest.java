package be.pxl.researchproject.request;

import be.pxl.researchproject.api.request.CompanyRequest;
import be.pxl.researchproject.builder.CompanyBuilder;
import be.pxl.researchproject.model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyRequestTest {
    private CompanyRequest companyRequest;
    private Company company;

    @BeforeEach
    public void init() {
        company = CompanyBuilder.aCompany().build();
        companyRequest = new CompanyRequest();
        companyRequest.setStreet(company.getStreet());
        companyRequest.setNumberOfITEmployees(company.getNumberOfITEmployees());
        companyRequest.setCity(company.getCity());
        companyRequest.setNumberOfEAEmployees(company.getNumberOfEAEmployees());
        companyRequest.setNumberOfEmployees(company.getNumberOfEmployees());
        companyRequest.setName(company.getName());
        companyRequest.setPostal(company.getPostal());
        companyRequest.setLocationInternshipCity(company.getLocationInternshipCity());
        companyRequest.setLocationInternshipStreet(company.getLocationInternshipStreet());
    }

    @Test
    public void testGetters() {
        assertEquals(companyRequest.getCity(), company.getCity());
        assertEquals(companyRequest.getNumberOfEAEmployees(), company.getNumberOfEAEmployees());
        assertEquals(companyRequest.getName(), company.getName());
        assertEquals(companyRequest.getLocationInternshipCity(), company.getLocationInternshipCity());
        assertEquals(companyRequest.getPostal(), company.getPostal());
        assertEquals(companyRequest.getStreet(), company.getStreet());
        assertEquals(companyRequest.getLocationInternshipStreet(), company.getLocationInternshipStreet());
        assertEquals(companyRequest.getNumberOfEmployees(), company.getNumberOfEmployees());
        assertEquals(companyRequest.getNumberOfITEmployees(), company.getNumberOfITEmployees());
    }
}
