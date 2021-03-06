package be.pxl.researchproject.service;

import be.pxl.researchproject.model.Company;
import be.pxl.researchproject.model.ContactPerson;
import be.pxl.researchproject.model.InternshipAssignment;
import be.pxl.researchproject.model.InternshipDescription;
import be.pxl.researchproject.repository.InternshipAssignmentRepository;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Text;
//import com.lowagie.text.*;
//import com.lowagie.text.pdf.PdfDocument;
//import com.lowagie.text.pdf.PdfWriter;
//import org.apache.pdfbox.pdmodel.PDDocument;
import com.itextpdf.text.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;




import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyleConstants;
import javax.websocket.Decoder;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;


public class PDFGeneratorService {

    private static Font fontTitle = new Font(Font.FontFamily.HELVETICA,24, Font.BOLD);
    private static Font subTitle = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
    //private static Font fontParaGraph = new Font(Font.HELVETICA, 12);
    private static Company company;
    private static InternshipAssignment internshipAssignment;
    private static ContactPerson contactPerson;
    private static InternshipDescription internshipDescription;
    private PdfWriter pdfWriter;


    private InternshipAssignmentRepository internshipAssignmentRepository;


    public PDFGeneratorService(InternshipAssignment internshipAssignment, Company company, ContactPerson contactPerson, InternshipDescription internshipDescription) {
        this.internshipAssignment = internshipAssignment;
        this.company = company;
        this.contactPerson = contactPerson;
        this.internshipDescription = internshipDescription;
    }

    public void export(HttpServletResponse response) throws IOException, DocumentException {

        Document document = new Document();



        pdfWriter = PdfWriter.getInstance(document, response.getOutputStream());
        try {
            document.open();
            pdfWriter.open();

            com.itextpdf.text.Image PXL_logo = com.itextpdf.text.Image.getInstance("src/main/resources/PXL_logo.png");
            PXL_logo.scaleAbsolute(200, 105);
            document.add(PXL_logo);

            addMetaData(document);
            addContent(document, response);

            document.close();
            pdfWriter.close();
//            File file = new File("src/main/resources/GeneratedPdfPXLStageopdracht");
//
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            PdfWriter.getInstance(document, new FileOutputStream(file));




        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    public static void addMetaData(Document document) {

        document.addTitle("Stageopdracht generated PDF");
        document.addSubject("Stageopdracht generated by AON10");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("AON10");
        document.addCreator("AON10");

    }

    private static void addContent(Document document, HttpServletResponse response) throws DocumentException, IOException, URISyntaxException {



            // Setting HTTPResponse content type as PDF
            response.setContentType("application/pdf");
            PdfWriter.getInstance(document, response.getOutputStream());

            // Add 1 empty line








            Anchor anchor = new Anchor("STAGEOPDRACHT", fontTitle);
            anchor.setName("Title");

            document.add(new Paragraph(anchor));
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));







            document.add(new Chunk("Bedrijf / opdrachtgever: ", subTitle));
            document.add(new Chunk(company.getName() + "\n"));
            document.add(new Paragraph(""));
            
            document.add(new Chunk("Adres: ", subTitle));
            document.add(new Chunk(company.getLocationInternshipStreet() + "\n"));
            document.add(new Chunk(company.getLocationInternshipCity() + "\n"));
            document.add(new Paragraph(""));


            document.add(new Chunk("Contactpersoon: ", subTitle));
            if (contactPerson.getName() == null) {
                document.add(new Chunk("/" + "\n"));
            } else {
                document.add(new Chunk(contactPerson.getFirstName() + " " + contactPerson.getName() + "\n"));
                document.add(new Chunk(contactPerson.getPhoneNumber() + "\n"));
                document.add(new Chunk(contactPerson.getEmail() + "\n"));
            }
            document.add(new Paragraph(""));


            document.add(new Chunk("Bedrijspromoter: ", subTitle));
            if (contactPerson.getName() == null) {
                document.add(new Chunk("/" + "\n"));
            } else {
                document.add(new Chunk(contactPerson.getFirstName() + " " + contactPerson.getName() + "\n"));
                document.add(new Chunk(contactPerson.getPhoneNumber() + "\n"));
                document.add(new Chunk(contactPerson.getEmail() + "\n"));
            }
            document.add(new Paragraph(""));



            document.add(new Chunk("Aantal medewerkers: ", subTitle));
            document.add(new Chunk(String.valueOf(company.getNumberOfEmployees() + "\n")));
            document.add(new Paragraph(""));



            document.add(new Chunk("Aantal IT medewerkers: ", subTitle));
            document.add(new Chunk(String.valueOf(company.getNumberOfITEmployees() + "\n")));
            document.add(new Paragraph(""));


            document.add(new Chunk("Aantal technische begeleiders: ", subTitle));
            document.add(new Chunk(String.valueOf(company.getNumberOfEAEmployees() + "\n")));
            document.add(new Paragraph(""));


            document.add(new Chunk("Afstudeerrichting: ", subTitle));
            document.add(new Chunk(internshipDescription.getPreferredSpecialization() + "\n"));
            document.add(new Paragraph(""));


            document.add(new Chunk("Opdracht: ", subTitle));
            document.add(new Paragraph(internshipDescription.getDescriptionAssignment() + "\n"));
            document.add(new Paragraph(""));

            document.add(new Chunk("Extra info: ", subTitle));
            if (internshipDescription.getComments() == null) {
                document.add(new Chunk("/" + "\n"));
            } else {
                document.add(new Chunk(internshipDescription.getComments() + "\n"));
            }
            document.add(new Paragraph(""));

            document.add(new Chunk("Omgeving: ", subTitle));
            document.add(new Chunk(internshipDescription.getEnvironment() + "\n"));
            document.add(new Paragraph(""));


            document.add(new Chunk("Randvoorwaarden: ", subTitle));
            document.add(new Chunk(internshipDescription.getConditions() + "\n"));
            document.add(new Paragraph(""));

            document.add(new Chunk("Onderzoeksthema: ", subTitle));
            document.add(new Chunk(internshipDescription.getResearchTheme() + "\n"));
            document.add(new Paragraph(""));

            document.add(new Chunk("Inleidende activiteiten: ", subTitle));
            document.add(new Chunk(internshipDescription.getIntroductoryActivities() + "\n"));
            document.add(new Paragraph(""));

            document.add(new Chunk("Aantal studenten: ", subTitle));
            if(internshipDescription.getSelectionOfStudentsOptional() == null) {
                document.add(new Chunk("/" + "\n"));
            } else {
                document.add(new Chunk(internshipDescription.getSelectionOfStudentsOptional() + "\n"));
            }
            document.add(new Paragraph(""));

            document.add(new Chunk("Aanwezig op handshake event: ", subTitle));
            document.add(new Chunk("Aanwezig " + "\n"));
            document.add(new Paragraph(""));

            document.add(new Chunk("Stageopdracht voor: ", subTitle));
            document.add(new Chunk(company.getName() + "\n"));
            document.add(new Paragraph(""));

            document.add(new Chunk("Aantal bemerkingen: ", subTitle));
            document.add(new Chunk("\n"));
        }


}




//    private static void addEmptyLine(Document document, int number) {
//        for (int i = 0; i < number; i++) {
//            document.add(new Paragraph(" "));
//        }
//    }



