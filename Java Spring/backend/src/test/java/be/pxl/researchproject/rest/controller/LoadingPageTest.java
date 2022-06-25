package be.pxl.researchproject.rest.controller;

import be.pxl.researchproject.api.request.InternshipAssignmentRequest;
import be.pxl.researchproject.builder.InternshipAssignmenRequestBuilder;
import be.pxl.researchproject.rest.service.CompanyService;
import be.pxl.researchproject.rest.service.InternshipAssignmentService;
import be.pxl.researchproject.rest.service.controller.LoadingPageController;
import be.pxl.researchproject.rest.service.impl.MainPageService;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(controllers = LoadingPageController.class)
public class LoadingPageTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InternshipAssignmentService internshipAssignmentService;
    @MockBean
    private CompanyService companyService;
    @MockBean
    private MainPageService mainPageService;

    @Test
    public void badRequestWhenNoMissionName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/overview")
                        .content("{\"missionName\":\" \"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        //.andExpect(MockMvcResultMatchers.content().);
    }

    @Test
    @Ignore
    public void newMissionIsCreated() throws Exception {
        /*when(internshipAssignmentService.createInternshipAssignment(Mockito.any(InternshipAssignmentRequest.class)))
                .thenReturn(InternshipAssignmenRequestBuilder.anIntershipAssigmentRequest().build());

        mockMvc.perform(MockMvcRequestBuilders.post("/overview")
                        .content("{\"missionName\":\"My mission\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(MissionDTOBuilder.ID))
                .andExpect(MockMvcResultMatchers.jsonPath("$.missionName").value("My mission"));*/
    }
}
