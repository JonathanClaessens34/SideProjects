package be.pxl.researchproject.rest.service.controller;

import be.pxl.researchproject.ReceiveEmail;
import be.pxl.researchproject.SendEmail;
import be.pxl.researchproject.api.dto.InternshipAssignmentDTO;
import be.pxl.researchproject.api.dto.MailDTO;
import be.pxl.researchproject.api.dto.StudentenDTO;
import be.pxl.researchproject.api.request.*;
import be.pxl.researchproject.csv.CSV;
import be.pxl.researchproject.rest.service.InternshipAssignmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.ArrayList;

@RestController
@RequestMapping(path="/details")
public class DetailsPageController {
    private final InternshipAssignmentService internshipAssignmentService;
    private static final Logger LOGGER = LogManager.getLogger(DetailsPageController.class);
    private final Path path = Path.of("src/main/resources/Studenten.csv");

    @Autowired
    private DetailsPageController(InternshipAssignmentService internshipAssignmentService) {
        this.internshipAssignmentService = internshipAssignmentService;
    }

    @GetMapping("/{internshipAssignmentId}")
    public ResponseEntity<InternshipAssignmentDTO> getStageopdrachtById(@PathVariable Long internshipAssignmentId) {
        return new ResponseEntity(internshipAssignmentService.findInternshipAssignmentById(internshipAssignmentId), HttpStatus.OK);
    }

    @PostMapping(path = "/sendmail")
    public void sendmail(@RequestBody MailRequest mailRequest) {
        SendEmail.sendEmail(mailRequest);
    }

    @GetMapping(path = "/getmails/{stageopdrachtId}")
    public ResponseEntity<ArrayList<MailDTO>> getMails(@PathVariable Long stageopdrachtId, @RequestBody MailRequest mailRequest) {
        return new ResponseEntity(ReceiveEmail.receiveEmail("pop.gmail.com", "pop3", mailRequest), HttpStatus.OK);
    }


    @PutMapping("/{internshipAssignmentId}")
    public ResponseEntity<InternshipAssignmentDTO> updateStageopdracht(@PathVariable Long internshipAssignmentId, @RequestBody DetailPageRequest detailPageRequest) {
        return new ResponseEntity(internshipAssignmentService.updateInternshipAssignmentDetailPage(internshipAssignmentId, detailPageRequest), HttpStatus.OK);
    }

    @PutMapping("/editCompany/{internshipAssignmentId}")
    public ResponseEntity<InternshipAssignmentDTO> updateCompanyInternship(@PathVariable Long internshipAssignmentId, @RequestBody CompanyRequest request){
        return new ResponseEntity(internshipAssignmentService.updateInternshipAssignmentCompany(internshipAssignmentId, request), HttpStatus.OK);
    }

    @PutMapping("/editContactPerson/{internshipAssignmentId}")
    public ResponseEntity<InternshipAssignmentDTO> updateContactPersonInternship(@PathVariable Long internshipAssignmentId, @RequestBody ContactPersonRequest request){
        return new ResponseEntity(internshipAssignmentService.updateInternshipAssignmentContactPerson(internshipAssignmentId, request), HttpStatus.OK);
    }

    @PutMapping("/editSupervisor/{internshipAssignmentId}")
    public ResponseEntity<InternshipAssignmentDTO> updateSupervisorInternship(@PathVariable Long internshipAssignmentId, @RequestBody SupervisorRequest request){
        return new ResponseEntity(internshipAssignmentService.updateInternshipAssignmentSupervisor(internshipAssignmentId, request), HttpStatus.OK);
    }

    @GetMapping("/student")
    public ResponseEntity<StudentenDTO> getStudenten() {
        return new ResponseEntity(new StudentenDTO(CSV.readCsv(path)), HttpStatus.OK);
    }

    @PostMapping("/detailed")
    public void postDetailedPageInternship() {
    }

    @PutMapping("/{internshipAssignmentId}/{status}")
    public InternshipAssignmentDTO changeStatus(@PathVariable Long internshipAssignmentId, @PathVariable String status){
        InternshipAssignmentDTO internshipAssignmentDTO = internshipAssignmentService.changeStatus(internshipAssignmentId, status);

        return internshipAssignmentDTO;
    }

}
