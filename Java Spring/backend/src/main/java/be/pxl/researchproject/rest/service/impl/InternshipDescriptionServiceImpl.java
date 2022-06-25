package be.pxl.researchproject.rest.service.impl;

import be.pxl.researchproject.api.dto.InternshipDescriptionDTO;
import be.pxl.researchproject.api.request.InternshipDescriptionRequest;
import be.pxl.researchproject.model.InternshipDescription;
import be.pxl.researchproject.repository.InternshipDescriptionRepository;
import be.pxl.researchproject.rest.service.InternshipDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InternshipDescriptionServiceImpl implements InternshipDescriptionService {
    private final InternshipDescriptionRepository internshipDescriptionRepository;

    @Autowired
    public InternshipDescriptionServiceImpl(InternshipDescriptionRepository internshipDescriptionRepository) {
        this.internshipDescriptionRepository = internshipDescriptionRepository;
    }

    @Override
    public List<InternshipDescriptionDTO> findAllInternshipDescriptions() {
        return internshipDescriptionRepository.findAll()
                .stream()
                .map(InternshipDescriptionDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public InternshipDescriptionDTO findInternshipDescriptionById(Long id) {
        return internshipDescriptionRepository.findStageomschrijvingById(id)
                .map(InternshipDescriptionDTO::new)
                .orElseThrow(() -> new Error(id + " not found"));
    }

    @Override
    public InternshipDescriptionDTO createInternshipDescription(InternshipDescriptionRequest internshipDescriptionRequest) {
        InternshipDescription internshipDescription = new InternshipDescription();
        internshipDescription.setDescriptionAssignment(internshipDescriptionRequest.getDescriptionAssignment());
        internshipDescription.setResearchTheme(internshipDescriptionRequest.getResearchTheme());
        internshipDescription.setConditions(internshipDescriptionRequest.getConditions());
        internshipDescription.setPreferredSpecialization(internshipDescriptionRequest.getPreferredSpecialization());
        internshipDescription.setEnvironment(internshipDescriptionRequest.getEnvironment());
        internshipDescription.setIntroductoryActivities(internshipDescriptionRequest.getIntroductoryActivities());
        internshipDescription.setInternshipPeriod(internshipDescriptionRequest.getInternship());
        internshipDescription.setTitleInternshipAssignment(internshipDescriptionRequest.getTitleInternshipAssignment());
        internshipDescription.setComments(internshipDescriptionRequest.getComments());
        internshipDescription.setNumberOfDesiredInterns(internshipDescriptionRequest.getNumberOfDesiredInterns());
        InternshipDescription newInternshipDescription = internshipDescriptionRepository.save(internshipDescription);
        return new InternshipDescriptionDTO(newInternshipDescription);
    }

    @Override
    public InternshipDescriptionDTO updateInternshipDescription(Long id, InternshipDescriptionRequest internshipDescriptionRequest) {
        return internshipDescriptionRepository.findStageomschrijvingById(id)
                .map(stageomschrijving -> {
                    stageomschrijving.setDescriptionAssignment(internshipDescriptionRequest.getDescriptionAssignment());
                    stageomschrijving.setResearchTheme(internshipDescriptionRequest.getResearchTheme());
                    stageomschrijving.setConditions(internshipDescriptionRequest.getConditions());
                    stageomschrijving.setPreferredSpecialization(internshipDescriptionRequest.getPreferredSpecialization());
                    stageomschrijving.setEnvironment(internshipDescriptionRequest.getEnvironment());
                    stageomschrijving.setIntroductoryActivities(internshipDescriptionRequest.getIntroductoryActivities());
                    stageomschrijving.setInternshipPeriod(internshipDescriptionRequest.getInternship());
                    stageomschrijving.setTitleInternshipAssignment(internshipDescriptionRequest.getTitleInternshipAssignment());
                    stageomschrijving.setComments(internshipDescriptionRequest.getComments());
                    stageomschrijving.setNumberOfDesiredInterns(internshipDescriptionRequest.getNumberOfDesiredInterns());
                    return new InternshipDescriptionDTO(internshipDescriptionRepository.save(stageomschrijving));
                }).orElseThrow(() -> new Error(id + " unable to update."));
    }

    @Override
    public boolean deleteInternshipDescription(Long id) {
        return internshipDescriptionRepository.findStageomschrijvingById(id)
                .map(stageomschrijving -> {
                    internshipDescriptionRepository.delete(stageomschrijving);
                    return true;
                }).orElseThrow(() -> new Error(id + " unable to delete"));
    }
}
