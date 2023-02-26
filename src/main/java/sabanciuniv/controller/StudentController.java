package sabanciuniv.controller;

import sabanciuniv.model.Student;
import sabanciuniv.service.StudentService;

import java.util.List;

public class StudentController {

    public StudentService service = new StudentService();

    public List<Student> findAllStudent() {
        return service.findAll();
    }

    public Student findStudent(long id) {
        return service.find(id);
    }

    public void saveStudent(Student student) {
        service.save(student);
    }

    public void deleteStudent(Student student) {
        service.delete(student);
    }

    public void deleteStudent(long id) {
        service.delete(id);
    }
}
