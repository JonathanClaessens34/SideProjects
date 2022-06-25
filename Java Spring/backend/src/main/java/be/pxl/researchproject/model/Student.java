package be.pxl.researchproject.model;

import java.util.Objects;

public class Student {
    private String opleiding;
    private String afstudeerrichting;
    private String OLOD;
    private String naam;
    private String voornaam;
    private String straat;
    private String nummer;
    private String bus;
    private String postcode;
    private String gemeente;
    private String priveEmail;
    private String ibamaflexMail;
    private String gsmNummer;

    public Student(String opleiding, String afstudeerrichting, String OLOD, String naam, String voornaam, String straat, String nummer, String bus, String postcode, String gemeente, String priveEmail, String ibamaflexMail, String gsmNummer) {
        this.opleiding = opleiding;
        this.afstudeerrichting = afstudeerrichting;
        this.OLOD = OLOD;
        this.naam = naam;
        this.voornaam = voornaam;
        this.straat = straat;
        this.nummer = nummer;
        this.bus = bus;
        this.postcode = postcode;
        this.gemeente = gemeente;
        this.priveEmail = priveEmail;
        this.ibamaflexMail = ibamaflexMail;
        this.gsmNummer = gsmNummer;
    }

    public String getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(String opleiding) {
        this.opleiding = opleiding;
    }

    public String getAfstudeerrichting() {
        return afstudeerrichting;
    }

    public void setAfstudeerrichting(String afstudeerrichting) {
        this.afstudeerrichting = afstudeerrichting;
    }

    public String getOLOD() {
        return OLOD;
    }

    public void setOLOD(String OLOD) {
        this.OLOD = OLOD;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public String getPriveEmail() {
        return priveEmail;
    }

    public void setPriveEmail(String priveEmail) {
        this.priveEmail = priveEmail;
    }

    public String getIbamaflexMail() {
        return ibamaflexMail;
    }

    public void setIbamaflexMail(String ibamaflexMail) {
        this.ibamaflexMail = ibamaflexMail;
    }

    public String getGsmNummer() {
        return gsmNummer;
    }

    public void setGsmNummer(String gsmNummer) {
        this.gsmNummer = gsmNummer;
    }

    @Override
    public String toString() {
        return "Student{" +
                "opleiding='" + opleiding + '\'' +
                ", afstudeerrichting='" + afstudeerrichting + '\'' +
                ", OLOD='" + OLOD + '\'' +
                ", naam='" + naam + '\'' +
                ", voornaam='" + voornaam + '\'' +
                ", straat='" + straat + '\'' +
                ", nummer='" + nummer + '\'' +
                ", bus='" + bus + '\'' +
                ", postcode='" + postcode + '\'' +
                ", gemeente='" + gemeente + '\'' +
                ", priveEmail='" + priveEmail + '\'' +
                ", ibamaflexMail='" + ibamaflexMail + '\'' +
                ", gsmNummer='" + gsmNummer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(opleiding, student.opleiding) && Objects.equals(afstudeerrichting, student.afstudeerrichting) && Objects.equals(OLOD, student.OLOD) && Objects.equals(naam, student.naam) && Objects.equals(voornaam, student.voornaam) && Objects.equals(straat, student.straat) && Objects.equals(nummer, student.nummer) && Objects.equals(bus, student.bus) && Objects.equals(postcode, student.postcode) && Objects.equals(gemeente, student.gemeente) && Objects.equals(priveEmail, student.priveEmail) && Objects.equals(ibamaflexMail, student.ibamaflexMail) && Objects.equals(gsmNummer, student.gsmNummer);
    }
}

