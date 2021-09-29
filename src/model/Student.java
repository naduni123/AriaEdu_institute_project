package model;

import java.sql.Date;

public class Student {

    //declare variables
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dob;
    private String nic;
    private String address;
    private int phone;
    private String email;
    private Date admissionDate;
    private String batch;
    private String status;
    private String[] subject;
    private String list;

    //default constructor
    public Student() {
        super();
    }

    //parameterized constructor exclude id
    public Student(String firstName, String lastName, String gender, Date dob, String nic, String address, int phone, String email, Date admissionDate, String batch, String status, String[] subject) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.nic = nic;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.admissionDate = admissionDate;
        this.batch = batch;
        this.status = status;
        this.subject = subject;
    }

    //Parameterized Constructor
    public Student(int id, String firstName, String lastName, String gender, Date dob, String nic, String address, int phone, String email, Date admissionDate, String batch, String status, String[] subject) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.nic = nic;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.admissionDate = admissionDate;
        this.batch = batch;
        this.status = status;
        this.subject = subject;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getSubject() {
        return subject;
    }

    public void setSubject(String[] subject) {
        this.subject = subject;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }
}
