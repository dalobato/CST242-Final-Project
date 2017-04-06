package person;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person {
    private ArrayList<String> coursesTook;
    private ArrayList<String> coursesTaking;
    private ArrayList<String> coursesNeeded;
    private double gpa;
    private double creditsTaking;
    private String major;

    public Student(String firstName, String lastName, String phone, Address address, ArrayList<String> coursesTook,
                   ArrayList<String> coursesTaking, ArrayList<String> coursesNeeded, double gpa, double creditsTaking,
                   String major) {
        super(firstName, lastName, phone, address);
        this.coursesTook = coursesTook;
        this.coursesTaking = coursesTaking;
        this.coursesNeeded = coursesNeeded;
        this.gpa = gpa;
        this.creditsTaking = creditsTaking;
        this.major = major;
    }

    public ArrayList<String> getCoursesTook() {
        return coursesTook;
    }

    public void setCoursesTook(ArrayList<String> coursesTook) {
        this.coursesTook = coursesTook;
    }

    public ArrayList<String> getCoursesTaking() {
        return coursesTaking;
    }

    public void setCoursesTaking(ArrayList<String> coursesTaking) {
        this.coursesTaking = coursesTaking;
    }

    // +getCoursesNeeded:ArrayList<String>
    public ArrayList<String> getCoursesNeeded() {
        return coursesNeeded;
    }

    public void setCoursesNeeded(ArrayList<String> coursesNeeded) {
        this.coursesNeeded = coursesNeeded;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getCreditsTaking() {
        return creditsTaking;
    }

    public void setCreditsTaking(double creditsTaking) {
        this.creditsTaking = creditsTaking;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    // +getCreditsByCoursesTaking(coursesTaking:ArrayList<String>)
    public double getCreditsByCoursesTaking(ArrayList<String> coursesTaking) {

        double value = 0;

        for (int i = 0; i < coursesTaking.size(); i++) {
            Scanner st = new Scanner(coursesTaking.get(i));
            while (!st.hasNextDouble()) {
                st.next();
            }
            value += st.nextDouble();
        }

        return value;

    }

    @Override
    public String toString() {
        return "Student [ First Name: " + getFirstName() + "\n Last Name: " + getLastName() + "\n ID: " + getId() + "\n Phone Number: "
                + getPhone() + "\n Address:" + getAddress() + "\n Courses Took:" + coursesTook + "\n Courses Taking:" + coursesTaking
                + "\n Courses Needed:" + coursesNeeded + "\n GPA: " + gpa + "\n Credits Enrolled: " + creditsTaking + "\n Major: " + major + " ]";
    }
}