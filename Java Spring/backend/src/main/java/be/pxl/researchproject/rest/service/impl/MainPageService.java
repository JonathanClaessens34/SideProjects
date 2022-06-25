package be.pxl.researchproject.rest.service.impl;

import be.pxl.researchproject.api.dto.MainPageDTO;
import be.pxl.researchproject.model.InternshipAssignment;
import be.pxl.researchproject.repository.InternshipAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainPageService {

    private final InternshipAssignmentRepository internshipAssignmentRepository;

    @Autowired
    public MainPageService(InternshipAssignmentRepository internshipAssignmentRepository) {
        this.internshipAssignmentRepository = internshipAssignmentRepository;
        fillMainPageDTOList();
    }

    public List<MainPageDTO> fillMainPageDTOList() {
        List<MainPageDTO> mainPageDTOList = new ArrayList<>();
        List<InternshipAssignment> internshipAssignments = internshipAssignmentRepository.findAll().stream().toList();
        for (InternshipAssignment internshipAssignment : internshipAssignments) {
            mainPageDTOList.add(
                    new MainPageDTO(internshipAssignment.getId(),
                            internshipAssignment.getCompany().getName(),
                            internshipAssignment.getInternshipDescription().getTitleInternshipAssignment(),
                            internshipAssignment.getInternshipDescription().getPreferredSpecialization(),
                            internshipAssignment.getInternshipDescription().getInternshipPeriod(),
                            internshipAssignment.getStatus())
            );
        }
        return mainPageDTOList;
    }
}
