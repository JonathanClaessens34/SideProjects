package be.pxl.researchproject.api.request;

import be.pxl.researchproject.model.Company;
import be.pxl.researchproject.model.ContactPerson;
import be.pxl.researchproject.model.Supervisor;

public class DetailPageRequest {

    private Company company;
    private ContactPerson contactPerson;
    private Supervisor supervisor;

    public DetailPageRequest(Company company, ContactPerson contactPerson, Supervisor supervisor) {
        this.company = company;
        this.contactPerson = contactPerson;
        this.supervisor = supervisor;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
}
