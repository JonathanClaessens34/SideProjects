package be.pxl.researchproject.rest.service.controller;

import be.pxl.researchproject.GoogleSheetReadData;
import be.pxl.researchproject.api.dto.CompanyDTO;
import be.pxl.researchproject.api.dto.InternshipAssignmentDTO;
import be.pxl.researchproject.api.dto.MainPageDTO;
import be.pxl.researchproject.repository.InternshipAssignmentRepository;
import be.pxl.researchproject.rest.service.CompanyService;
import be.pxl.researchproject.rest.service.InternshipAssignmentService;
import be.pxl.researchproject.rest.service.impl.MainPageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/overview") // This means URL's start with /demo (after Application path)
public class LoadingPageController {
    private final InternshipAssignmentService internshipAssignmentService;
    private final CompanyService companyService;
    private final InternshipAssignmentRepository repository;
    private static final Logger LOGGER = LogManager.getLogger(LoadingPageController.class);
    private final MainPageService mainPageService;

    @Autowired
    private LoadingPageController(InternshipAssignmentService internshipAssignmentService, CompanyService companyService, InternshipAssignmentRepository repository, MainPageService mainPageService) {
        this.internshipAssignmentService = internshipAssignmentService;
        this.companyService = companyService;
        this.repository = repository;
        this.mainPageService = mainPageService;
        }


//    @GetMapping("/{stageopdrachtId}")
//    public ResponseEntity<InternshipAssignmentDTO> getStageopdrachtById(@PathVariable Long stageopdrachtId) {
//        return new ResponseEntity(internshipAssignmentService.findInternshipAssignmentById(stageopdrachtId), HttpStatus.OK);
//    }

    @GetMapping(path="/")
    public ResponseEntity<List<MainPageDTO>> getMainPageData(){
        return new ResponseEntity(mainPageService.fillMainPageDTOList(), HttpStatus.OK);
    }

    @GetMapping(path="/all")
    public List<InternshipAssignmentDTO> getAllStageopdrachten() {
        return internshipAssignmentService.findAllInternshipAssignments();
    }

    @PostMapping(path = "/synchronise")
    public void synchronise() {
        GoogleSheetReadData.synchronise(internshipAssignmentService);
    }


    @DeleteMapping(path = "/stageopdracht/{stageopdrachtId}")
    public ResponseEntity<Void> deleteStageopdracht(@PathVariable Long id) {
        boolean deleted = internshipAssignmentService.deleteInternshipAssignment(id);
        return deleted? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping(path = "/stageopdracht/{id}")
    public InternshipAssignmentDTO getInternshipAssignmentById(@PathVariable Long id) {
        return internshipAssignmentService.findInternshipAssignmentById(id);
    }

    @GetMapping(path = "/company/{id}")
    public CompanyDTO findCompanyById(@PathVariable Long id) {
        return companyService.findCompanyById(id);
    }

    @GetMapping(path = "/company/all")
    public List<CompanyDTO> getAllCompanies() {
        return companyService.findAllCompanies();
    }

}
