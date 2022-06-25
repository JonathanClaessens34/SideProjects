package be.pxl.researchproject.repository;

import be.pxl.researchproject.csv.CSV;
import be.pxl.researchproject.model.Student;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentenRepository {
    private List<Student> studentList = new ArrayList<Student>();

    public StudentenRepository(Path path){
        studentList = CSV.readCsv(path);
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentenRepository() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentenRepository that = (StudentenRepository) o;
        return Objects.equals(studentList, that.studentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentList);
    }
}
