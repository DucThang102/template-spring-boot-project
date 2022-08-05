package com.example.openapispringboot.controllers;

import com.example.openapispringboot.entities.CronJob;
import com.example.openapispringboot.exceptions.NotFoundException;
import com.example.openapispringboot.repositories.CronJobRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cron-jobs")
public class CronJobController {

    @Autowired
    private CronJobRepository cronJobRepository;

    @PostMapping("")
    public CronJob createCronJob(@RequestBody CronJob cronJob) {
        return cronJobRepository.save(cronJob);
    }

    @GetMapping("")
    public List<CronJob> getCronJobs() {
        return cronJobRepository.findAll();
    }

    @PutMapping("/{id}")
    public CronJob updateCronJob(@PathVariable("id") String id, @RequestBody CronJob cronJob) {
        if (cronJobRepository.existsById(new ObjectId(id))) {
            return cronJobRepository.save(cronJob);
        } else {
            throw new NotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCronJob(@PathVariable("id") String id) {
        cronJobRepository.deleteById(new ObjectId(id));
    }
}
