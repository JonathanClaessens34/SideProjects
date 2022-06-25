package be.pxl.researchproject.api.dto;

import be.pxl.researchproject.model.Supervisor;

public class SupervisorDTO {
    private String title, name, firstName, phoneNumber, email;

    public SupervisorDTO(Supervisor supervisor) {
        this.title = supervisor.getTitle();
        this.name = supervisor.getName();
        this.firstName = supervisor.getFirstName();
        this.phoneNumber = supervisor.getPhoneNumber();
        this.email = supervisor.getEmail();
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
