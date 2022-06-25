package be.pxl.researchproject.dto;

import be.pxl.researchproject.api.dto.CompanyDTO;
import be.pxl.researchproject.builder.CompanyBuilder;
import be.pxl.researchproject.model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyDTOTest {
    private CompanyDTO companyDTO;

    @BeforeEach
    public void init() {
        Company company = CompanyBuilder.aCompany().build();
        companyDTO = new CompanyDTO(company);
    }

    @Test
    public void testGetters() {
        assertEquals(companyDTO.getCity(), "Houston");
        assertEquals(companyDTO.getNumberOfEAEmployees(), 2);
        assertEquals(companyDTO.getName(), "Nike");
        assertEquals(companyDTO.getLocationInternshipCity(), "Houston");
        assertEquals(companyDTO.getPostal(), "5450");
        assertEquals(companyDTO.getStreet(), "Dublinstreet 51");
        assertEquals(companyDTO.getLocationInternshipStreet(), "Beveragestreet 54");
        assertEquals(companyDTO.getNumberOfEmployees(), 5);
        assertEquals(companyDTO.getNumberOfITEmployees(), 3);
    }
}
