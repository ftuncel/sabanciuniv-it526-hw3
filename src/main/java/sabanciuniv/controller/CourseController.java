package sabanciuniv.controller;

import sabanciuniv.model.Course;
import sabanciuniv.service.CourseService;

import java.util.List;

public class CourseController {

    public CourseService service = new CourseService();

    public List<Course> findAllCourse() {
        return service.findAll();
    }

    public Course findCourse(long id) {
        return service.find(id);
    }

    public void saveCourse(Course course) {
        service.save(course);
    }

    public void deleteCourse(Course course) {
        service.delete(course);
    }

    public void deleteCourse(long id) {
        service.delete(id);
    }


}
