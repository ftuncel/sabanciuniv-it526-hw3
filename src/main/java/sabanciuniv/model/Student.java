package sabanciuniv.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// POJO - Plain Old Java Object
@Entity
public class Student {
    // variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentName;
    private String studentBirthDate;
    private String studentAddress;
    private String studentGender;

    @ManyToMany(mappedBy = "studentList")
    private List<Course> courseList = new ArrayList<>();

    // CTORs

    public Student(String studentName, String studentBirthDate, String studentAddress, String studentGender) {
        this.studentName = studentName;
        this.studentBirthDate = studentBirthDate;
        this.studentAddress = studentAddress;
        this.studentGender = studentGender;
    }

    public Student() {
    }

    // getter and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentBirthDate() {
        return studentBirthDate;
    }

    public void setStudentBirthDate(String studentBirthDate) {
        this.studentBirthDate = studentBirthDate;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    // custom methods


    // overwrite methods
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentBirthDate='" + studentBirthDate + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentGender='" + studentGender + '\'' +
                '}';
    }
}
