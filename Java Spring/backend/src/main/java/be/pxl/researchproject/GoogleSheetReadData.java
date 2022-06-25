package be.pxl.researchproject;

import be.pxl.researchproject.api.request.InternshipAssignmentRequest;
import be.pxl.researchproject.model.*;
import be.pxl.researchproject.rest.service.InternshipAssignmentService;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Color;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class GoogleSheetReadData {
    private static Sheets sheetsService;
    private static String SPREADSHEET_ID = "1VcIc52crIouDFiRlLHWAlYDpaSQJ3QDtW_4rSFMhTcc";
    private static final Logger LOGGER = LogManager.getLogger(GoogleSheetReadData.class);

    public static void synchronise(InternshipAssignmentService internshipAssignmentService) {
        //internshipAssignmentService.deleteAllInternshipAssignment();

        try {
            sheetsService = SheetsServiceUtil.getSheetsService();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        List<String> ranges = Arrays.asList("Formulierreacties 1!A2:AJ");
        Sheets.Spreadsheets.Get request = null;
        Spreadsheet response = null;
        try {
            request = sheetsService.spreadsheets().get(SPREADSHEET_ID);
            request.setRanges(ranges);
            request.setIncludeGridData(true);
            response = request.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        var allRows = response.getSheets().get(0).getData().get(0).getRowData();

        Color green = new Color().setGreen(1f);
        Color red = new Color().setRed(1f);

        for (var i : allRows) {
            Color bg = i.getValues().get(0).getEffectiveFormat().getBackgroundColor();

            StatusInternshipAssignment newStatus;
            if (bg.equals(green))
                newStatus = StatusInternshipAssignment.Goedgekeurd;
            else if (bg.equals(red))
                newStatus = StatusInternshipAssignment.Afgekeurd;
            else
                newStatus = StatusInternshipAssignment.Nieuw;

            String timestamp = i.getValues().get(0).getFormattedValue();
            String companyName = i.getValues().size() >= 2 ? i.getValues().get(1).getFormattedValue() : "";

            String streetAndNumber = i.getValues().size() >= 3 ? i.getValues().get(2).getFormattedValue() : "";
            String postcode = i.getValues().size() >= 4 ? i.getValues().get(3).getFormattedValue() : "";
            String town = i.getValues().size() >= 5 ? i.getValues().get(4).getFormattedValue() : "";
            String internshipLocation = i.getValues().size() >= 6 ? i.getValues().get(5).getFormattedValue() : "";
            String internshipStreet = "";
            String internshipTown = "";
            if (internshipLocation != null && internshipLocation.contains(",")) {
                internshipStreet = internshipLocation.split(",")[0];
                internshipTown = internshipLocation.split(",")[1];
            }
            String amountEmployeesCompany = i.getValues().size() >= 7 && i.getValues().get(6).getFormattedValue() != null ? i.getValues().get(6).getFormattedValue() : "0";
            String amountEAEmployeesCompany = i.getValues().size() >= 8 && i.getValues().get(7).getFormattedValue() != null ? i.getValues().get(7).getFormattedValue() : "0";
            String amountITEmployeesCompany = i.getValues().size() >= 9 && i.getValues().get(8).getFormattedValue() != null ? i.getValues().get(8).getFormattedValue() : "0";
            String titleContactPerson = i.getValues().size() >= 10 ? i.getValues().get(9).getFormattedValue() : "";
            String lastNameContactPerson = i.getValues().size() >= 11 ? i.getValues().get(10).getFormattedValue() : "";
            String firstNameContactPerson = i.getValues().size() >= 12 ? i.getValues().get(11).getFormattedValue() : "";
            String phoneNumberContactPerson = i.getValues().size() >= 13 ? i.getValues().get(12).getFormattedValue() : "";
            String emailContactPerson = i.getValues().size() >= 14 ? i.getValues().get(13).getFormattedValue() : "";
            String titleCompanyPromoter = i.getValues().size() >= 15 ? i.getValues().get(14).getFormattedValue() : "";
            String lastNameCompanyPromoter = i.getValues().size() >= 16 ? i.getValues().get(15).getFormattedValue() : "";
            String firstNameCompanyPromoter = i.getValues().size() >= 17 ? i.getValues().get(16).getFormattedValue() : "";
            String phoneNumberCompanyPromoter = i.getValues().size() >= 18 ? i.getValues().get(17).getFormattedValue() : "";
            String emailCompanyPromoter = i.getValues().size() >= 19 ? i.getValues().get(18).getFormattedValue() : "";
            String preferenceSpecialisation = i.getValues().size() >= 20 ? i.getValues().get(19).getFormattedValue() : "";
            String descriptionAssignment = i.getValues().size() >= 21 ? i.getValues().get(20).getFormattedValue() : "";
            String environment = i.getValues().size() >= 22 ? i.getValues().get(21).getFormattedValue() : "";
            String environmentDescription = i.getValues().size() >= 23 ? String.valueOf(i.getValues().get(22).getFormattedValue()) : "";
            String conditions = i.getValues().size() >= 24 ? i.getValues().get(23).getFormattedValue() : "";
            String researchTheme = i.getValues().size() >= 25 ? i.getValues().get(24).getFormattedValue() : "";
            String introductoryActivities = i.getValues().size() >= 26 ? i.getValues().get(25).getFormattedValue() : "";
            String amountPreferredInterns = i.getValues().size() >= 27 && i.getValues().get(26).getFormattedValue() != null ? i.getValues().get(26).getFormattedValue().split(" ")[0] : "0";
            String selectionStudentsOptional = i.getValues().size() >= 28 ? i.getValues().get(27).getFormattedValue() : "";
            ;
            String otherComments = i.getValues().size() >= 29 ? i.getValues().get(28).getFormattedValue() : "";
            String internshipPeriod = i.getValues().size() >= 30 ? i.getValues().get(29).getFormattedValue() : "";
            String titleInternshipAssignment = i.getValues().size() >= 31 ? i.getValues().get(30).getFormattedValue() : "";
            String reviewer = "";
            if (i.getValues().size() >= 34) {
                reviewer = i.getValues().get(33).getFormattedValue();
            }
            String reviewComment = "";
            if (i.getValues().size() == 36)
                reviewComment = i.getValues().get(35).getFormattedValue();

            Company company = new Company();
            company.setLocationInternshipStreet(internshipStreet);
            company.setLocationInternshipCity(internshipTown);
            company.setCity(town);
            company.setName(companyName);
            company.setPostal(postcode);
            company.setNumberOfEAEmployees(Integer.parseInt(amountEAEmployeesCompany));
            company.setNumberOfITEmployees(Integer.parseInt(amountITEmployeesCompany));
            company.setNumberOfEmployees(Integer.parseInt(amountEmployeesCompany));
            company.setStreet(streetAndNumber);

            ContactPerson contactperson = new ContactPerson();
            contactperson.setName(lastNameContactPerson);
            contactperson.setEmail(emailContactPerson);
            contactperson.setPhoneNumber(phoneNumberContactPerson);
            contactperson.setTitle(titleContactPerson);
            contactperson.setFirstName(firstNameContactPerson);

            Supervisor companyPromoter = new Supervisor();
            companyPromoter.setPhoneNumber(phoneNumberCompanyPromoter);
            companyPromoter.setEmail(emailCompanyPromoter);
            companyPromoter.setTitle(titleCompanyPromoter);
            companyPromoter.setFirstName(firstNameCompanyPromoter);
            companyPromoter.setName(lastNameCompanyPromoter);

            InternshipDescription intershipDescription = new InternshipDescription();
            intershipDescription.setNumberOfDesiredInterns(Integer.parseInt(amountPreferredInterns));
            intershipDescription.setEnvironment(environment);
            intershipDescription.setEnvironmentDescription(environmentDescription);
            intershipDescription.setIntroductoryActivities(introductoryActivities);
            intershipDescription.setInternshipPeriod(internshipPeriod);
            intershipDescription.setResearchTheme(researchTheme);
            intershipDescription.setDescriptionAssignment(descriptionAssignment);
            intershipDescription.setComments(otherComments);
            intershipDescription.setConditions(conditions);
            intershipDescription.setPreferredSpecialization(preferenceSpecialisation);
            intershipDescription.setTitleInternshipAssignment(titleInternshipAssignment);
            intershipDescription.setSelectionOfStudentsOptional(selectionStudentsOptional);

            Reviewer newReviewer = new Reviewer();
            newReviewer.setMail(reviewer);
            int dot, ad;
            String firstName = "";
            String lastName = "";
            if (!(reviewer == null)) {
                dot = newReviewer.getMail().indexOf(".");
                ad = newReviewer.getMail().indexOf("@");
                if (dot != -1) {
                    firstName = newReviewer.getMail().substring(0, dot);
                    firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
                }
                newReviewer.setFirstName(firstName);
                if (dot != -1 && ad != -1) {
                    lastName = newReviewer.getMail().substring(dot + 1, ad);
                    lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
                }
            }
            newReviewer.setLastName(lastName);
            newReviewer.setReviewCommentary(reviewComment);

            var existingCompany = internshipAssignmentService.findCompany(company);
            if(existingCompany != null)
                company = existingCompany;

            var existingContactPerson = internshipAssignmentService.findContactPerson(contactperson);
            if(existingContactPerson != null)
                contactperson = existingContactPerson;

            var existingIntershipDescription = internshipAssignmentService.findInternshipDescription(intershipDescription);
            if(existingIntershipDescription != null)
                intershipDescription = existingIntershipDescription;

            var existingReviewer = internshipAssignmentService.findReviewer(newReviewer);
            if(existingReviewer != null)
                newReviewer = existingReviewer;

            var existingSupervisor = internshipAssignmentService.findSupervisor(companyPromoter);
            if(existingSupervisor != null)
                companyPromoter = existingSupervisor;

            InternshipAssignment internshipAssignment = new InternshipAssignment();
            internshipAssignment.setCompany(company);
            internshipAssignment.setContactPerson(contactperson);
            internshipAssignment.setReviewer(newReviewer);
            internshipAssignment.setSupervisor(companyPromoter);
            internshipAssignment.setInternshipDescription(intershipDescription);
            internshipAssignment.setStatus(newStatus);
            internshipAssignment.setTimestamp(timestamp);
            internshipAssignment.setTitle("");

            if(!internshipAssignmentService.findInternshipAssignment(internshipAssignment)) {
                InternshipAssignmentRequest internshipAssignmentRequest = new InternshipAssignmentRequest("", company, contactperson, companyPromoter, newStatus, timestamp, newReviewer, intershipDescription);
                internshipAssignmentService.createInternshipAssignment(internshipAssignmentRequest);
            }
        }

    }
}
