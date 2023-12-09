package com.spring.learn.course;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService)
    {
        this.courseService = courseService;
    }

    @GetMapping("getAll")
    public List<Course> getAllCourses()
    {
        return courseService.getAllCourse();
    }

    @PostMapping("add")
    public Course insetCourse(@RequestBody Course course)
    {
        return courseService.insertCourse(course);
    }

    @PostMapping("update")
    public Course updateCourse(@RequestBody Course course)
    {
        return courseService.updateCourse(course);
    }

    @GetMapping("delete/{id}")
    public String deleteById(@PathVariable int id){
        var result = courseService.deleteCourseBy(id);
        if (result)
        {
            return "Course with the given id deleted";
        }
        else
        {
            return "Course with the given id not available in the records";
        }
    }

    @GetMapping("delAll")
    public String deleteAllCourse()
    {
        return courseService.deleteAllCourse()+" course records are deleted";
    }
}
