package model;

import java.sql.Date;

abstract class Person {

    private String fname;
    private String lname;
    private String email;
    private String password;
    private Date dob;
    private String gender;

//constructors
    public Person(String fname, String lname, String email, String password, Date dob, String gender) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
    }

    public Person(){}


//getters and setters
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }




}
