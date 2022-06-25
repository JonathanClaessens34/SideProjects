package be.pxl.researchproject.repository;

import be.pxl.researchproject.builder.CompanyBuilder;
import be.pxl.researchproject.model.Company;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class CompanyRepositoryTest {
    private static final Long ID = 1L;

    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    private CompanyRepository companyRepository;

    private Company company = CompanyBuilder.aCompany().build();

    @BeforeEach
    public void init() {
        companyRepository.deleteAll();
        companyRepository.save(company);
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    public void returnsSuperheroWithGivenSuperheroName() {
        var id = companyRepository.findAll().get((int) (companyRepository.count() - 1)).getId();
        Optional<Company> companyUnderTest = companyRepository.findBedrijfById(id);

        assertTrue(companyUnderTest.isPresent());
        assertEquals(id, companyUnderTest.get().getId());
    }

    @Test
    public void returnsEmptyOptionalWhenNoInstituteWithGivenName() {
        Optional<Company> companyUnderTest = companyRepository.findBedrijfById(15L);

        assertTrue(companyUnderTest.isEmpty());
    }
}
