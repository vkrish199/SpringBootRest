package com.varun.SpringBootRest.services;

import com.varun.SpringBootRest.models.JobPost;
import com.varun.SpringBootRest.repositories.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                    List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                    List.of("HTML", "CSS", "JavaScript", "React")),
            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                    List.of("Python", "Machine Learning", "Data Analysis")),
            new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                    List.of("Networking", "Cisco", "Routing", "Switching")),
            new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                    List.of("iOS Development", "Android Development", "Mobile App"))
    ));

    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost jobPost) {
//        jobRepo.addJob(jobPost);
        jobRepo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
//        return jobRepo.getAllJobs();
        return jobRepo.findAll();
    }

    public JobPost getJob(int postId) {
//        return jobRepo.getJob(postId);
        return jobRepo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
//        jobRepo.updateJob(jobPost);
        jobRepo.save(jobPost);
    }

    public void deleteJob(int postId) {
//        jobRepo.deleteJob(postId);
        jobRepo.deleteById(postId);
    }
}
