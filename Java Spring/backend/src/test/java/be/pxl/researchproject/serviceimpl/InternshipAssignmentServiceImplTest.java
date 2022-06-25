package be.pxl.researchproject.serviceimpl;

import be.pxl.researchproject.api.dto.InternshipAssignmentDTO;
import be.pxl.researchproject.builder.InternshipAssignmentBuilder;
import be.pxl.researchproject.model.*;
import be.pxl.researchproject.repository.InternshipAssignmentRepository;
import be.pxl.researchproject.rest.service.impl.InternshipAssignmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InternshipAssignmentServiceImplTest {
    private static final String TITLE = "Test";
    private static final Company COMPANY = new Company();
    private static final ContactPerson CONTACTPERSON = new ContactPerson();
    private static final Supervisor SUPERVISOR = new Supervisor();
    private static final StatusInternshipAssignment STATUS = StatusInternshipAssignment.Nieuw;
    private static final String TIMESTAMP = "10 april";
    private static final Reviewer REVIEWER = new Reviewer();
    private static final InternshipDescription DESCRIPTION = new InternshipDescription();

    @Mock
    private InternshipAssignmentRepository internshipAssignmentRepository;

    @Captor
    private ArgumentCaptor<InternshipAssignment> internshipAssignmentArgumentCaptor;

    @InjectMocks
    private InternshipAssignmentServiceImpl internshipAssignmentService;

    private final InternshipAssignment internshipAssignment = InternshipAssignmentBuilder.aInternshipAssignment()
            .withTitle(TITLE)
            .withCompany(COMPANY)
            .withContactPerson(CONTACTPERSON)
            .withSupervisor(SUPERVISOR)
            .withStatus(STATUS)
            .withTimestamp(TIMESTAMP)
            .withReviewer(REVIEWER)
            .withDescription(DESCRIPTION)
            .build();


//    @Test
//    public void findInternshipAssignmentByIdThrowResourceNotFoundExceptionWhenInternshipAssignmentDoesNotExist() {
////        when(internshipAssignmentRepository.findStageopdrachtById(0L)).thenReturn(Optional.of());
//        InternshipAssignmentRequest request = new InternshipAssignmentRequest(TITLE, COMPANY, CONTACTPERSON, SUPERVISOR,
//                STATUS, TIMESTAMP, REVIEWER, DESCRIPTION);
//        ResourceNotFoundException resourceNotFoundException = assertThrows(ResourceNotFoundException.class, () ->
//               internshipAssignmentService.createInternshipAssignment(request));
////        assertEquals("InternshipAssignment ID 0", resourceNotFoundException.getMessage());
//
////        final long nonExistingId = 12902450235L;
////
////        doThrow(new ResourceNotFoundException("InternshipAssignment", "ID", nonExistingId)).when(internshipAssignmentService).findInternshipAssignmentById(nonExistingId);
//
//
//
//        String expectedMessage = "For input string";
//        String actualMessage = resourceNotFoundException.getMessage();
//
//        assertTrue(actualMessage.contains(expectedMessage));
//
//    }




    @Test
    public void findAllInternshipsAssignments() {
        InternshipAssignment internshipAssignment1 = InternshipAssignmentBuilder.aInternshipAssignment().withTitle("LOL").build();
        InternshipAssignment internshipAssignment2 = InternshipAssignmentBuilder.aInternshipAssignment().withTitle("LOL2").build();
        when(internshipAssignmentRepository.findAll()).thenReturn(Arrays.asList(internshipAssignment1, internshipAssignment2));
        List<InternshipAssignmentDTO> allInternships = internshipAssignmentService.findAllInternshipAssignments();
        assertThat(allInternships.stream()
                .map(InternshipAssignmentDTO::getTitle)
                .collect(Collectors.toList()))
                .hasSize(2)
                .containsExactly("LOL", "LOL2");
    }




}
