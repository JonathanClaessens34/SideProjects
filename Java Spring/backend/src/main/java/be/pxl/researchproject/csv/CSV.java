package be.pxl.researchproject.csv;

import be.pxl.researchproject.model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSV {

    public CSV() {
    }
    public static List<Student> readCsv(Path path) {
        String line = "";
        String splitBy = ";";
        List<Student> studenten = new ArrayList<>();
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = Files.newBufferedReader(path);
            line = br.readLine();
            while ((line = br.readLine()) != null)
            //returns a Boolean value
            {
                String[] studentParts = line.split(splitBy);
                Student student = new Student(studentParts[0], studentParts[1], studentParts[2], studentParts[3], studentParts[4], studentParts[5], studentParts[6], studentParts[7], studentParts[8], studentParts[9], studentParts[10], studentParts[11], studentParts[12]);
                studenten.add(student);

            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return studenten;
    }
}


