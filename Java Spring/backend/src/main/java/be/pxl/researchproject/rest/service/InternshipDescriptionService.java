package be.pxl.researchproject.rest.service;

import be.pxl.researchproject.api.dto.InternshipDescriptionDTO;
import be.pxl.researchproject.api.request.InternshipDescriptionRequest;

import java.util.List;

public interface InternshipDescriptionService {
    List<InternshipDescriptionDTO> findAllInternshipDescriptions();

    InternshipDescriptionDTO findInternshipDescriptionById(Long id);
    //StageomschrijvingDTO findStageomschrijvingByTitelStageopdracht(String titelStageopdracht);
    InternshipDescriptionDTO createInternshipDescription(InternshipDescriptionRequest internshipDescriptionRequest);
    InternshipDescriptionDTO updateInternshipDescription(Long id, InternshipDescriptionRequest internshipDescriptionRequest);
    boolean deleteInternshipDescription(Long id);

}
