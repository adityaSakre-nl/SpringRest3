package com.spring.learn.course;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository)
    {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourse()
    {
        return courseRepository.findAll();
    }

    public Course insertCourse(Course course)
    {
        return  courseRepository.save(course);
    }

    public Course updateCourse(Course course)
    {
        var pCourse = courseRepository.findById(course.getId());

        if(pCourse.isEmpty())
        {
          throw new RuntimeException("No Course found for enter details");
        }

        var toUpdateCrs = pCourse.get();

        if(course.getCourse_name() != null && !course.getCourse_name().isEmpty())
        {
            toUpdateCrs.setCourse_name(course.getCourse_name());
        }

        if (course.getCourse_description() != null && !course.getCourse_description().isEmpty())
        {
            toUpdateCrs.setCourse_description(course.getCourse_description());
        }
        return courseRepository.save(course);
    }

    public boolean deleteCourseBy(int id)
    {
        var pCourse = courseRepository.findById(id);
        if (pCourse.isPresent())
        {
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public int courseCount()
    {
        return courseRepository.findAll().size();
    }

    public int deleteAllCourse()
    {
        var cnt = courseCount();
        courseRepository.deleteAll();
        return cnt;
    }
}
