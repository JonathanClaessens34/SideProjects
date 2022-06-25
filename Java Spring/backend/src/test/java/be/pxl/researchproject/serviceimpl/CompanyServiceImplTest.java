package be.pxl.researchproject.serviceimpl;

import be.pxl.researchproject.api.dto.CompanyDTO;
import be.pxl.researchproject.exception.ResourceNotFoundException;
import be.pxl.researchproject.repository.CompanyRepository;
import be.pxl.researchproject.rest.service.impl.CompanyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceImplTest {
    @Mock
    private CompanyRepository superheroRepository;

    @InjectMocks
    private CompanyServiceImpl superheroService;

    /*@Test
    public void returnsSuperheroDTO() {
        when(superheroRepository.findById(ID)).thenReturn(Optional.of(aSuperhero().build()));
        CompanyDTO company = superheroService.findSuperheroById(ID);
        assertNotNull(company);
        assertEquals(ID, superhero.getId());
        assertEquals(FIRSTNAME, superhero.getFirstName());
        assertEquals(LASTNAME, superhero.getLastName());
        assertEquals(SUPERHERO_NAME, superhero.getSuperheroName());
    }

    @Test
    public void throwsResourceNotFoundExceptionWhenNoSuperheroWithGivenId() {
        when(superheroRepository.findById(ID)).thenReturn(Optional.empty());
        ResourceNotFoundException resourceNotFoundException =
                Assertions.assertThrows(ResourceNotFoundException.class, () -> superheroService.findCompanyById(ID));
        assertEquals("Superhero not found with ID : '" + ID +"'", resourceNotFoundException.getMessage());
    }*/
}
