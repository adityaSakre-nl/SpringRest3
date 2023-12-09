package com.spring.learn.learner;

import com.spring.learn.course.Course;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("learner")
public class LearnerController {

    private final LearnerService learnerService;

    LearnerController(LearnerService learnerService)
    {
        this.learnerService = learnerService;
    }

    @GetMapping("getAll")
    public List<Learner> getAllLearners()
    {
        return learnerService.getAllLearners();
    }

    @GetMapping("get/{id}")
    public Learner getLearnerByID(@PathVariable int id)
    {
        return learnerService.getLearnerById(id);
    }

    @PostMapping("add")
    public Learner insertLearn(@RequestBody Learner learner)
    {
        return learnerService.insertLearner(learner);
    }

    @PostMapping("update")
    public Learner updateLearner(@RequestBody Learner learner)
    {
        return learnerService.updateLearner(learner);
    }

    @PostMapping("assign/{id}")
    public Learner assignCourse(@PathVariable int id, @RequestBody Course course)
    {
        return learnerService.assignCourse(id,course);
    }

    @GetMapping("last-name/{last_name}")
    public List<Learner> findByLastName(@PathVariable String last_name)
    {
        return learnerService.findLearnerbyLast_nameObFirst_name(last_name);
    }
}
