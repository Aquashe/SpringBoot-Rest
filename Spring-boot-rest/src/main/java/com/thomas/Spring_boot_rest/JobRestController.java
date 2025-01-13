package com.thomas.Spring_boot_rest;

import com.thomas.Spring_boot_rest.model.JobPost;
import com.thomas.Spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service ;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return  service.getAllJobs();
    }

    @GetMapping(path = "jobPost/{postId}",produces = {"application/json"})
    public JobPost getJob(@PathVariable("postId") int postId){
        System.out.println("job with "+postId+" found");
        return  service.getJob(postId);
    }


    @PostMapping(path = "jobPost",consumes = {"application/json"})
    public JobPost addJob(@RequestBody JobPost jobPost){
        System.out.println("job added");
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
        //It better to return data from collection rather than from parameter itself
    }


    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        System.out.println("job updated");
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
        //It better to return data from collection rather than from parameter itself
    }

    @DeleteMapping("jobPost/{postId}")
    public String deletJob(@PathVariable("postId") int postId){
        System.out.println("job with "+postId+" deleted");
        service.deleteJob(postId);
        return  "job with "+postId+" deleted";
    }

}
