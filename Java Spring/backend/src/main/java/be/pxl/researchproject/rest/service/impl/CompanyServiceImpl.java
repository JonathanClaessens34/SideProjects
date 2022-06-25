package be.pxl.researchproject.rest.service.impl;

import be.pxl.researchproject.api.dto.CompanyDTO;
import be.pxl.researchproject.api.request.CompanyRequest;
import be.pxl.researchproject.model.Company;
import be.pxl.researchproject.repository.CompanyRepository;
import be.pxl.researchproject.rest.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public List<CompanyDTO> findAllCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(CompanyDTO::new)
                .collect(Collectors.toList());
    }

    public CompanyDTO findCompanyById(Long id) {
        return companyRepository.findBedrijfById(id)
                .map(CompanyDTO::new)
                .orElseThrow(() -> new Error(id + " not found"));
    }

    @Override
    public CompanyDTO createCompany(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setName(companyRequest.getName());
        company.setStreet(companyRequest.getStreet());
        company.setCity(companyRequest.getCity());
        company.setLocationInternshipStreet(companyRequest.getLocationInternshipStreet());
        company.setLocationInternshipCity(companyRequest.getLocationInternshipCity());
        company.setPostal(companyRequest.getPostal());
        company.setNumberOfEmployees(companyRequest.getNumberOfEmployees());
        company.setNumberOfEAEmployees(companyRequest.getNumberOfEAEmployees());
        company.setNumberOfITEmployees(companyRequest.getNumberOfITEmployees());
        Company newCompany = companyRepository.save(company);
        return new CompanyDTO(newCompany);
    }

    public CompanyDTO updateCompany(Long id, CompanyRequest companyRequest) {
        return companyRepository.findBedrijfById(id)
                .map(company -> {
                    company.setName(companyRequest.getName());
                    company.setStreet(companyRequest.getStreet());
                    company.setCity(companyRequest.getCity());
                    company.setLocationInternshipStreet(companyRequest.getLocationInternshipStreet());
                    company.setLocationInternshipCity(companyRequest.getLocationInternshipCity());
                    company.setPostal(companyRequest.getPostal());
                    company.setNumberOfEmployees(companyRequest.getNumberOfEmployees());
                    company.setNumberOfEAEmployees(companyRequest.getNumberOfEAEmployees());
                    company.setNumberOfITEmployees(companyRequest.getNumberOfITEmployees());
                    return new CompanyDTO(companyRepository.save(company));
                }).orElseThrow(() -> new Error(id + "not found"));
    }

    public boolean deleteCompany(Long id) {
        return companyRepository.findBedrijfById(id)
                .map(bedrijf -> {
                    companyRepository.delete(bedrijf);
                    return true;
                }).orElseThrow(() -> new Error(id + " not found"));
    }
}
