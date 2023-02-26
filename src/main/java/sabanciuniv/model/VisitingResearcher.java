package sabanciuniv.model;

import jakarta.persistence.Entity;

@Entity
public class VisitingResearcher extends Instructor {
    // variables
    private double hourlySalary;
    // CTORs

    public VisitingResearcher(String instuctorName, String instuctorAddress, String instuctorPhoneNumber, double hourlySalary) {
        super(instuctorName, instuctorAddress, instuctorPhoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher() {
    }

    // getters and setters

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }


    // custom methods

    // overwrite methods

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "hourlySalary=" + hourlySalary +
                "} " + super.toString();
    }
}
