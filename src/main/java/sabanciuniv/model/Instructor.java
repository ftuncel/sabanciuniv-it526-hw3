package sabanciuniv.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Instructor {

    // variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String instructorName;
    private String instructorAddress;
    private String instructorPhoneNumber;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courseList = new ArrayList<>();

    // CTORs

    public Instructor(String instructorName, String instructorAddress, String instructorPhoneNumber) {
        this.instructorName = instructorName;
        this.instructorAddress = instructorAddress;
        this.instructorPhoneNumber = instructorPhoneNumber;
    }

    public Instructor() {
    }

    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorAddress() {
        return instructorAddress;
    }

    public void setInstructorAddress(String instructorAddress) {
        this.instructorAddress = instructorAddress;
    }

    public String getInstructorPhoneNumber() {
        return instructorPhoneNumber;
    }

    public void setInstructorPhoneNumber(String instructorPhoneNumber) {
        this.instructorPhoneNumber = instructorPhoneNumber;
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
        return "instructor{" +
                "id=" + id +
                ", instructorName='" + instructorName + '\'' +
                ", instructorAddress='" + instructorAddress + '\'' +
                ", instructorPhoneNumber='" + instructorPhoneNumber + '\'' +
                '}';
    }
}
