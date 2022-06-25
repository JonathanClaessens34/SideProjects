package be.pxl.researchproject.controller;

import be.pxl.researchproject.Application;
import be.pxl.researchproject.rest.service.controller.DetailsPageController;
import be.pxl.researchproject.util.AbstractTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = Application.class)
public class DetailsPageControllerTest extends AbstractTests {

    @Autowired
    private DetailsPageController controller;


    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }




}













