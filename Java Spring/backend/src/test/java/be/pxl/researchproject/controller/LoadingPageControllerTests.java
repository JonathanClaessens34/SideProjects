package be.pxl.researchproject.controller;

import be.pxl.researchproject.model.InternshipAssignmentTest;
import be.pxl.researchproject.util.AbstractTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoadingPageControllerTests extends AbstractTests {
    @Override
    @Before
    public void setUp(){
        super.setUp();
    }

    public void synchronise() throws Exception {
        String uri = "/overview/synchronise";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content("")).andReturn();
    }

    @Test
    public void synchroniseAssignments() throws Exception {
        /*String uri = "/overview/all";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        InternshipAssignment[] internshipAssignmentList = super.mapFromJson(content, InternshipAssignment[].class);
        assertTrue(internshipAssignmentList.length == 0);*/

        synchronise();

        String uri = "/overview/all";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        InternshipAssignmentTest[] internshipAssignmentList = super.mapFromJson(content, InternshipAssignmentTest[].class);
        assertTrue(internshipAssignmentList.length > 0);
    }

    @Test
    public void getInternshipAssignmentsContainsElementsAfterSynchronise() throws Exception {
        synchronise();

        String uri = "/overview/all";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        InternshipAssignmentTest[] internshipAssignmentList = super.mapFromJson(content, InternshipAssignmentTest[].class);
        assertTrue(internshipAssignmentList.length > 0);
    }

    @Test
    public void getAssignmentByIdAfterSynchronise() throws Exception {
        synchronise();

        String uri = "/overview/stageopdracht/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}
