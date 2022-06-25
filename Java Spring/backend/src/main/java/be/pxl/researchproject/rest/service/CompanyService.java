package be.pxl.researchproject.rest.service;

import be.pxl.researchproject.api.dto.CompanyDTO;
import be.pxl.researchproject.api.request.CompanyRequest;

import java.util.List;

public interface CompanyService {
    List<CompanyDTO> findAllCompanies();
    CompanyDTO findCompanyById(Long id);
    CompanyDTO createCompany(CompanyRequest companyRequest);
    CompanyDTO updateCompany(Long id, CompanyRequest companyRequest);
    boolean deleteCompany(Long id);

}
