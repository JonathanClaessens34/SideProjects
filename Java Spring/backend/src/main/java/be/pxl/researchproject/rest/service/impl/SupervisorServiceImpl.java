package be.pxl.researchproject.rest.service.impl;

import be.pxl.researchproject.api.dto.SupervisorDTO;
import be.pxl.researchproject.api.request.SupervisorRequest;
import be.pxl.researchproject.model.Supervisor;
import be.pxl.researchproject.repository.SupervisorRepository;
import be.pxl.researchproject.rest.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupervisorServiceImpl implements SupervisorService {

    private final SupervisorRepository supervisorRepository;

    @Autowired
    public SupervisorServiceImpl(SupervisorRepository supervisorRepository) {
        this.supervisorRepository = supervisorRepository;
    }

    @Override
    public List<SupervisorDTO> findAllSupervisors() {
        return supervisorRepository.findAll()
                .stream().map(SupervisorDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public SupervisorDTO findSupervisorById(Long id) {
        return supervisorRepository.findStagebegeleiderById(id)
                .map(SupervisorDTO::new)
                .orElseThrow(() -> new Error(id + " not found"));
    }

    @Override
    public SupervisorDTO createSupervisor(SupervisorRequest supervisorRequest) {
        Supervisor supervisor = new Supervisor();
        supervisor.setTitle(supervisorRequest.getTitle());
        supervisor.setName(supervisorRequest.getName());
        supervisor.setFirstName(supervisorRequest.getFirstName());
        supervisor.setPhoneNumber(supervisorRequest.getPhoneNumber());
        supervisor.setEmail(supervisorRequest.getEmail());
        Supervisor newSupervisor = supervisorRepository.save(supervisor);
        return new SupervisorDTO(newSupervisor);
    }

    @Override
    public SupervisorDTO updateSupervisor(Long id, SupervisorRequest supervisorRequest) {
        return supervisorRepository.findStagebegeleiderById(id)
                .map(stagebegeleider -> {
                    stagebegeleider.setTitle(supervisorRequest.getTitle());
                    stagebegeleider.setName(supervisorRequest.getName());
                    stagebegeleider.setFirstName(supervisorRequest.getFirstName());
                    stagebegeleider.setPhoneNumber(supervisorRequest.getPhoneNumber());
                    stagebegeleider.setEmail(supervisorRequest.getEmail());
                    return new SupervisorDTO(supervisorRepository.save(stagebegeleider));
                }).orElseThrow(() -> new Error(id + " unable to update stagebegeleider"));
    }

    @Override
    public boolean deleteSupervisor(Long id) {
        return supervisorRepository.findStagebegeleiderById(id)
                .map(stagebegeleider -> {
                    supervisorRepository.delete(stagebegeleider);
                    return true;
                }).orElseThrow(() -> new Error(id + " unable to delete stagebegeleider"));
    }
}
