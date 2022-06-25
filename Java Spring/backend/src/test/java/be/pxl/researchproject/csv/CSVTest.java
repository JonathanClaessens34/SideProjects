package be.pxl.researchproject.csv;

import be.pxl.researchproject.model.Student;
import be.pxl.researchproject.repository.StudentenRepository;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.AssertTrue;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {
    @Test
    public void readCsvShouldReturnListWithStudents() {
        CSV csv = new CSV();
        Path path = Path.of("src/main/resources/TestStudenten.csv");
        List<Student> studentList = CSV.readCsv(path);
        List<Student> studenten = new ArrayList<>();
        Student student = new Student("PBTIN", "AON", "43AON3200 Bachelor project", "Achternaam", "Voornaam", "Straat", "1","","3333","Gemeente", "voornaam.achternaam@email.be", "voornaam.achternaam@student.pxl.be","0499/12.34.56");
        studenten.add(student);
        assertEquals(studenten, studentList);

    }

}