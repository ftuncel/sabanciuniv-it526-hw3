package sabanciuniv.model;

import jakarta.persistence.Entity;

@Entity
public class PermanentInstructor extends Instructor {
    // variables
    private double fixedSalary;

    // CTORs
    public PermanentInstructor(String instuctorName, String instuctorAddress, String instuctorPhoneNumber, double fixedSalary) {
        super(instuctorName, instuctorAddress, instuctorPhoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor() {
    }

    // getters and setters

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }


    // custom methods

    // overwrite methods

    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "fixedSalary='" + fixedSalary + '\'' +
                "} " + super.toString();
    }
}
