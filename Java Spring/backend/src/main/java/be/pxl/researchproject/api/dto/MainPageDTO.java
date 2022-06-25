package be.pxl.researchproject.api.dto;

import be.pxl.researchproject.model.ContactPerson;
import be.pxl.researchproject.model.Reviewer;
import be.pxl.researchproject.model.StatusInternshipAssignment;

import java.util.Locale;

public class MainPageDTO {

    private long id;
    private String companyName;
    private String title;
    private String specialization;
    private String period;
    private StatusInternshipAssignment currentStatus;

    public MainPageDTO(long id, String companyName, String title, String specialization, String period, StatusInternshipAssignment currentStatus) {
        setId(id);
        setCompanyName(companyName);
        setTitle(title);
        setSpecialization(specialization);
        setPeriod(period);
        setCurrentStatus(currentStatus);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        if (companyName == null) {
            this.companyName = "-/-";
        }
        else {
            this.companyName = companyName;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) {
            this.title = "-/-";
        }
        else {
            this.title = title;
        }
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        StringBuilder builder = new StringBuilder();
        if (specialization != null) {
            if (specialization.toLowerCase().contains("full")) builder.append("AON - Full, ");
            if (specialization.toLowerCase().contains("ai")) builder.append("AON - AI, ");
            if (specialization.toLowerCase().contains("systemen")) builder.append("SNB, ");
            if (specialization.toLowerCase().contains("software")) builder.append("SWM, ");
            if (specialization.toLowerCase().contains("ict")) builder.append("Electronica-ICT, ");
            this.specialization = builder.substring(0, builder.length()-2);
        }
        else {
            this.specialization = "-/-";
        }
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        if(period != null) {
            if (period.toLowerCase().contains("semester 1") && period.toLowerCase().contains("semester 2"))
                this.period = "Semester 1 & 2";
            else if (period.toLowerCase().contains("semester 1")) this.period = "Semester 1";
            else if (period.toLowerCase().contains("semester 2")) this.period = "Semester 2";
        }
        else {
            this.period = "-/-";
        }
    }

    public StatusInternshipAssignment getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(StatusInternshipAssignment currentStatus) { this.currentStatus = currentStatus; }
}
