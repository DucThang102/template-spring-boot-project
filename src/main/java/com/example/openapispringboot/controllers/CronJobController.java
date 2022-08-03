package com.example.openapispringboot.controllers;

import com.example.openapispringboot.entities.CronJob;
import com.example.openapispringboot.repositories.CronJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cron-jobs")
public class CronJobController {

    @Autowired
    private CronJobRepository cronJobRepository;

    @PostMapping("")
    public CronJob createCronJob(@RequestBody CronJob cronJob) {
        return cronJobRepository.save(cronJob);
    }
}
