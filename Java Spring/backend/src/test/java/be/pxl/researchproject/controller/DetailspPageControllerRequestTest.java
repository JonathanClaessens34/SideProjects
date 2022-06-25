package be.pxl.researchproject.controller;

import be.pxl.researchproject.builder.InternshipAssignmentBuilder;
import be.pxl.researchproject.rest.service.InternshipAssignmentService;
import be.pxl.researchproject.rest.service.controller.DetailsPageController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DetailsPageController.class)
public class DetailspPageControllerRequestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InternshipAssignmentService service;

    public void synchronise() throws Exception {
        String uri = "/overview/synchronise";
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content("")).andReturn();


    }
    @Test
    public void internshipAssignmentTitleIsRequired() throws Exception {

        synchronise();
        String URL = "/{2}";
        mockMvc.perform(MockMvcRequestBuilders.get(URL)
                        .content(asJsonString(InternshipAssignmentBuilder.aInternshipAssignment().withTitle("Title").build())))
                .andDo(print())
                .andExpect(status().isAccepted());

    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
