package org.example;

public class Student {
    private String firstName;

    private String lastName ;

    private String studentID;

    private String yearInCollege;

    private boolean intStudent;

    private String streetName;

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

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getYearInCollege() {
        return yearInCollege;
    }

    public void setYearInCollege(String yearInCollege) {
        this.yearInCollege = yearInCollege;
    }

    public boolean isIntStudent() {
        return intStudent;
    }

    public void setIntStudent(boolean intStudent) {
        this.intStudent = intStudent;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    public Student(String firstName, String lastName, String studentID, String yearInCollege, boolean intStudent, String streetName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.yearInCollege = yearInCollege;
        this.intStudent = intStudent;
        this.streetName = streetName;
    }

    public Student(String firstName, String lastName, String studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }
}
