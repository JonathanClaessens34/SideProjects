package be.pxl.researchproject.rest.service.impl;

import be.pxl.researchproject.api.dto.ContactPersonDTO;
import be.pxl.researchproject.api.request.ContactPersonRequest;
import be.pxl.researchproject.model.ContactPerson;
import be.pxl.researchproject.repository.ContactPersonRepository;
import be.pxl.researchproject.rest.service.ContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactPersonServiceImpl implements ContactPersonService {

    private final ContactPersonRepository contactPersonRepository;

    @Autowired
    public ContactPersonServiceImpl(ContactPersonRepository contactPersonRepository) {
        this.contactPersonRepository = contactPersonRepository;
    }

    @Override
    public List<ContactPersonDTO> findAllContactPersons() {
        return contactPersonRepository.findAll()
                .stream().map(ContactPersonDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public ContactPersonDTO findContactPersonById(Long id) {
        return contactPersonRepository.findContactpersoonById(id)
                .map(ContactPersonDTO::new)
                .orElseThrow(() -> new Error(id + "not found"));
    }

    @Override
    public ContactPersonDTO createContactPerson(ContactPersonRequest cpRequest) {
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setTitle(cpRequest.getTitle());
        contactPerson.setName(cpRequest.getName());
        contactPerson.setFirstName(cpRequest.getFirstName());
        contactPerson.setPhoneNumber(cpRequest.getPhoneNumber());
        contactPerson.setEmail(cpRequest.getEmail());
        ContactPerson newContactPerson = contactPersonRepository.save(contactPerson);
        return new ContactPersonDTO(newContactPerson);
    }

    @Override
    public ContactPersonDTO updateContactPerson(Long id, ContactPersonRequest cpRequest) {
        return contactPersonRepository.findContactpersoonById(id)
                .map(contactpersoon -> {
            contactpersoon.setTitle(cpRequest.getTitle());
            contactpersoon.setName(cpRequest.getName());
            contactpersoon.setFirstName(cpRequest.getFirstName());
            contactpersoon.setPhoneNumber(cpRequest.getPhoneNumber());
            contactpersoon.setEmail(cpRequest.getEmail());
            return new ContactPersonDTO(contactPersonRepository.save(contactpersoon));
        }).orElseThrow(() -> new Error(id + "not found or couldn't update contactpersoon"));
    }

    @Override
    public boolean deleteContactPerson(Long id) {
        return contactPersonRepository.findContactpersoonById(id)
                .map(contactpersoon -> {
                    contactPersonRepository.delete(contactpersoon);
                    return true;
                }).orElseThrow(() -> new Error(id + " not found or couldn't delete contactpersoon"));
    }
}
