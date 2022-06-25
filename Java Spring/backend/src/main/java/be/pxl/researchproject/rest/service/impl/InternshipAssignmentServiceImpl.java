package be.pxl.researchproject.rest.service.impl;

import be.pxl.researchproject.api.dto.InternshipAssignmentDTO;
import be.pxl.researchproject.api.request.*;
import be.pxl.researchproject.exception.ResourceNotFoundException;
import be.pxl.researchproject.model.*;
import be.pxl.researchproject.repository.InternshipAssignmentRepository;
import be.pxl.researchproject.rest.service.InternshipAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InternshipAssignmentServiceImpl implements InternshipAssignmentService {

    private final InternshipAssignmentRepository internshipAssignmentRepository;

    @Autowired
    public InternshipAssignmentServiceImpl(InternshipAssignmentRepository internshipAssignmentRepository) {
        this.internshipAssignmentRepository = internshipAssignmentRepository;
    }

    @Override
    public List<InternshipAssignmentDTO> findAllInternshipAssignments() {
        return internshipAssignmentRepository.findAll()
                .stream().map(InternshipAssignmentDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public InternshipAssignmentDTO findInternshipAssignmentById(Long id) {
        return internshipAssignmentRepository.findStageopdrachtById(id).map(InternshipAssignmentDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("InternshipAssignment", "ID", id));
    }

    /*@Override
    public StageopdrachtDTO findStageopdachtByTitle(String title) {
        return stageopdrachtRepository.findStageopdrachtByTitle(title)
                .map(StageopdrachtDTO::new)
                .orElseThrow(() -> new Error(title + " not found"));
    }*/

    @Override
    public InternshipAssignmentDTO createInternshipAssignment(InternshipAssignmentRequest internshipAssignmentRequest) {
        InternshipAssignment internshipAssignment = new InternshipAssignment();
        internshipAssignment.setTitle(internshipAssignmentRequest.getTitle());
        internshipAssignment.setCompany(internshipAssignmentRequest.getCompany());
        internshipAssignment.setContactPerson(internshipAssignmentRequest.getContactPerson());
        internshipAssignment.setSupervisor(internshipAssignmentRequest.getSupervisor());
        internshipAssignment.setStatus(internshipAssignmentRequest.getStatus());
        internshipAssignment.setTimestamp(internshipAssignmentRequest.getTimestamp());
        internshipAssignment.setReviewer(internshipAssignmentRequest.getReviewer());
        internshipAssignment.setInternshipDescription(internshipAssignmentRequest.getInternshipDescription());
        InternshipAssignment newInternshipAssignment = internshipAssignmentRepository.save(internshipAssignment);
        return new InternshipAssignmentDTO(newInternshipAssignment);
    }


    @Override
    public InternshipAssignmentDTO updateInternshipAssignment(Long id, InternshipAssignmentRequest internshipAssignmentRequest) {
        return internshipAssignmentRepository.findStageopdrachtById(id)
                .map(internshipAssignment -> {
                    internshipAssignment.setCompany(internshipAssignmentRequest.getCompany());
                    internshipAssignment.setContactPerson(internshipAssignmentRequest.getContactPerson());
                    internshipAssignment.setSupervisor(internshipAssignmentRequest.getSupervisor());
                    return findInternshipAssignmentById(id);
                }).orElseThrow(() -> new Error(id + " unable to update"));
    }

    public InternshipAssignmentDTO updateInternshipAssignmentDetailPage(Long id, DetailPageRequest detailPageRequest) {
        return internshipAssignmentRepository.findStageopdrachtById(id)
                .map(internshipAssignment -> {
                    internshipAssignment.setCompany(detailPageRequest.getCompany());
                    internshipAssignment.setContactPerson(detailPageRequest.getContactPerson());
                    internshipAssignment.setSupervisor(detailPageRequest.getSupervisor());
                    internshipAssignmentRepository.save(internshipAssignment);
                    return findInternshipAssignmentById(id);
                }).orElseThrow(() -> new Error(id + " unable to update"));
    }

    @Override
    public InternshipAssignmentDTO updateInternshipAssignmentCompany(Long internshipAssignmentId, CompanyRequest request) {
        return internshipAssignmentRepository.findStageopdrachtById(internshipAssignmentId)
                .map(internshipAssignment -> {
                    Company company = new Company();
                    company.setName(request.getName());
                    company.setStreet(request.getStreet());
                    company.setCity(request.getCity());
                    company.setLocationInternshipCity(request.getLocationInternshipCity());
                    company.setLocationInternshipStreet(request.getLocationInternshipStreet());
                    company.setPostal(request.getPostal());
                    company.setNumberOfEAEmployees(request.getNumberOfEAEmployees());
                    company.setNumberOfEmployees(request.getNumberOfEmployees());
                    company.setNumberOfITEmployees(request.getNumberOfITEmployees());
                    company.setId(request.getId());
                    internshipAssignment.setCompany(company);
                    internshipAssignmentRepository.save(internshipAssignment);
                    return findInternshipAssignmentById(internshipAssignmentId);
                }).orElseThrow(() -> new Error(internshipAssignmentId + " unable to update"));
    }

    @Override
    public InternshipAssignmentDTO updateInternshipAssignmentContactPerson(Long internshipAssignmentId, ContactPersonRequest request) {
        return internshipAssignmentRepository.findStageopdrachtById(internshipAssignmentId)
                .map(internshipAssignment -> {
                    ContactPerson contactPerson = new ContactPerson();
                    contactPerson.setTitle(request.getTitle());
                    contactPerson.setFirstName(request.getFirstName());
                    contactPerson.setName(request.getName());
                    contactPerson.setEmail(request.getEmail());
                    contactPerson.setPhoneNumber(request.getPhoneNumber());
                    contactPerson.setId(request.getId());
                    internshipAssignment.setContactPerson(contactPerson);
                    internshipAssignmentRepository.save(internshipAssignment);
                    return findInternshipAssignmentById(internshipAssignmentId);
                }).orElseThrow(() -> new Error(internshipAssignmentId + " unable to update"));
    }

    @Override
    public InternshipAssignmentDTO updateInternshipAssignmentSupervisor(Long internshipAssignmentId, SupervisorRequest request) {
        return internshipAssignmentRepository.findStageopdrachtById(internshipAssignmentId)
                .map(internshipAssignment -> {
                    Supervisor supervisor = new Supervisor();
                    supervisor.setTitle(request.getTitle());
                    supervisor.setFirstName(request.getFirstName());
                    supervisor.setName(request.getName());
                    supervisor.setEmail(request.getEmail());
                    supervisor.setPhoneNumber(request.getPhoneNumber());
                    supervisor.setId(request.getId());
                    internshipAssignment.setSupervisor(supervisor);
                    internshipAssignmentRepository.save(internshipAssignment);
                    return findInternshipAssignmentById(internshipAssignmentId);
                }).orElseThrow(() -> new Error(internshipAssignmentId + "unable to update"));
    }
    public InternshipAssignmentDTO changeStatus(Long internshipAssignmentId, String status) {
        InternshipAssignment internshipAssignment = internshipAssignmentRepository.getById(internshipAssignmentId);
        StatusInternshipAssignment statusInternshipAssignment = StatusInternshipAssignment.valueOf(status);
        internshipAssignment.setStatus(statusInternshipAssignment);
        InternshipAssignment updatedInternship = internshipAssignmentRepository.save(internshipAssignment);

        InternshipAssignmentDTO internshipAssignmentDTO = new InternshipAssignmentDTO(updatedInternship);
        return internshipAssignmentDTO;
    }


    @Override
    public boolean deleteInternshipAssignment(Long id) {
        return internshipAssignmentRepository.findStageopdrachtById(id)
                .map(internshipAssignment -> {
                    internshipAssignmentRepository.delete(internshipAssignment);
                    return true;
                }).orElseThrow(() -> new Error(id + " unable to delete"));
    }

    @Override
    public void deleteAllInternshipAssignment() {
        internshipAssignmentRepository.deleteAll();
    }

    @Override
    public Company findCompany(Company company) {
        var result = internshipAssignmentRepository.findAll()
                .stream().map(InternshipAssignment::getCompany)
                .filter(x -> x.equals(company))
                .findFirst();
        return result.orElse(null);
    }

    @Override
    public ContactPerson findContactPerson(ContactPerson contactPerson) {
        var result = internshipAssignmentRepository.findAll()
                .stream().map(InternshipAssignment::getContactPerson)
                .filter(x -> x.equals(contactPerson))
                .findFirst();
        return result.orElse(null);
    }

    @Override
    public InternshipDescription findInternshipDescription(InternshipDescription internshipDescription) {
        var result = internshipAssignmentRepository.findAll()
                .stream().map(InternshipAssignment::getInternshipDescription)
                .filter(x -> x.equals(internshipDescription))
                .findFirst();
        return result.orElse(null);
    }

    @Override
    public Reviewer findReviewer(Reviewer reviewer) {
        var result = internshipAssignmentRepository.findAll()
                .stream().map(InternshipAssignment::getReviewer)
                .filter(x -> x.equals(reviewer))
                .findFirst();
        return result.orElse(null);
    }

    @Override
    public Supervisor findSupervisor(Supervisor supervisor) {
        var result = internshipAssignmentRepository.findAll()
                .stream().map(InternshipAssignment::getSupervisor)
                .filter(x -> x.equals(supervisor))
                .findFirst();
        return result.orElse(null);
    }

    @Override
    public boolean findInternshipAssignment(InternshipAssignment internshipAssignment) {
        var result = internshipAssignmentRepository.findAll()
                .stream()
                .filter(x -> x.equals(internshipAssignment))
                .findFirst();
        return result.isPresent();
    }
}
