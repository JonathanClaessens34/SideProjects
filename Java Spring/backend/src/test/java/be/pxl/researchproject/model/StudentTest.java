package be.pxl.researchproject.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StudentTest {
    private Student student;

    private String opleiding = "Informatica";
    private String afstudeerrichting = "AI";
    private String OLOD = "slksjd";
    private String naam = "John";
    private String voornaam = "Jake";
    private String straat = "Jef street 12";
    private String nummer = "51";
    private String bus = "1";
    private String postcode = "5680";
    private String gemeente = "Aarlen";
    private String priveEmail = "steve@gmail.com";
    private String ibamaflexMail = "steve4587@gmail.com";
    private String gsmNummer = "56456870";

    @BeforeEach
    public void init() {
        student = new Student(opleiding, afstudeerrichting, OLOD, naam, voornaam, straat, nummer, bus, postcode, gemeente, priveEmail, ibamaflexMail, gsmNummer);
    }

    @Test
    public void testSetters() {
        student.setOpleiding(opleiding);
        student.setAfstudeerrichting(afstudeerrichting);
        student.setOLOD(OLOD);
        student.setNaam(naam);
        student.setVoornaam(voornaam);
        student.setStraat(straat);
        student.setNummer(nummer);
        student.setBus(bus);
        student.setPostcode(postcode);
        student.setGemeente(gemeente);
        student.setPriveEmail(priveEmail);
        student.setIbamaflexMail(ibamaflexMail);
        student.setGsmNummer(gsmNummer);
        assertEquals(student.getOpleiding(), opleiding);
        assertEquals(student.getAfstudeerrichting(), afstudeerrichting);
        assertEquals(student.getOLOD(), OLOD);
        assertEquals(student.getNaam(), naam);
        assertEquals(student.getVoornaam(), voornaam);
        assertEquals(student.getStraat(), straat);
        assertEquals(student.getNummer(), nummer);
        assertEquals(student.getBus(), bus);
        assertEquals(student.getPostcode(), postcode);
        assertEquals(student.getGemeente(), gemeente);
        assertEquals(student.getPriveEmail(), priveEmail);
        assertEquals(student.getIbamaflexMail(), ibamaflexMail);
        assertEquals(student.getGsmNummer(), gsmNummer);
    }

    @Test
    public void testEqualsSameCompany() {
        Student contactPerson2 = student;
        assertTrue(student.equals(contactPerson2));
    }

    @Test
    public void testEqualsNullAndOtherClass() {
        String a = "";
        assertFalse(student.equals(null));
        assertFalse(student.equals(a));
    }

    @Test
    public void testEquals() {
        Student student2 = new Student(opleiding, afstudeerrichting, OLOD, naam, voornaam, straat, nummer, bus, postcode, gemeente, priveEmail, ibamaflexMail, gsmNummer);
        assertTrue(student.equals(student2));
        student2.setVoornaam("Daquan");
        assertFalse(student.equals(student2));
    }

    @Test
    public void testToString() {
        assertEquals(student.toString(), "Student{opleiding='Informatica', afstudeerrichting='AI', OLOD='slksjd', naam='John', voornaam='Jake', straat='Jef street 12', nummer='51', bus='1', postcode='5680', gemeente='Aarlen', priveEmail='steve@gmail.com', ibamaflexMail='steve4587@gmail.com', gsmNummer='56456870'}");
    }
}
