package com.spring.learn.learner;

import com.spring.learn.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnerService {

    final private LearnerRepository learnerRepository;

    public LearnerService(LearnerRepository learnerRepository) {
        this.learnerRepository = learnerRepository;
    }


    public List<Learner> getAllLearners()
    {
        return learnerRepository.findAll();
    }

    public Learner getLearnerById(int id)
    {
        var pLearner = learnerRepository.findById(id);
        if(pLearner.isEmpty())
        {
            throw new RuntimeException("Learner with the id:"+ id+" not found");
        }
        return pLearner.get();
    }

    public Learner insertLearner(Learner learner)
    {
        return learnerRepository.save(learner);
    }



    public Learner assignCourse(int id, Course course)
    {
        var pLearner = learnerRepository.findById(id);
        if (pLearner.isEmpty())
        {
            throw new RuntimeException("No learner found to assign");
        }

        var learner = pLearner.get();
        learner.setCourse(course);
        return learnerRepository.save(learner);
    }

    public Learner updateLearner(Learner learner)
    {
        var pLearner = learnerRepository.findById(learner.getId());
        if (pLearner.isEmpty())
        {
            throw new RuntimeException("No learner found to assign");
        }

        var updatedLearner = pLearner.get();

        if (learner.getFirst_name() != null && !learner.getFirst_name().isEmpty())
        {
            updatedLearner.setFirst_name(learner.getFirst_name());
        }
        if (learner.getLast_name() != null && !learner.getLast_name().isEmpty())
        {
            updatedLearner.setLast_name(learner.getLast_name());
        }
        if (learner.getEmail() != null && !learner.getEmail().isEmpty())
        {
            updatedLearner.setEmail(learner.getEmail());
        }
        if (learner.getPassword() != null && !learner.getPassword().isEmpty())
        {
            updatedLearner.setPassword(learner.getPassword());
        }

        System.out.println(learner);
        System.out.println(updatedLearner);
        return learnerRepository.save(updatedLearner);
    }

    public void deleteLearnerById(int id)
    {
        learnerRepository.deleteById(id);
    }

    public int deleteAll()
    {
        var cnt = learnerRepository.findAll().size();
        learnerRepository.deleteAll();
        return  cnt;
    }

    public List<Learner> findLearnerbyLast_nameObFirst_name(String last_name)
    {
        return learnerRepository.findByLast_nameOrderByFirst_nameAsc(last_name);
    }

}
