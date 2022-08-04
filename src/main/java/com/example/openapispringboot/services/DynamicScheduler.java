package com.example.openapispringboot.services;

import com.example.openapispringboot.repositories.CronJobRepository;
import com.example.openapispringboot.enumable.CronJobType;
import com.example.openapispringboot.entities.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DynamicScheduler implements SchedulingConfigurer {

    @Value("${cron.job.expression}")
    private String cronExpression;

    @Autowired
    private CronJobRepository cronJobRepository;

    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
        scheduler.setPoolSize(1);
        scheduler.initialize();
        return scheduler;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        // get cron from database
        taskRegistrar.addTriggerTask(() -> scheduleCron(getCronExpression(CronJobType.CRON_JOB_A)), t -> {
            CronTrigger crontrigger = new CronTrigger(getCronExpression(CronJobType.CRON_JOB_A));
            return crontrigger.nextExecutionTime(t);
        });
    }

    public String getCronExpression(CronJobType type) {
        Optional<CronJob> cronJob = cronJobRepository.findByType(type);
        return cronJob.isPresent() ? cronJob.get().getValue() : cronExpression;
    }

    public void scheduleCron(String cron) {
        log.info("scheduleCron: -> {}", cron);

    }
}
