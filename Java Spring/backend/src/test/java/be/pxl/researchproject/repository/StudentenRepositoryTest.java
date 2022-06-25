package be.pxl.researchproject.repository;

import be.pxl.researchproject.model.Company;
import be.pxl.researchproject.model.Student;
import be.pxl.researchproject.model.Supervisor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
public class StudentenRepositoryTest {
    private static final Long ID = 1L;

    @PersistenceContext
    protected EntityManager entityManager;

    //@Autowired
    private StudentenRepository studentenRepository;
    private List<Student> students;

    //private Company company = CompanyBuilder.aCompany().build();

    @BeforeEach
    public void init() {
        studentenRepository = new StudentenRepository();
        students = new ArrayList<Student>();

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

        studentenRepository.addStudent(new Student(opleiding, afstudeerrichting, OLOD, naam, voornaam, straat, nummer, bus, postcode, gemeente, priveEmail, ibamaflexMail, gsmNummer));
        students.add(new Student(opleiding, afstudeerrichting, OLOD, naam, voornaam, straat, nummer, bus, postcode, gemeente, priveEmail, ibamaflexMail, gsmNummer));
        naam = "Jack";
        studentenRepository.addStudent(new Student(opleiding, afstudeerrichting, OLOD, naam, voornaam, straat, nummer, bus, postcode, gemeente, priveEmail, ibamaflexMail, gsmNummer));
        students.add(new Student(opleiding, afstudeerrichting, OLOD, naam, voornaam, straat, nummer, bus, postcode, gemeente, priveEmail, ibamaflexMail, gsmNummer));
        naam = "Howard";
        studentenRepository.addStudent(new Student(opleiding, afstudeerrichting, OLOD, naam, voornaam, straat, nummer, bus, postcode, gemeente, priveEmail, ibamaflexMail, gsmNummer));
        students.add(new Student(opleiding, afstudeerrichting, OLOD, naam, voornaam, straat, nummer, bus, postcode, gemeente, priveEmail, ibamaflexMail, gsmNummer));
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    public void testGetStudentList() {
        assertEquals(students, studentenRepository.getStudentList());
    }

    @Test
    public void testSetStudentList() {
        studentenRepository.setStudentList(students);
        assertEquals(students, studentenRepository.getStudentList());
    }

    @Test
    public void testEqualsSameCompany() {
        StudentenRepository studentenRepository = this.studentenRepository;
        assertTrue(this.studentenRepository.equals(studentenRepository));
    }

    @Test
    public void testEqualsNullAndOtherClass() {
        String a = "";
        assertFalse(studentenRepository.equals(null));
        assertFalse(studentenRepository.equals(a));
    }

    @Test
    public void testEquals() {
        StudentenRepository studentenRepository = new StudentenRepository();
        studentenRepository.setStudentList(students);
        assertTrue(this.studentenRepository.equals(studentenRepository));
    }
}
