package be.pxl.researchproject.api.dto;

import be.pxl.researchproject.model.ContactPerson;

public class ContactPersonDTO {
    private String title, name, firstName, phoneNumber, email;

    public ContactPersonDTO(ContactPerson contactPerson) {
        this.title = contactPerson.getTitle();
        this.name = contactPerson.getName();
        this.firstName = contactPerson.getFirstName();
        this.phoneNumber = contactPerson.getPhoneNumber();
        this.email = contactPerson.getEmail();
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
