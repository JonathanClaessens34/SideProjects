package be.pxl.researchproject.api.dto;

import be.pxl.researchproject.model.Student;

import java.util.List;

public class StudentenDTO {
    private List<Student> studentList;

    public StudentenDTO(List<Student> studenten) {
        studentList = studenten;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
