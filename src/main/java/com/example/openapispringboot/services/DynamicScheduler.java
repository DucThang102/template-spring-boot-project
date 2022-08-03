package com.example.openapispringboot.services;

import com.example.openapispringboot.repositories.CronJobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DynamicScheduler implements SchedulingConfigurer {

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
        taskRegistrar.addTriggerTask(() -> scheduleCron(cronJobRepository.findById(0L).get().getValue()), t -> {
            CronTrigger crontrigger = new CronTrigger(cronJobRepository.findById(0L).get().getValue());
            return crontrigger.nextExecutionTime(t);
        });
    }

    public void scheduleCron(String cron) {
        log.info("scheduleCron: Next execution time of this taken from cron expression -> {}", cron);



    }
}
