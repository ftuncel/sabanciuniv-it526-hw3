package sabanciuniv.controller;


import sabanciuniv.model.Instructor;
import sabanciuniv.service.InstructorService;

import java.util.List;

public class InstructorController {

    public InstructorService service = new InstructorService();

    public List<Instructor> findAllInstructor() {
        return service.findAll();
    }

    public Instructor findInstructor(long id) {
        return service.find(id);
    }

    public void saveInstructor(Instructor instructor) {
        service.save(instructor);
    }

    public void deleteInstructor(Instructor instructor) {
        service.delete(instructor);
    }

    public void deleteInstructor(long id) {
        service.delete(id);
    }
}
