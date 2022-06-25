package be.pxl.researchproject.rest.service;

import be.pxl.researchproject.api.dto.SupervisorDTO;
import be.pxl.researchproject.api.request.SupervisorRequest;

import java.util.List;

public interface SupervisorService {

    List<SupervisorDTO> findAllSupervisors();
    SupervisorDTO findSupervisorById(Long id);
    //StagebegeleiderDTO findStagebegeleiderByNaam(String name);
    SupervisorDTO createSupervisor(SupervisorRequest supervisorRequest);
    SupervisorDTO updateSupervisor(Long id, SupervisorRequest supervisorRequest);
    boolean deleteSupervisor(Long id);
}
