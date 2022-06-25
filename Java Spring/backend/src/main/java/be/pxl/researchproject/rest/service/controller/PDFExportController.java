package be.pxl.researchproject.rest.service.controller;

import be.pxl.researchproject.model.Company;
import be.pxl.researchproject.model.ContactPerson;
import be.pxl.researchproject.model.InternshipAssignment;
import be.pxl.researchproject.model.InternshipDescription;
import be.pxl.researchproject.repository.CompanyRepository;
import be.pxl.researchproject.repository.ContactPersonRepository;
import be.pxl.researchproject.repository.InternshipAssignmentRepository;
import be.pxl.researchproject.repository.InternshipDescriptionRepository;
import be.pxl.researchproject.service.PDFGeneratorService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
public class PDFExportController {


    private PDFGeneratorService pdfGeneratorService;

    private InternshipAssignmentRepository internshipAssignmentRepository;
    private CompanyRepository companyRepository;
    private InternshipDescriptionRepository internshipDescriptionRepository;
    private ContactPersonRepository contactPersonRepository;

    @Autowired
    public PDFExportController(InternshipAssignmentRepository internshipAssignmentRepository, CompanyRepository companyRepository, InternshipDescriptionRepository internshipDescriptionRepository, ContactPersonRepository contactPersonRepository) {

        this.internshipAssignmentRepository = internshipAssignmentRepository;
        this.companyRepository = companyRepository;
        this.internshipDescriptionRepository = internshipDescriptionRepository;
        this.contactPersonRepository = contactPersonRepository;
    }

    @GetMapping("/pdf/generate/{id}")
    public void generatePDF(@PathVariable Long id, HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=stageopdracht_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        InternshipAssignment internshipAssignment = internshipAssignmentRepository.getById(id);
        Company company = internshipAssignmentRepository.getById(id).getCompany();
        ContactPerson contactPerson = internshipAssignmentRepository.getById(id).getContactPerson();
        InternshipDescription internshipDescription = internshipAssignmentRepository.getById(id).getInternshipDescription();


        PDFGeneratorService service = new PDFGeneratorService(internshipAssignment, company, contactPerson, internshipDescription);

        service.export(response);
    }
}
