package com.thomas.Spring_boot_rest.service;

import com.thomas.Spring_boot_rest.model.JobPost;
import com.thomas.Spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    public JobRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(JobRepo repo) {
        this.repo = repo;
    }

    private JobRepo repo;

    public  void addJob(JobPost job){
        repo.addJob(job);
    }

    public  List<JobPost> getAllJobs()
    {
        return  repo.getAllJobs();
    }



}
