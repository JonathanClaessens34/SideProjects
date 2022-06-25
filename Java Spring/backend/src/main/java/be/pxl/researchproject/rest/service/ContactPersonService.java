package be.pxl.researchproject.rest.service;

import be.pxl.researchproject.api.dto.ContactPersonDTO;
import be.pxl.researchproject.api.request.ContactPersonRequest;

import java.util.List;

public interface ContactPersonService {
    List<ContactPersonDTO> findAllContactPersons();
    ContactPersonDTO findContactPersonById(Long id);
    //ContactpersoonDTO findContactpersoonByNaam(String name);
    ContactPersonDTO createContactPerson(ContactPersonRequest cpRequest);
    ContactPersonDTO updateContactPerson(Long id, ContactPersonRequest cpRequest);
    boolean deleteContactPerson(Long id);
}
