package sabanciuniv.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    // variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String courseCode;
    private int courseCreditScore;

    @ManyToOne
    private Instructor instructor;

    @ManyToMany
    private List<Student> studentList = new ArrayList<>();

    // CTORs
    public Course(String courseName, String courseCode, int courseCreditScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseCreditScore = courseCreditScore;
    }

    public Course() {
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCourseCreditScore() {
        return courseCreditScore;
    }

    public void setCourseCreditScore(int courseCreditScore) {
        this.courseCreditScore = courseCreditScore;
    }

    public Instructor getInstuctor() {
        return instructor;
    }

    public void setInstuctor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    // custom methods

    // overwrite methods

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", courseCreditScore=" + courseCreditScore +
                '}';
    }
}
