package com.example.controller;

import com.example.dao.JobDao;
import com.example.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created on Mart, 2019
 * @author nazifs
 */

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController()
public class JobsController {

    @Autowired
    JobDao jobDao;

    @GetMapping("/job/{id}")
    public Optional<Job> getMember(@PathVariable Long id) throws Exception {
        Optional<Job> jobs = jobDao.findById(id);
        if (!jobs.isPresent()) {
            throw new Exception();
        }

        return jobs;
    }

    @PostMapping("/create-job")
    public Job createTeam(@Valid @RequestBody Job job) {
        return this.jobDao.save(job);
    }
}
