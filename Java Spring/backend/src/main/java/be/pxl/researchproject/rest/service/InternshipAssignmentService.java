package be.pxl.researchproject.rest.service;

import be.pxl.researchproject.api.dto.InternshipAssignmentDTO;
import be.pxl.researchproject.api.request.*;
import be.pxl.researchproject.model.*;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface InternshipAssignmentService {
    List<InternshipAssignmentDTO> findAllInternshipAssignments();
    InternshipAssignmentDTO findInternshipAssignmentById(Long id);
    //StageopdrachtDTO findStageopdachtByTitle(Long id);
    InternshipAssignmentDTO createInternshipAssignment(InternshipAssignmentRequest internshipAssignmentRequest);
    InternshipAssignmentDTO updateInternshipAssignment(Long id, InternshipAssignmentRequest internshipAssignmentRequest);
    boolean deleteInternshipAssignment(Long id);
    void deleteAllInternshipAssignment();
    Company findCompany(Company company);
    ContactPerson findContactPerson(ContactPerson contactPerson);
    InternshipDescription findInternshipDescription(InternshipDescription internshipDescription);
    Reviewer findReviewer(Reviewer reviewer);
    Supervisor findSupervisor(Supervisor supervisor);
    boolean findInternshipAssignment(InternshipAssignment internshipAssignment);
    InternshipAssignmentDTO updateInternshipAssignmentDetailPage(Long id, DetailPageRequest detailPageRequest);

    InternshipAssignmentDTO updateInternshipAssignmentCompany(Long internshipAssignmentId, CompanyRequest request);

    InternshipAssignmentDTO updateInternshipAssignmentContactPerson(Long internshipAssignmentId, ContactPersonRequest request);

    InternshipAssignmentDTO updateInternshipAssignmentSupervisor(Long internshipAssignmentId, SupervisorRequest request);
    InternshipAssignmentDTO changeStatus(Long internshipAssignmentId, String status);
}
