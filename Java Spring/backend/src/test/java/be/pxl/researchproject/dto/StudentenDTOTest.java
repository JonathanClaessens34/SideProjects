package be.pxl.researchproject.dto;

import be.pxl.researchproject.api.dto.StudentenDTO;
import be.pxl.researchproject.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentenDTOTest {
    private List<Student> studentList;
    private StudentenDTO studentenDTO;

    @BeforeEach
    public void init() {
        studentList = new ArrayList<Student>();

        String opleiding = "Informatica";
        String afstudeerrichting = "AI";
        String OLOD = "slksjd";
        String naam = "John";
        String voornaam = "Jake";
        String straat = "Jef street 12";
        String nummer = "51";
        String bus = "1";
        String postcode = "5680";
        String gemeente = "Aarlen";
        String priveEmail = "steve@gmail.com";
        String ibamaflexMail = "steve4587@gmail.com";
        String gsmNummer = "56456870";

        studentList.add(new Student(opleiding, afstudeerrichting, OLOD, naam, voornaam, straat, nummer, bus, postcode, gemeente, priveEmail, ibamaflexMail, gsmNummer));
        voornaam = "Paul";
        studentList.add(new Student(opleiding, afstudeerrichting, OLOD, naam, voornaam, straat, nummer, bus, postcode, gemeente, priveEmail, ibamaflexMail, gsmNummer));
        naam = "Montana";
        studentList.add(new Student(opleiding, afstudeerrichting, OLOD, naam, voornaam, straat, nummer, bus, postcode, gemeente, priveEmail, ibamaflexMail, gsmNummer));
        this.studentenDTO = new StudentenDTO(studentList);
    }

    @Test
    public void testGetStudentList() {
        assertEquals(studentenDTO.getStudentList(), studentList);
    }

    @Test
    public void testSetStudentList() {
        studentList.remove(1);
        studentenDTO.setStudentList(studentList);
        assertEquals(studentenDTO.getStudentList(), studentList);
    }
}
