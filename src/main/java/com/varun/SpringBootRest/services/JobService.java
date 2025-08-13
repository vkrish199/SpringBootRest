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

    public void addMultipleJobs(List<JobPost> jobPosts) {
        jobRepo.saveAll(jobPosts);
    }

    public List<JobPost> searchJobPosts(String keyword) {
        return jobRepo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
