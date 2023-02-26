package sabanciuniv.test;

import jakarta.persistence.EntityManager;
import sabanciuniv.controller.CourseController;
import sabanciuniv.controller.InstructorController;
import sabanciuniv.controller.StudentController;
import sabanciuniv.model.*;
import sabanciuniv.utility.EntityManagerUtils;

import java.util.List;

public class TestSchoolApp {
    public static void main(String[] args) {

        if (isDataExists()) saveTestData();

        studentTest();
        courseTest();
        InstructorTest();
    }

    private static boolean isDataExists() {
        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
        return entityManager.createQuery("SELECT c FROM Student c", Student.class).getResultList().size() == 0;
    }

    private static void saveTestData() {
        System.out.println("-------------------- SAVE TEST DATA ALL --------------------");

        Student student1 = new Student("Ferhat Tuncel", "05.08.1988", "Kurtköy" , "E");
        Student student2 = new Student("Duygu Tuncel", "01.01.1988", "Kurtköy" , "K");
        Student student3 = new Student("Uzay Tuncel", "01.01.2020", "Kurtköy" , "E");
        Student student4 = new Student("Student no course", "01.01.2020", "Bursa" , "E");


        Course course1 = new Course("Enterprise Java", "IT526", 3);
        Course course2 = new Course("Machine Learning", "IT541", 3);
        Course course3 = new Course("Software Testing", "IT538", 3);
        Course course4 = new Course("Course no student no instructor", "IT538", 3);


        Instructor ins1 = new PermanentInstructor("Egitmen 1", "İstanbul", "05556667788", 15000);
        Instructor ins2 = new VisitingResearcher("Egitmen 2", "Bursa", "05321112233",15 );
        Instructor ins3 = new VisitingResearcher("Egitmen 3 No Course", "Ankara", "05321112233",15 );


        System.out.println(student1);
        System.out.println(course1);
        System.out.println(ins1);

        course1.setInstuctor(ins1);
        course1.getStudentList().add(student1);
        course1.getStudentList().add(student2);

        course2.setInstuctor(ins2);
        course2.getStudentList().add(student2);
        course2.getStudentList().add(student3);

        course3.setInstuctor(ins1);
        course3.getStudentList().add(student1);

        StudentController studentController = new StudentController();
        studentController.saveStudent(student1);
        studentController.saveStudent(student2);
        studentController.saveStudent(student3);
        studentController.saveStudent(student4);

        InstructorController instructorController = new InstructorController();
        instructorController.saveInstructor(ins1);
        instructorController.saveInstructor(ins2);
        instructorController.saveInstructor(ins3);

        CourseController courseController = new CourseController();
        courseController.saveCourse(course1);
        courseController.saveCourse(course2);
        courseController.saveCourse(course3);
        courseController.saveCourse(course4);
    }

    private static void studentTest() {
        StudentController studentController = new StudentController();

        System.out.println("===========================================================");
        System.out.println("-------------------- FIND ALL STUDENTS --------------------");
        List<Student> allList = studentController.findAllStudent();
        for (Student student : allList) {
            System.out.println(student);
        }

        System.out.println("-------------------- FIND STUDENT --------------------");
        Student foundStudent =  studentController.findStudent(1);
        System.out.println(foundStudent);

        System.out.println("-------------------- UPDATE STUDENT --------------------");
        foundStudent.setStudentName("UpdatedName");
        foundStudent.setStudentBirthDate("01.01.1990");
        foundStudent.setStudentAddress("Updated Address");
        studentController.saveStudent(foundStudent);
        System.out.println(studentController.findStudent(1));

        System.out.println("-------------------- DELETE STUDENT --------------------");
        studentController.deleteStudent(allList.get(allList.size()-1).getId());
    }

    private static void courseTest() {
        CourseController courseController = new CourseController();
        System.out.println("===========================================================");
        System.out.println("-------------------- FIND ALL COURSES --------------------");
        List<Course> allList = courseController.findAllCourse();
        for (Course course : allList) {
            System.out.println(course);
        }

        System.out.println("-------------------- FIND COURSE --------------------");
        Course foundCourse =  courseController.findCourse(1);
        System.out.println(foundCourse);

        System.out.println("-------------------- UPDATE COURSE --------------------");
        foundCourse.setCourseCode("UpdatedCourseCode");
        foundCourse.setCourseName("Updated Course Name");
        courseController.saveCourse(foundCourse);
        System.out.println(courseController.findCourse(1));

        System.out.println("-------------------- DELETE COURSE --------------------");
        courseController.deleteCourse(allList.get(allList.size()-1).getId());
    }

    private static void InstructorTest() {

        InstructorController instructorController = new InstructorController();
        System.out.println("===========================================================");
        System.out.println("-------------------- FIND ALL INSTRUCTOR --------------------");
        List<Instructor> allList = instructorController.findAllInstructor();
        for (Instructor instructor : allList) {
            System.out.println(instructor);
        }

        System.out.println("-------------------- FIND INSTRUCTOR --------------------");
        Instructor foundInstructor =  instructorController.findInstructor(1);
        System.out.println(foundInstructor);

        System.out.println("-------------------- UPDATE INSTRUCTOR --------------------");
        foundInstructor.setInstructorName("Updated Instructor Name");
        foundInstructor.setInstructorAddress("Updated Address");
        foundInstructor.setInstructorPhoneNumber("99988877766");
        instructorController.saveInstructor(foundInstructor);
        System.out.println(instructorController.findInstructor(1));

        System.out.println("-------------------- DELETE INSTRUCTOR --------------------");
        instructorController.deleteInstructor(allList.get(allList.size()-1).getId());
    }
}