package com.example.mad4;

public class Add1 {

    private String A_plus;
    private String A_minus;
    private String B_plus;
    private String B_minus;
    private String AB_plus;
    private String AB_minus;
    private String O_plus;
    private String O_minus;
    private String hospital;
    private String city;
    private String contact;

    public Add1() {
    }

    public Add1(String a_plus, String a_minus, String b_plus, String b_minus, String AB_plus, String AB_minus, String o_plus, String o_minus, String hospital, String city, String contact) {
        A_plus = a_plus;
        A_minus = a_minus;
        B_plus = b_plus;
        B_minus = b_minus;
        this.AB_plus = AB_plus;
        this.AB_minus = AB_minus;
        O_plus = o_plus;
        O_minus = o_minus;
        this.hospital = hospital;
        this.city = city;
        this.contact = contact;
    }

    public String getA_plus() {
        return A_plus;
    }

    public void setA_plus(String a_plus) {
        A_plus = a_plus;
    }

    public String getA_minus() {
        return A_minus;
    }

    public void setA_minus(String a_minus) {
        A_minus = a_minus;
    }

    public String getB_plus() {
        return B_plus;
    }

    public void setB_plus(String b_plus) {
        B_plus = b_plus;
    }

    public String getB_minus() {
        return B_minus;
    }

    public void setB_minus(String b_minus) {
        B_minus = b_minus;
    }

    public String getAB_plus() {
        return AB_plus;
    }

    public void setAB_plus(String AB_plus) {
        this.AB_plus = AB_plus;
    }

    public String getAB_minus() {
        return AB_minus;
    }

    public void setAB_minus(String AB_minus) {
        this.AB_minus = AB_minus;
    }

    public String getO_plus() {
        return O_plus;
    }

    public void setO_plus(String o_plus) {
        O_plus = o_plus;
    }

    public String getO_minus() {
        return O_minus;
    }

    public void setO_minus(String o_minus) {
        O_minus = o_minus;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
