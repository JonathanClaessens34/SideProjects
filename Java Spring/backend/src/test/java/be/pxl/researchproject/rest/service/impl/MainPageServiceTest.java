package be.pxl.researchproject.rest.service.impl;

import be.pxl.researchproject.api.dto.MainPageDTO;
import be.pxl.researchproject.model.Reviewer;
import be.pxl.researchproject.model.StatusInternshipAssignment;
import be.pxl.researchproject.repository.InternshipAssignmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class MainPageServiceTest {

    @Test
    public void fillMainPageDTOListShouldReturnListWithMainPageDTOs() {
        InternshipAssignmentRepository internshipAssignmentRepository;
        Reviewer reviewer = new Reviewer();
        List<MainPageDTO> dtoList = new ArrayList<>();
        MainPageDTO mainpageDTO = new MainPageDTO(1, "testCompany", "stageopdracht", "AON", "semester 1", StatusInternshipAssignment.Nieuw);
        dtoList.add(mainpageDTO);

    }

}